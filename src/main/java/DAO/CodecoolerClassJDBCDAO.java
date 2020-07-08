package DAO;

import exception.ReadException;
import model.CMSUser;
import model.Codecooler;
import model.CodecoolerClass;
import org.postgresql.ds.PGSimpleDataSource;

import java.sql.*;
import java.util.List;

public class CodecoolerClassJDBCDAO implements CodecoolerClassDAO{
    private PGSimpleDataSource dataSource;

    public CodecoolerClassJDBCDAO(PGSimpleDataSource ds){
        this.dataSource = ds;
    }

    @Override
    public void addCodecoolerClass(CodecoolerClass codecoolerClass) throws ReadException {

    }

    @Override
    public void deleteCodecoolerClass(int id) throws ReadException {

    }

    @Override
    public List<CodecoolerClass> getAllCodecoolerClasss() throws ReadException {
        return null;
    }

    @Override
    public CodecoolerClass getCodecoolerClassById(int id) throws ReadException {
        try(Connection con = this.dataSource.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM class WHERE class_id = ?")) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            return createNewClass(rs);
        } catch (SQLException ex) {
            throw new ReadException("You cannot access to database." + ex);
        }
    }

    @Override
    public void editCodecoolerClass(int id, CodecoolerClass codecoolerClass) throws ReadException {
        
    }

    private CodecoolerClass createNewClass(ResultSet rs) throws SQLException, ReadException {
        if(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String city = rs.getString(3);
            Date startDate = rs.getDate(4);
            Date endDate = rs.getDate(5);

            return new CodecoolerClass.Builder()
                    .withID(id)
                    .withName(name)
                    .withCity(city)
                    .withStartDate(startDate)
                    .withEndDate(endDate)
                    .build();
        }
        else{
            throw new ReadException("This class doesn't exist!");
        }
    }
}
