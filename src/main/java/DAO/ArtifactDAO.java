package DAO;

import Model.Artifact;

import java.util.List;

public interface ArtifactDAO {

    List<Artifact> getAllArtifacts();

    Artifact getArtifactById(int id);

    void addArtifact(Artifact artifact);

    void deleteArtifact(int id);

    int getNextAvailableID();

    void updateArtifact(int artifactToUpdateId, Artifact artifactUpdated);

}
