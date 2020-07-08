package DAO;

import exception.ReadException;
import model.CodecoolerClass;
import org.postgresql.ds.PGSimpleDataSource;

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
        return null;
    }

    @Override
    public void editCodecoolerClass(int id, CodecoolerClass codecoolerClass) throws ReadException {
        
    }
}
