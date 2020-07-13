package DAO;

import exception.ReadException;
import model.Codecooler;
import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CodecoolerJDBCDAO implements CodecoolerDAO{
    private PGSimpleDataSource ds;

    public CodecoolerJDBCDAO(PGSimpleDataSource ds){
        this.ds = ds;
    }

    @Override
    public void addCodecooler(Codecooler codecooler) throws ReadException {

    }

    @Override
    public void deleteCodecooler(int id) throws ReadException {

    }

    @Override
    public List<Codecooler> getAllCodecoolers() throws ReadException {
        List<Codecooler> codecoolerList = new LinkedList<>();
        try(Connection con = ds.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM codecooler");
            ResultSet rs = pst.executeQuery()){
            while(rs.next()){
                String name = rs.getString(2);
                String email = rs.getString(3);
                int classId = rs.getInt(8);
                Codecooler newCodecooler = new Codecooler.Builder()
                        .withName(name)
                        .withEmail(email)
                        .withClassId(classId)
                        .build();

                codecoolerList.add(newCodecooler);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return codecoolerList;
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
