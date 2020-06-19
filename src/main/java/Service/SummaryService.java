package Service;

import DAO.PropertiesReader;
import DAO.UserDAO;
import Model.SummaryAdmin;
import Model.SummaryMentor;
import Exception.ReadException;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class SummaryService {
    private UserDAO userDAO;

    public SummaryService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    // all methods with DB queries will gradually be moved to specific DAOs, when they are made

    private Connection connectToDB() throws IOException, SQLException {
        Properties prop = PropertiesReader.readProperties("src/main/resources/database.properties");
        String url = prop.getProperty("db.url");
        String user = prop.getProperty("db.user");
        String password = prop.getProperty("db.passwd");

        return DriverManager.getConnection(url, user, password);
    }

    public SummaryMentor getSummaryMentor() throws SQLException, IOException {
        Connection connectionToDB = connectToDB();
        Statement statement = connectionToDB.createStatement();

        return new SummaryMentor(
                getCodecoolersCount(statement),
                getClassesCount(statement),
                getTeamsCount(statement),
                getQuestsCount(statement),
                getArtifactsCount(statement)
        );
    }

    public SummaryAdmin getSummaryAdmin() throws SQLException, IOException, ReadException {
        Connection connectionToDB = connectToDB();
        Statement statement = connectionToDB.createStatement();

        return new SummaryAdmin(
                getCodecoolersCount(statement),
                getClassesCount(statement),
                getTeamsCount(statement),
                getQuestsCount(statement),
                getArtifactsCount(statement),
                getAdminsCount(statement),
                getMentorsCount(statement),
                getLevelsCount(statement)
        );
    }

    private int getMentorsCount(Statement statement) throws ReadException {
        return userDAO.getMentorsCount();
    }

    private int getAdminsCount(Statement statement) throws ReadException {
        return userDAO.getAdminsCount();
    }

    private int getCodecoolersCount(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM codecooler; ");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        throw new SQLException();
    }

    private int getClassesCount(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM class; ");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        throw new SQLException();
    }

    private int getTeamsCount(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM team; ");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        throw new SQLException();
    }

    private int getQuestsCount(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM quest; ");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        throw new SQLException();
    }

    private int getArtifactsCount(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM artifact; ");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        throw new SQLException();
    }

    private int getLevelsCount(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM level; ");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        throw new SQLException();
    }
}
