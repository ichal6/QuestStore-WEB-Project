package Controller;

import DAO.UserJDBCDAO;
import Model.SummaryAdmin;
import Model.SummaryMentor;
import Service.SummaryService;
import Session.SessionManager;
import Exception.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "Summary", urlPatterns = "/dashboard")

public class SummaryController extends HttpServlet {

    private SummaryService summaryService;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            summaryService = new SummaryService(new UserJDBCDAO("src/main/resources/database.properties"));
        } catch (IOException e) {
            throw new ServletException("Problem with connect to database");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            boolean isAdmin = SessionManager.getActualUser().isAdmin();
            if (isAdmin) {
                forwardToDashboardAdmin(req, resp);
            } else {
                forwardToDashboardMentor(req, resp);
            }

        } catch (SQLException | ReadException | ConnectionException | SessionException e ) {

            throw new ServletException(e);
        }
    }

    private void forwardToDashboardMentor(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException, ConnectionException, ReadException {
        SummaryMentor summaryMentor = summaryService.getSummaryMentor();
        req.setAttribute("summaryMentor", summaryMentor);
        RequestDispatcher dispatcher
                = req.getRequestDispatcher("/html-cms/dashboard_mentor.jsp");
        dispatcher.forward(req, resp);
    }

    private void forwardToDashboardAdmin(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException, ReadException, ConnectionException {
        SummaryAdmin summaryAdmin = summaryService.getSummaryAdmin();
        req.setAttribute("summaryAdmin", summaryAdmin);
        RequestDispatcher dispatcher
                = req.getRequestDispatcher("/html-cms/dashboard_admin.jsp");
        dispatcher.forward(req, resp);
    }


}
