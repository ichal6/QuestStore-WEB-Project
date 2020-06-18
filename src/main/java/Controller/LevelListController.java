package Controller;

import DAO.LevelDAO;
import DAO.LevelJDBCDAO;
import Model.Level;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Levels", urlPatterns = "/levels")
public class LevelListController extends HttpServlet {
    private LevelDAO levelDAO;

    @Override
    public void init() throws ServletException {
        super.init();

        try{
            levelDAO = new LevelJDBCDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            List<Level> levelsList = levelDAO.getLevelsList();
            req.setAttribute("levelsList", levelsList);
            RequestDispatcher dispatcher
                    = req.getRequestDispatcher("/html-cms/levels_list.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
