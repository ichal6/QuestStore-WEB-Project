package DAO;

import exception.ReadException;
import model.Level;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface LevelDAO {

    void insertNewLevel(Level level) throws IOException, ReadException;
    void updateLevel(Level level, int levelId) throws IOException, ReadException;
    void  deleteLevel(int levelId) throws IOException, ReadException;
    List<Level> getLevelsList() throws IOException, ReadException;
    Level getLevelToUpdate(int levelId) throws IOException, ReadException;

}
