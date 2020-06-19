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

    @Override
    public void insertNewLevel(Level level) throws IOException, SQLException {
        Connection connection = connectToDB();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO level (name, description, price, picture_url)" +
                "VALUES (?, ?, ?, ?);");
        statement.setString(1, level.getName());
        statement.setString(2, level.getDescription());
        statement.setInt(3, level.getPrice());
        statement.setString(4, level.getPictureUrl());
        statement.executeUpdate();

    }

    @Override
    public boolean updateLevel() {
        return false;
    }

    @Override
    public void deleteLevel(int levelId) throws IOException, SQLException {
        Connection connection = connectToDB();

        PreparedStatement statement = connection.prepareStatement("DELETE FROM level WHERE level_id=" + " ? ;");
        statement.setInt(1, levelId);
        statement.executeUpdate();
    }

    @Override
    public List<Level> getLevelsList() throws IOException, SQLException {
        Connection connection = connectToDB();
        List<Level> levelsList = new ArrayList<>();
        ResultSet rs;

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM level;");
        rs = statement.executeQuery();

        while (rs.next()) {
            Level level = new Level(rs.getInt("level_id"), rs.getString("name"),
                    rs.getString("description"), rs.getInt("price"), rs.getDate("date_of_adding"),
                    rs.getString("picture_url"));
            levelsList.add(level);
        }
        return levelsList;
    }
}

