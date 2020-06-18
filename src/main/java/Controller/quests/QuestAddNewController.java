package Controller.quests;

import DAO.QuestDAO;
import DAO.QuestJDBCDAO;
import Model.Quest;
import Exception.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.Integer.parseInt;

@WebServlet(name = "QuestAddNewController", urlPatterns = "quests/add")
public class QuestAddNewController extends HttpServlet {
    private QuestDAO questDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        questDAO = new QuestJDBCDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/html-cms/quests_add_new.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("quest-name");
            String description = request.getParameter("quest-description");
            int value = Integer.parseInt(request.getParameter("quest-value"));
            String type = request.getParameter("quest-type");
            List<String> urlPaths = Arrays.asList("quest_logo_01.svg", "quest_logo_02.svg", "quest_logo_03.svg", "quest_logo_04.svg", "quest_logo_05.svg", "quest_logo_06.svg");
            Random rand = new Random();
            String url = urlPaths.get(rand.nextInt(urlPaths.size()));

            Quest quest = new Quest(name, description, value, type, url);
            questDAO.insertQuest(quest);
            response.setHeader("Send", "Success");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/html-cms/quests_list.jsp");
            dispatcher.forward(request, response);
        } catch (ConnectionException | ReadException e) {
            throw new ServletException(e);
        }
    }
}
