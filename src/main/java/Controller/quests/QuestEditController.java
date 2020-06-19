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

@WebServlet(name = "QuestEditController", urlPatterns = "/quests/edit")
public class QuestEditController extends HttpServlet {
    private QuestDAO questDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        questDAO = new QuestJDBCDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Quest quest = questDAO.getQuestById(id);
            request.setAttribute("quest", quest);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/html-cms/quests_update.jsp");
            dispatcher.forward(request, response);
        } catch (ConnectionException | ReadException e) {
            throw new ServletException(e);
        }
    }


    // quest-name
    // quest-description
    // quest-value
    // quest-type
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
