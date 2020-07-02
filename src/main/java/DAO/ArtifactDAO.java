package DAO;

import exception.ReadException;
import model.Artifact;

import java.sql.SQLException;
import java.util.List;

public interface ArtifactDAO {

    List<Artifact> getAllArtifacts() throws ReadException;

    Artifact getArtifactById(int id);

    void addArtifact(Artifact artifact);

    void deleteArtifact(int id);

    int getNextAvailableID();

    void updateArtifact(int artifactToUpdateId, Artifact artifactUpdated);

    int getArtifactsCount() throws SQLException;

}
