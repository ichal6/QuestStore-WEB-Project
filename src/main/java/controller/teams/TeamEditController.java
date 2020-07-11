package controller.teams;

import DAO.*;
import exception.ReadException;
import model.Artifact;
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
import java.util.Map;

@WebServlet(name = "TeamEditController", urlPatterns = "/teams/edit")
public class TeamEditController extends HttpServlet {
    private TeamDAO teamDAO;
    private TeamService teamService;
    private CodecoolerDAO codecoolerDAO;
    private ArtifactDAO artifactDAO;
    private Team team;
    private Integer id;
    private List<Artifact> artifactsList;

    @Override
    public void init() throws ServletException {
        super.init();
        this.teamDAO = new TeamJDBCDAO();
        this.teamService = new TeamService();
        this.codecoolerDAO = new CodecoolerJDBCDAO();
        this.artifactDAO = new ArtifactJDBCDAO();
        this.artifactsList = new ArrayList<>();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            updateTeamIdFromRequestIfExists(request);

            team = teamDAO.getTeamById(id);
            List<Codecooler> teamCodecoolersList = codecoolerDAO.getCodecoolersByTeamId(id);
            List<Codecooler> allRemainingCodecoolersList = codecoolerDAO.getAllCodecoolers();
            allRemainingCodecoolersList.removeAll(teamCodecoolersList);
            artifactsList = artifactDAO.getArtifactsByTeamId(id);

            request.setAttribute("team", team);
            request.setAttribute("teamCodecoolersList", teamCodecoolersList);
            request.setAttribute("allRemainingCodecoolersList", allRemainingCodecoolersList);
            request.setAttribute("teamArtifactsList", artifactsList);

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

        } else if (action.equals("team-members")) {
            try {
                int studentId = Integer.parseInt(request.getParameter("student"));
                Codecooler codecooler = codecoolerDAO.getCodecoolerById(studentId);
                codecooler.setTeamId(id);
                codecoolerDAO.editCodecooler(studentId, codecooler);
                request.setAttribute("message", "Codecooler succesfully added to this team!");
            } catch (NumberFormatException e) {
                request.setAttribute("message", "You have to choose a codecooler to add!");
            } catch (ReadException e) {
                request.setAttribute("message", e.getMessage());
            }

        } else if (action.equals("team-artifacts")) {
            try {
                String[] strings = request.getParameterMap().get("is-used");
                callArtifactUsageChange(strings);
                request.setAttribute("message", "You've successfully changed this team's quest!");
            } catch (NullPointerException e) {
                request.setAttribute("message", "You can't edit quests if the team doesn't have any!");
            } catch (ReadException e) {
                request.setAttribute("message", e.getMessage());
            }
        }
        doGet(request, response);
    }

    private void updateTeamIdFromRequestIfExists(HttpServletRequest request) {
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            // clause left empty on purpose - if we don't jave "id" parameter, the id field already has a value
        }
    }

    private boolean changeIsUsedTextIntoBoolean(String text) {
        return text.toUpperCase().trim().equals("USED");
    }

    private void callArtifactUsageChange(String[] booleansArray) throws ReadException {
        int count = 0;
        if (booleansArray.length == 0) {
            throw new NullPointerException();
        }
        while (count < artifactsList.size()) {
            boolean isUsed = changeIsUsedTextIntoBoolean(booleansArray[count]);
            Artifact artifact = artifactsList.get(count);
            if (isUsed != artifact.isUsed()) {
                artifactDAO.markIfArtifactUsed(artifact.getId(), isUsed);
                artifact.setUsed(isUsed);
            }
            count++;
        }
    }
}
