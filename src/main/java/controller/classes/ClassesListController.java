package controller.classes;

import DAO.CodecoolerClassDAO;
import DAO.CodecoolerClassJDBCDAO;
import DAO.DataSourceReader;
import exception.ConnectionException;
import exception.ReadException;
import model.CodecoolerClass;
import org.postgresql.ds.PGSimpleDataSource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClassesList", urlPatterns = "/classes")
public class ClassesListController extends HttpServlet{
    private PGSimpleDataSource ds;
    private CodecoolerClassDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            ds = DataSourceReader.getDataSource("src/main/resources/database.properties");
        } catch (IOException e) {
            throw new ConnectionException(e.getMessage());
        }
        dao = new CodecoolerClassJDBCDAO(ds);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CodecoolerClass> codecoolerClassList = null;
        try {
             codecoolerClassList = dao.getAllCodecoolerClasss();
        } catch (ReadException e) {
            req.setAttribute("error_message", e.getMessage());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/html-cms/error_page.jsp");
            dispatcher.forward(req, resp);
        }

        req.setAttribute("allClassList", codecoolerClassList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/html-cms/classes_list.jsp");
        dispatcher.forward(req, resp);
    }
}
