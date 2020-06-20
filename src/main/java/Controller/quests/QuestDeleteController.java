package Controller.quests;

import DAO.QuestDAO;
import DAO.QuestJDBCDAO;
import Exception.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "QuestDeleteController",  urlPatterns = "/quests/delete")
public class QuestDeleteController extends HttpServlet {
    private QuestDAO questDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        questDAO = new QuestJDBCDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doDelete(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            questDAO.deleteQuest(id);
        } catch (ConnectionException | ReadException e) {
            throw new ServletException(e);
        }
        response.sendRedirect("/quests");
    }
}
