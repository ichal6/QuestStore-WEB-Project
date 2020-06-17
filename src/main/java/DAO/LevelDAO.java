package DAO;

import Model.Level;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface LevelDAO {

    boolean insertNewLevel(Level level) throws IOException, SQLException;
    boolean updateLevel();
    boolean deleteLevel();
    List<Level> getLevelsList() throws IOException, SQLException;

}
