package Controller;

import DAO.PropertiesReader;
import Model.SummaryAdmin;
import Model.SummaryMentor;
import Service.SummaryService;
import Session.SessionManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

@WebServlet(name = "Summary", urlPatterns = "/dashboard")

public class SummaryController extends HttpServlet {

    private SummaryService summaryService;

    @Override
    public void init() throws ServletException {
        super.init();
        summaryService = new SummaryService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isAdmin = SessionManager.getActualUser().isAdmin();
        try {
            if (isAdmin) {
                forwardToDashboardAdmin(req, resp);
            } else {
                forwardToDashboardMentor(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void forwardToDashboardMentor(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        SummaryMentor summaryMentor = summaryService.getSummaryMentor();
        req.setAttribute("summaryMentor", summaryMentor);
        RequestDispatcher dispatcher
                = req.getRequestDispatcher("/html-cms/dashboard_mentor.jsp");
        dispatcher.forward(req, resp);
    }

    private void forwardToDashboardAdmin(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        SummaryAdmin summaryAdmin = summaryService.getSummaryAdmin();
        req.setAttribute("summaryAdmin", summaryAdmin);
        RequestDispatcher dispatcher
                = req.getRequestDispatcher("/html-cms/dashboard_admin.jsp");
        dispatcher.forward(req, resp);
    }


}
