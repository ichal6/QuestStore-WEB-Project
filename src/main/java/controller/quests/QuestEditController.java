package controller.quests;

import DAO.QuestDAO;
import DAO.QuestJDBCDAO;
import model.Quest;
import exception.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "QuestEditController", urlPatterns = "/quests/edit")
public class QuestEditController extends HttpServlet {
    private QuestDAO questDAO;
    private Quest quest;

    @Override
    public void init() throws ServletException {
        super.init();
        questDAO = new QuestJDBCDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            quest = questDAO.getQuestById(id);
            request.setAttribute("quest", quest);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/html-cms/quests_update.jsp");
            dispatcher.forward(request, response);
        } catch (ConnectionException | ReadException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPut(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            changeQuestDetails(request);
            questDAO.updateQuest(quest.getID(), quest);
        } catch (ConnectionException | ReadException e) {
            throw new ServletException(e);
        }
        response.sendRedirect("/quests");
    }

    private void changeQuestDetails(HttpServletRequest request) {
        String name = request.getParameter("quest-name");
        String description = request.getParameter("quest-description");
        int value = Integer.parseInt(request.getParameter("quest-value"));
        String type = (request.getParameter("quest-type") != null) ? request.getParameter("quest-type") : quest.getType().name();
        quest.setName(name);
        quest.setDescription(description);
        quest.setValue(value);
        quest.setType(type);
    }
}
