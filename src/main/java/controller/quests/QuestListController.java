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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QuestListController", urlPatterns = "/quests")
public class QuestListController extends HttpServlet {
    private QuestDAO questDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        questDAO = new QuestJDBCDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Quest> questsList = questDAO.getAllQuests();
            request.setAttribute("questsList", questsList);
            if (questsList.size() == 0) {
                request.setAttribute("message", "There are no quests available");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/html-cms/quests_list.jsp");
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
