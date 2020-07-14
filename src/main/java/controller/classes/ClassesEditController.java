package controller.classes;

import DAO.*;
import exception.ConnectionException;
import exception.ReadException;
import model.Codecooler;
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
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@WebServlet(name = "ClassesEditController", urlPatterns = "/classes/edit")
public class ClassesEditController extends HttpServlet {
    private PGSimpleDataSource ds;
    private CodecoolerClassDAO classDAO;
    private CodecoolerDAO codecoolerDAO;
    private Integer id = null;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            ds = DataSourceReader.getDataSource("src/main/resources/database.properties");
        } catch (IOException e) {
            throw new ConnectionException(e.getMessage());
        }
        classDAO = new CodecoolerClassJDBCDAO(ds);
        codecoolerDAO = new CodecoolerJDBCDAO(ds);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeOfAction = req.getParameter("action");

        if(typeOfAction.equals("add-new-codecooler")){
            String nameOfCodecooler = req.getParameter("select-new-student");
            try {
                List<Codecooler> codecoolerList = codecoolerDAO.getAllCodecoolers();
                Codecooler newCodecooler = null;
                try{
                    newCodecooler = codecoolerList.stream().filter(x -> x.getName().equals(nameOfCodecooler)).findFirst().get();
                } catch(NoSuchElementException ex){
                    resp.sendRedirect("/classes/edit?id=" + this.id);
                }
                newCodecooler.setClassId(this.id);
                codecoolerDAO.editCodecooler(newCodecooler.getId(), newCodecooler);
            } catch (ReadException e) {
                req.setAttribute("error-message", "You cannot add new codecooler. " + e.getMessage());
                RequestDispatcher dispatcher = req.getRequestDispatcher("/html-cms/error_page.jsp");
                dispatcher.forward(req, resp);
            }
        }else if(typeOfAction.equals("update-details")){

        }
        resp.sendRedirect("/classes");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPut(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fillDetailsAboutClass(request, response);
        fillDetailsAboutAvailableCodecoolers(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/html-cms/classes_update.jsp");
        dispatcher.forward(request, response);
    }

    private void fillDetailsAboutAvailableCodecoolers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Codecooler> codecoolerList = null;
        try{
            codecoolerList = codecoolerDAO.getAllCodecoolers();
        } catch(ReadException ex){
            response.sendRedirect("/classes");
        }
        codecoolerList = codecoolerList.stream()
                .filter(x -> x.getClassId() != id)
                .collect(Collectors.toList());

        request.setAttribute("codecoolerList", codecoolerList);
    }

    private void fillDetailsAboutClass(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Map<String, String[]> parameters = request.getParameterMap();
        CodecoolerClass codecoolerClass = null;
        try{
           id = Integer.parseInt(parameters.get("id")[0]);
        } catch(NumberFormatException ex){
            response.sendRedirect("/classes");
        }  catch (NullPointerException ex) {
            response.sendRedirect("/classes");
        }

        try {
            codecoolerClass = classDAO.getCodecoolerClassById(id);
        } catch (ReadException e) {
            response.sendRedirect("/classes");
        }

        request.setAttribute("classToEdit", codecoolerClass);
    }
}
