package DAO;

import Model.Quest;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class QuestJDBCDAO implements QuestDAO {

    private Connection connectToDB() throws IOException, SQLException {
        Properties prop = PropertiesReader.readProperties("src/main/resources/database.properties");
        String url = prop.getProperty("db.url");
        String user = prop.getProperty("db.user");
        String password = prop.getProperty("db.passwd");

        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void insertQuest(Quest quest) {
        try (Connection connection = connectToDB()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO quest (name, desciption, value, type, date, picture_url) VALUES (?, ?, ?, ?, ?, ?);");
            statement.setString(1, quest.getName());
            statement.setString(2, quest.getDescription());
            statement.setInt(3, quest.getValue());
            statement.setInt(4, quest.getType().getValue());
            statement.setDate(5, quest.getDateOfAdding());
            statement.setString(6, quest.getPictureUrl());
            statement.execute();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Quest> getAllQuests() {
        List<Quest> questsList = new ArrayList<>();

        try (Connection connection = connectToDB()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM quest;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Quest quest = extractQuestFromResultSet(rs);
                questsList.add(quest);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return questsList;
    }

    private Quest extractQuestFromResultSet(ResultSet rs) throws SQLException {
        return new Quest(rs.getInt("quest_id"), rs.getString("name"), rs.getString("description"),
                rs.getInt("value"), rs.getByte("type"), rs.getDate("date_of_adding"), rs.getString("picture_url"));
    }
}

//    CREATE TABLE quest(
//    quest_id serial PRIMARY KEY UNIQUE,
//    name varchar(50) NOT NULL,
//    desciption varchar(100) NOT NULL,
//    value integer,
//    type BIT NOT NULL,
//    date_of_adding date NOT NULL DEFAULT CURRENT_DATE,
//    picture_url varchar(100)
//);
