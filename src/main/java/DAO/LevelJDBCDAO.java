package DAO;

import Model.Level;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LevelJDBCDAO implements LevelDAO {

    private Connection connectToDB() throws IOException, SQLException {
        Properties prop = LoginData.readProperties("src/main/resources/database.properties");
        String url = prop.getProperty("db.url");
        String user = prop.getProperty("db.user");
        String password = prop.getProperty("db.passwd");

        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) throws IOException, SQLException {
        LevelJDBCDAO levelJDBCDAO = new LevelJDBCDAO();
        System.out.println(levelJDBCDAO.getLevelsList());
    }


    @Override
    public boolean insertNewLevel(Level level) throws IOException, SQLException {
        System.out.println(level);
        Connection connection = connectToDB();

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO level (name, description, price, picture_url)"+
                    "VALUES (?, ?, ?, ?);");
            statement.setString(1, level.getName());
            statement.setString(2, level.getDescription());
            statement.setInt(3, level.getPrice());
            statement.setString(4, level.getPictureUrl());
            statement.executeUpdate();
            System.out.println("This level has been added successfully to database! ");
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to insert new level, please try again");
        } finally {
            connection.close();
        }
        return false;
    }

    @Override
    public boolean updateLevel() {
        return false;
    }

    @Override
    public boolean deleteLevel() {
        return false;
    }

    @Override
    public List<Level> getLevelsList() throws IOException, SQLException {
        Connection connection = connectToDB();
        List<Level> levelsList = new ArrayList<>();
        ResultSet rs;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM level;");
            rs = statement.executeQuery();

            while (rs.next()) {
                Level level = new Level(rs.getInt("level_id"), rs.getString("name"),
                        rs.getString("description"), rs.getInt("price"), rs.getDate("date_of_adding"),
                        rs.getString("picture_url"));
                levelsList.add(level);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

        return levelsList;
    }
}
