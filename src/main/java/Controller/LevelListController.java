package Controller;

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


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LevelJDBCDAO levelJDBCDAO = new LevelJDBCDAO();
        try {
            List<Level> levelsList = levelJDBCDAO.getLevelsList();
            req.setAttribute("levelsList", levelsList);
            RequestDispatcher dispatcher
                    = req.getRequestDispatcher("/html-cms/levels_list.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
