package controller.levels;

import DAO.LevelDAO;
import DAO.LevelJDBCDAO;
import model.Level;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name ="Level-Edit", urlPatterns = "/levels/edit")
public class LevelUpdateController  extends HttpServlet {
    private LevelDAO levelDAO;
    public int levelId;
    public Level levelToEdit;

    @Override
    public void init() throws ServletException {
        super.init();
        try{
            levelDAO = new LevelJDBCDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("level-name");
        String description = request.getParameter("level-description");
        int price = Integer.parseInt(request.getParameter("level-coins"));

        try {
            levelDAO.updateLevel(new Level(name, description, price, "level6.svg"), levelId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        response.sendRedirect("/levels");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPut(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, String[]> parameters = request.getParameterMap();
        String id = parameters.get("id")[0];
        levelId = Integer.parseInt(id);

        try {
            levelToEdit = levelDAO.getLevelToUpdate(levelId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.setAttribute("level", levelToEdit);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/html-cms/levels_update.jsp");
            dispatcher.forward(request, response);
}
}
