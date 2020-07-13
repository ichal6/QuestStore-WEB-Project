package controller.classes;

import DAO.CodecoolerClassDAO;
import DAO.CodecoolerClassJDBCDAO;
import DAO.DataSourceReader;
import exception.ConnectionException;
import exception.ReadException;
import org.postgresql.ds.PGSimpleDataSource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "ClassesDeleteController", urlPatterns = "/classes/delete")
public class ClassesDeleteController extends HttpServlet {
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameters = request.getParameterMap();
        String id = parameters.get("id")[0];
        int idClass = 0;
        try {
            idClass = Integer.parseInt(id);
        } catch(NumberFormatException ex){
            response.sendRedirect("/dashboard");
        }
        try {
            dao.deleteCodecoolerClass(idClass);
        } catch (ReadException ex) {
            request.setAttribute("error_message", ex.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/html-cms/error_page.jsp");
            dispatcher.forward(request, response);
        }
        response.sendRedirect("/classes");
    }

}
