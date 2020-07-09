package DAO;

import exception.ReadException;
import model.Codecooler;

import java.util.List;

public class CodecoolerJDBCDAO implements CodecoolerDAO {

    @Override
    public void addCodecooler(Codecooler codecooler) throws ReadException {

    }

    @Override
    public void deleteCodecooler(int id) throws ReadException {

    }

    @Override
    public List<Codecooler> getAllCodecoolers() throws ReadException {
        return null;
    }

    @Override
    public Codecooler getCodecoolerById(int id) throws ReadException {
        return null;
    }

    @Override
    public Codecooler getCodecooler(String email, String password) throws ReadException {
        return null;
    }

    @Override
    public void editCodecooler(int id, Codecooler codecooler) throws ReadException {

    }

    @Override
    public boolean checkCodecooler(String email, String password) throws ReadException {
        return false;
    }

    @Override
    public List<Codecooler> getCodecoolersByTeamId(int teamId) throws ReadException {
        return null;
    }

    @Override
    public List<Codecooler> getCodecoolersByClassId(int classId) throws ReadException {
        return null;
    }

    @Override
    public int getCodecoolersCount() throws ReadException {
        return 0;
    }
}
