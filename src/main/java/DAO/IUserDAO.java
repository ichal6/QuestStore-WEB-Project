package DAO;

import Model.CMSUser;
import Model.UserBuilder;

import java.sql.Date;
import java.util.Map;

public interface IUserDAO {
    void addUser(int ID, String name, String email,
                 String password, String city, Date dateOfAdding,
                 String pictureURL, boolean isAdmin) throws ReadException;
    void addUser(UserBuilder newUser) throws ReadException;
    void addUser(CMSUser user) throws ReadException;
    void editUser(int ID, CMSUser user) throws ReadException;
    void deleteUser(int ID) throws ReadException;
    Map<Integer, CMSUser> getAllUsers() throws ReadException;
    Map<Integer, CMSUser> getAllAdmins() throws ReadException;
    Map<Integer, CMSUser> getAllMentors() throws ReadException;
    CMSUser getDBUser() throws ReadException;
}
