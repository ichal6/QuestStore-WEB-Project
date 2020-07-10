package controller.teams;

import DAO.CodecoolerDAO;
import DAO.CodecoolerJDBCDAO;
import DAO.TeamDAO;
import DAO.TeamJDBCDAO;
import exception.ReadException;
import model.Codecooler;
import model.Team;
import service.TeamService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TeamEditController", urlPatterns = "/teams/edit")
public class TeamEditController extends HttpServlet {
    private TeamDAO teamDAO;
    private TeamService teamService;
    private CodecoolerDAO codecoolerDAO;
    private Team team;
    private List<Codecooler> teamCodecoolersList;
    private Integer id;

    @Override
    public void init() throws ServletException {
        super.init();
        this.teamDAO = new TeamJDBCDAO();
        this.teamService = new TeamService();
        this.codecoolerDAO = new CodecoolerJDBCDAO();
        this.teamCodecoolersList = new ArrayList<>();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            updateTeamIdFromRequestIfExists(request);
            team = teamDAO.getTeamById(id);
            teamCodecoolersList = codecoolerDAO.getCodecoolersByTeamId(id);
            request.setAttribute("team", team);
            request.setAttribute("teamCodecoolersList", teamCodecoolersList);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/html-cms/teams_update.jsp");
            dispatcher.forward(request, response);
        } catch (ReadException e) {
            request.setAttribute("error_message", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/errorPage");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPut(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("basic-information")) {
            boolean isInputValid = teamService.callInputsValidation(request);
            if (isInputValid) {
                try {
                    team = teamService.changeTeamDetails(request, team);
                    teamDAO.editTeam(id, team);
                    request.setAttribute("message", "Team successfully modified!");
                } catch (ReadException e) {
                    request.setAttribute("error_message", e.getMessage());
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/errorPage");
                    dispatcher.forward(request, response);
                }
            }
            doGet(request, response);
        }
    }

    private void updateTeamIdFromRequestIfExists(HttpServletRequest request) {
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            // clause left empty on purpose - if we don't jave "id" parameter, the id field already has a value
        }
    }

//    @Override
//    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        boolean isInputValid = questService.callInputsValidation(request);
//        if (isInputValid) {
//            try {
//                quest = questService.changeQuestDetails(request, quest);
//                questDAO.updateQuest(quest.getID(), quest);
//                request.setAttribute("message", "Quest successfully modified!");
//            } catch (ReadException e) {
//                request.setAttribute("error_message", e.getMessage());
//                RequestDispatcher dispatcher = request.getRequestDispatcher("/errorPage");
//                dispatcher.forward(request, response);
//            }
//        }
//        doGet(request, response);
//    }
}
