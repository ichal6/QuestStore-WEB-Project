package Controller.levels;


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

import static java.lang.Integer.parseInt;

@WebServlet(name = "Levels-add", urlPatterns = "/levels/add")
public class LevelAddNewController extends HttpServlet {
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

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("level-name");
        String description = req.getParameter("level-description");
        String coins = req.getParameter("level-coins");
        int price = parseInt(coins);
        Level level = new Level(name, description, price, "level6.svg");

        try {
            levelDAO.insertNewLevel(level);
            resp.setHeader("Send", "Success");
            RequestDispatcher dispatcher
                    = req.getRequestDispatcher("/html-cms/levels_add_new.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        RequestDispatcher dispatcher
                = req.getRequestDispatcher("/html-cms/levels_add_new.jsp");
        dispatcher.forward(req, resp);
    }

    }

