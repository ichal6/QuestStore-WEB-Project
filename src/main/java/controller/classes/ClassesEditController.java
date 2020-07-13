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
import java.util.Map;

@WebServlet(name = "ClassesEditController", urlPatterns = "/classes/edit")
public class ClassesEditController extends HttpServlet {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fillDetailsAboutClass(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/html-cms/classes_update.jsp");
        dispatcher.forward(request, response);
    }

    public void fillDetailsAboutClass(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Map<String, String[]> parameters = request.getParameterMap();
        Integer id = null;
        CodecoolerClass codecoolerClass = null;
        try{
           id = Integer.parseInt(parameters.get("id")[0]);
        } catch(NumberFormatException ex){
            response.sendRedirect("/classes");
        }  catch (NullPointerException ex) {
            response.sendRedirect("/classes");
        }

        try {
            codecoolerClass = dao.getCodecoolerClassById(id);
        } catch (ReadException e) {
            response.sendRedirect("/classes");
        }

        request.setAttribute("classToEdit", codecoolerClass);
    }
}
