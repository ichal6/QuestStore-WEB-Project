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
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "ClassesAddNew", urlPatterns = "/classes/add")
public class ClassesAddNewController extends HttpServlet {
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
        String name = request.getParameter("class-name");
        String city = request.getParameter("class-city");
        String startDateAsString = request.getParameter("class-start-date");
        String endDateAsString = request.getParameter("class-end-date");

        if(name == null || startDateAsString == null || endDateAsString == null){
            response.sendRedirect("/html-cms/classes_add_new.jsp");
        }

        if(name.length() == 0){
            request.setAttribute("infoMessage", "You should input name of class.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/html-cms/classes_add_new.jsp");
            dispatcher.forward(request, response);
        }

        try {
            new SimpleDateFormat("yyyy-MM-dd").parse(startDateAsString);
            new SimpleDateFormat("yyyy-MM-dd").parse(endDateAsString);
        } catch (ParseException e) {
            request.setAttribute("infoMessage", "You put incorrect date. You should input in format: YYYY-MM-DD .");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/html-cms/classes_add_new.jsp");
            dispatcher.forward(request, response);
        }

        CodecoolerClass codecoolerClass = new CodecoolerClass.Builder()
                .withName(name)
                .withCity(city)
                .withStartDate(java.sql.Date.valueOf(startDateAsString))
                .withEndDate(java.sql.Date.valueOf(endDateAsString))
                .build();

        try {
            dao.addCodecoolerClass(codecoolerClass);
        } catch (ReadException e) {
            request.setAttribute("error_message", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/html-cms/error_page.jsp");
            dispatcher.forward(request, response);
        }

        request.setAttribute("infoMessage", "Class has added successful");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/html-cms/classes_add_new.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/html-cms/classes_add_new.jsp");
    }
}
