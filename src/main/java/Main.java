import DAO.CodecoolerClassDAO;
import DAO.CodecoolerClassJDBCDAO;
import DAO.CodecoolerDAO;
import DAO.DataSourceReader;
import exception.ReadException;
import model.CodecoolerClass;
import org.postgresql.ds.PGSimpleDataSource;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CodecoolerClass simpleClass = new CodecoolerClass
                .Builder()
                .withID(1)
                .withCity("Mielec")
                .withName("Nasza Klasa")
                .build();

        PGSimpleDataSource dataSource = null;

        try {
            dataSource = DataSourceReader.getDataSource("src/main/resources/database.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }

        CodecoolerClassDAO dao = new CodecoolerClassJDBCDAO(dataSource);

        try {
            System.out.println(dao.getCodecoolerClassById(1));
        } catch (ReadException e) {
            e.printStackTrace();
        }
    }
}
