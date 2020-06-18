package DAO;

import Model.Level;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface LevelDAO {

    void insertNewLevel(Level level) throws IOException, SQLException;
    boolean updateLevel();
    void  deleteLevel(int levelId) throws IOException, SQLException;
    List<Level> getLevelsList() throws IOException, SQLException;

}
