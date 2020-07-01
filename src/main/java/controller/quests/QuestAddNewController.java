package controller.quests;

import DAO.QuestDAO;
import DAO.QuestJDBCDAO;
import model.Quest;
import exception.*;
import validation.Validator;

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

// czy nie wydzielić servisu???
// oddzielna metoda do validowania i setowania atrybutów?

@WebServlet(name = "QuestAddNewController", urlPatterns = "quests/add")
public class QuestAddNewController extends HttpServlet {
    private QuestDAO questDAO;
    private Validator validator;

    @Override
    public void init() throws ServletException {
        super.init();
        this.questDAO = new QuestJDBCDAO();
        this.validator = new Validator();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/html-cms/quests_add_new.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Quest quest = extractQuestFromHTTPRequest(request);
            questDAO.insertQuest(quest);
            response.sendRedirect("/quests");
        } catch (NameFormatException e) {
            request.setAttribute("name_validation_message", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/html-cms/quests_add_new.jsp");
            dispatcher.forward(request, response);
        } catch (ReadException e) {
            request.setAttribute("error_message", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/errorPage");
            dispatcher.forward(request, response);
        }
    }

    private Quest extractQuestFromHTTPRequest(HttpServletRequest request) throws NameFormatException {
        String name = request.getParameter("quest-name");
        validator.validateName(name, 3, 50);
        String description = request.getParameter("quest-description");
        int value = Integer.parseInt(request.getParameter("quest-value"));
        String type = request.getParameter("quest-type");
        String url = getRandomUrlPath();

        return new Quest(name, description, value, type, url);
    }

    private String getRandomUrlPath() {
        List<String> urlPaths = Arrays.asList("quest_logo_01.svg", "quest_logo_02.svg", "quest_logo_03.svg",
                "quest_logo_04.svg", "quest_logo_05.svg", "quest_logo_06.svg");
        Random rand = new Random();

        return urlPaths.get(rand.nextInt(urlPaths.size()));
    }
}
