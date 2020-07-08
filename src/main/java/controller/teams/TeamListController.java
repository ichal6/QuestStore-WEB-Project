package controller.teams;

import DAO.TeamDAO;
import DAO.TeamJDBCDAO;
import exception.ReadException;
import model.Team;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TeamListController", urlPatterns = "/teams")
public class TeamListController extends HttpServlet {
    private TeamDAO teamDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        teamDAO = new TeamJDBCDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Team> teamsList = teamDAO.getAllTeams();
            request.setAttribute("teamsList", teamsList);
            if (teamsList.size() == 0) {
                request.setAttribute("message", "There are no teams available");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/html-cms/teams_list.jsp");
            dispatcher.forward(request, response);
        } catch (ReadException e) {
            request.setAttribute("error_message", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/errorPage");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
