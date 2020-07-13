package DAO;

import exception.ReadException;
import model.CodecoolerClass;
import org.postgresql.ds.PGSimpleDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CodecoolerClassJDBCDAO implements CodecoolerClassDAO {
    private PGSimpleDataSource dataSource;

    public CodecoolerClassJDBCDAO(PGSimpleDataSource ds) {
        this.dataSource = ds;
    }

    @Override
    public void addCodecoolerClass(CodecoolerClass codecoolerClass) throws ReadException {
        try (Connection con = this.dataSource.getConnection();
             PreparedStatement pst = con.prepareStatement("INSERT INTO class VALUES (DEFAULT, ?,?,?,?)")) {
            pst.setString(1, codecoolerClass.getName());
            pst.setString(2, codecoolerClass.getCity());
            pst.setDate(3, codecoolerClass.getStartDate());
            pst.setDate(4, codecoolerClass.getEndDate());

            pst.execute();
        } catch (SQLException ex) {
            throw new ReadException("You cannot add class. " + ex.getMessage());
        }
    }

    @Override
    public void deleteCodecoolerClass(int id) throws ReadException {
        deleteCodecoolerAssignToClasses(id);
        try (Connection con = this.dataSource.getConnection();
             PreparedStatement pst = con.prepareStatement("DELETE FROM class WHERE class_id = ?")) {
            pst.setInt(1, id);
            pst.execute();
        } catch (SQLException ex) {
            throw new ReadException("You cannot delete this class. " + ex.getMessage());
        }
    }

    @Override
    public List<CodecoolerClass> getAllCodecoolerClasss() throws ReadException {
        List<CodecoolerClass> classes = new ArrayList<>();
        try (Connection con = this.dataSource.getConnection();
             PreparedStatement pst = con.prepareStatement("SELECT * FROM class")) {
            ResultSet rs = pst.executeQuery();
            createListOfClasses(rs, classes);
        } catch (SQLException ex) {
            throw new ReadException("You cannot access to classes. " + ex.getMessage());
        }
        return classes;
    }

    @Override
    public CodecoolerClass getCodecoolerClassById(int id) throws ReadException {
        try (Connection con = this.dataSource.getConnection();
             PreparedStatement pst = con.prepareStatement("SELECT * FROM class WHERE class_id = ?")) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            return createNewClass(rs);
        } catch (SQLException ex) {
            throw new ReadException("You cannot access to this class. " + ex);
        }
    }

    @Override
    public void editCodecoolerClass(int id, CodecoolerClass codecoolerClass) throws ReadException {
        try (Connection con = this.dataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(
                     "UPDATE class SET name = ?, city = ?, start_date = ?, end_date = ? WHERE class_id = ?")) {
            pst.setString(1, codecoolerClass.getName());
            pst.setString(2, codecoolerClass.getCity());
            pst.setDate(3, codecoolerClass.getStartDate());
            pst.setDate(4, codecoolerClass.getEndDate());
            pst.setInt(5, id);

            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new ReadException("You cannot edit this class. " + ex.getMessage());
        }
    }

    private CodecoolerClass createNewClass(ResultSet rs) throws SQLException, ReadException {
        if (rs.next()) {
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
        } else {
            throw new ReadException("This class doesn't exist!");
        }
    }

    private List<CodecoolerClass> createListOfClasses(ResultSet rs, List<CodecoolerClass> listOfClasses) throws SQLException, ReadException {
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String city = rs.getString(3);
            Date startDate = rs.getDate(4);
            Date endDate = rs.getDate(5);

            listOfClasses.add(new CodecoolerClass.Builder()
                    .withID(id)
                    .withName(name)
                    .withCity(city)
                    .withStartDate(startDate)
                    .withEndDate(endDate)
                    .build());
        }

        return listOfClasses;
    }

    private void deleteCodecoolerAssignToClasses(int id) throws ReadException{
        try(Connection con = dataSource.getConnection();
            PreparedStatement pst = con.prepareStatement("DELETE FROM codecooler WHERE class_id=?")){
            pst.setInt(1, id);
            pst.execute();
        }catch (SQLException ex){
            throw new ReadException("You cannot delete codecoolers. " + ex.getMessage());
        }
    }
}
