package DAO;

import exception.ReadException;
import model.Artifact;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ArtifactJDBCDAO implements ArtifactDAO {

    private ResultSet resultSet;

    private Connection connectToDB() {
        Properties prop = null;
        try {
            prop = PropertiesReader.readProperties("src/main/resources/database.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = prop.getProperty("db.url");
        String user = prop.getProperty("db.user");
        String password = prop.getProperty("db.passwd");

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connectToDB();
    }

    private ResultSet askForAllArtifacts() throws SQLException {
        String query = "SELECT * FROM artifact";
        Statement statement;
            statement = connectToDB().createStatement();
            resultSet = statement.executeQuery(query);

        return resultSet;
    }

    @Override
    public List<Artifact> getAllArtifacts() throws ReadException {
        List<Artifact> allArtifacts = new ArrayList<Artifact>();
        try {
            resultSet = askForAllArtifacts();

            while (resultSet.next()) {
                Artifact artifact = new Artifact.Builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .description(resultSet.getString(3))
                        .value(resultSet.getInt(4))
                        .type(resultSet.getString(5))
                        .dateOfAdding(resultSet.getDate(6))
                        .pictureUrl(resultSet.getString(7))
                        .build();
                allArtifacts.add(artifact);
            }
        }catch(SQLException e){
            throw new ReadException("you cannot connect do DB");

        }
        return allArtifacts;
    }

    @Override
    public void addArtifact(Artifact artifact) {
        String query = "INSERT INTO artifact values(default,?,?,?,?,default,?);";
        try {
            PreparedStatement preparedStatement = connectToDB().prepareStatement(query);
            preparedStatement.setString(1, artifact.getName());
            preparedStatement.setString(2, artifact.getDescription());
            preparedStatement.setInt(3, artifact.getValue());
            preparedStatement.setString(4, artifact.getType());
            preparedStatement.setString(5, artifact.getPictureUrl());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteArtifact(int id) {
        String query = "delete from artifact where artifact_id = ?;";
        try {
            PreparedStatement preparedStatement = connectToDB().prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public int getNextAvailableID() {
        String query = "SELECT artifact_id FROM artifact order by artifact_id desc limit 1";
        int nextAvailableId = 0;

        try {
            Statement statement = connectToDB().createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                nextAvailableId = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return nextAvailableId;
    }

    @Override
    public Artifact getArtifactById(int id) {
        String query = "SELECT * FROM artifact WHERE artifact_id = ?";
        Artifact artifact = new Artifact();
        try {
            PreparedStatement preparedStatement = connectToDB().prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Artifact(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return artifact;
    }

    @Override
    public void updateArtifact(int artifactToUpdateId, Artifact artifactUpdated) {
        String query = "UPDATE artifact set name =?,description = ?, value = ?, type = ? WHERE artifact_id = ?;";
        try {
            PreparedStatement preparedStatement = connectToDB().prepareStatement(query);
            preparedStatement.setString(1, artifactUpdated.getName());
            preparedStatement.setString(2, artifactUpdated.getDescription());
            preparedStatement.setInt(3, artifactUpdated.getValue());
            preparedStatement.setString(4, artifactUpdated.getType());
            preparedStatement.setInt(5, artifactToUpdateId);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public int getArtifactsCount() throws SQLException {
        String query = "SELECT COUNT(*) FROM artifact";
        PreparedStatement preparedStatement = connectToDB().prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        throw new SQLException();
    }
}
