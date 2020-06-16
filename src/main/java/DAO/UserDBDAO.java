package DAO;

import Model.CMSUser;
import Model.UserBuilder;

import java.io.IOException;
import java.sql.*;
import java.util.Map;
import java.util.Properties;

public class UserDBDAO implements IUserDAO {
    private final String DBUrl;
    private final String DBUser;
    private final String DBPassword;
    private Map<Integer, CMSUser> dicOfUser;

    public UserDBDAO(String path) throws IOException {
        Properties prop = LoginData.readProperties(path);
        DBUrl = prop.getProperty("db.url");
        DBUser = prop.getProperty("db.user");
        DBPassword = prop.getProperty("db.passwd");

    }

    @Override
    public void addUser(int ID, String name, String email, String password, String city,
                        Date dateOfAdding, String pictureURL, boolean isAdmin) throws ReadException {
        String query = "INSERT INTO cms_user VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(DBUrl, DBUser, this.DBPassword);
             PreparedStatement pst = con.prepareStatement(query))
        {
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, password);
            pst.setString(4, city);
            pst.setDate(5, dateOfAdding);
            pst.setString(6, pictureURL);
            pst.setBoolean(7, isAdmin);
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new ReadException("You cannot insert user");
        }
    }

    @Override
    public void addUser(UserBuilder newUser) {

    }

    @Override
    public void addUser(CMSUser user) throws ReadException {
        String query = "INSERT INTO cms_user VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(DBUrl, this.DBUser, this.DBPassword);
             PreparedStatement pst = con.prepareStatement(query))
        {
            pst.setString(1, user.getName());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getCity());
            pst.setDate(5, user.getDateOfAdding());
            pst.setString(6, user.getPictureURL());
            pst.setBoolean(7, user.isAdmin());
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new ReadException("You cannot insert user");
        }
    }

    @Override
    public void editUser(int ID, CMSUser user) {

    }

    @Override
    public void deleteUser(int ID) {

    }

    @Override
    public Map<Integer, CMSUser> getAllUsers() {
        return null;
    }

    @Override
    public Map<Integer, CMSUser> getAllAdmins() {
        return null;
    }

    @Override
    public Map<Integer, CMSUser> getAllMentors() {
        return null;
    }

    @Override
    public CMSUser getDBUser() {
        return null;
    }
}
