package DAO;

import exception.ConnectionException;
import exception.ReadException;
import model.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TeamJDBCDAO implements TeamDAO {

    private Connection connectToDB() {
        try {
            Properties prop = PropertiesReader.readProperties("src/main/resources/database.properties");
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String password = prop.getProperty("db.passwd");
            return DriverManager.getConnection(url, user, password);
        } catch (IOException | SQLException e) {
            throw new ConnectionException("Sorry, couldn't connect to database");
        }
    }

    @Override
    public void addTeam(Team team) throws ReadException {
        try (Connection connection = connectToDB()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO team (name, city, start_date) VALUES (?, ?, ?);");
            statement.setString(1, team.getName());
            statement.setString(2, team.getCity());
            statement.setDate(3, team.getStartDate());
            statement.execute();
        } catch (SQLException e) {
            throw new ReadException("Sorry, couldn't insert this team to database");
        }
    }

    @Override
    public void deleteTeam(int id) throws ReadException {
        try (Connection connection = connectToDB()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM team WHERE team_id = ?;");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ReadException("Sorry, couldn't delete this team");
        }
    }

    @Override
    public List<Team> getAllTeams() throws ReadException {
        List<Team> teamsList = new ArrayList<>();
        try (Connection connection = connectToDB()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM team;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Team team = extractTeamFromResultSet(rs);
                teamsList.add(team);
            }
        } catch (SQLException e) {
            throw new ReadException("Sorry, getting teams from database is currently impossible");
        }
        return teamsList;
    }

    @Override
    public Team getTeamById(int id) throws ReadException {
        return null;
    }

    @Override
    public void editTeam(int id, Team team) throws ReadException {

    }

    private Team extractTeamFromResultSet(ResultSet rs) throws SQLException {
        return new Team.Builder()
                .withID(rs.getInt("team_id"))
                .withName(rs.getString("name"))
                .withCity(rs.getString("city"))
                .withStartDate(rs.getDate("start_date"))
                .build();
    }
}
