package controller.classes;

import DAO.CodecoolerDAO;
import DAO.CodecoolerJDBCDAO;
import DAO.DataSourceReader;
import exception.ConnectionException;
import exception.ReadException;
import model.Codecooler;
import org.postgresql.ds.PGSimpleDataSource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "ClassesDeleteCodecooler",urlPatterns = "/classes/delete-codecooler")
public class ClassesDeleteCodecooler extends HttpServlet {
    private PGSimpleDataSource ds;
    private CodecoolerDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            ds = DataSourceReader.getDataSource("src/main/resources/database.properties");
        } catch (IOException e) {
            throw new ConnectionException(e.getMessage());
        }
        dao = new CodecoolerJDBCDAO(ds);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doDelete(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameters = request.getParameterMap();
        String id = parameters.get("id")[0];
        int idCodecooler = 0;
        try {
            idCodecooler = Integer.parseInt(id);
        } catch(NumberFormatException ex){
            response.sendRedirect("/dashboard");
        }
        try {
            Codecooler codecooler = dao.getCodecoolerById(idCodecooler);
            codecooler.setClassId(null);
            dao.editCodecooler(idCodecooler, codecooler);
        } catch (ReadException ex) {
            request.setAttribute("error_message", ex.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/html-cms/error_page.jsp");
            dispatcher.forward(request, response);
        }
        response.sendRedirect("/classes");
    }
}
