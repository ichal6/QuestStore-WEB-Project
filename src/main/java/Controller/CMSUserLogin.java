package Controller;

import DAO.UserDAO;
import Exception.ReadException;
import DAO.UserJDBCDAO;
import Model.CMSUser;
import Session.SessionManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CMSUserLogin", urlPatterns = "/CMSUserLogin")
public class CMSUserLogin extends HttpServlet {
    private UserDAO dao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/html-login-and-account/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dao = new UserJDBCDAO("src/main/resources/database.properties");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean isCorrectLogIn = false;
        try {
            isCorrectLogIn = dao.checkUser(email, password);
        } catch (ReadException e) {
            throw new ServletException(e);
        }
        if(isCorrectLogIn){
            CMSUser user = null;
            try {
                user = dao.getCMSUser(email, password);
            } catch (ReadException e) {
                throw new ServletException(e);
            }
            SessionManager.setActualUser(user);
            response.sendRedirect("/dashboard");
        }
        else{
            String message = "<p class=\"warning-incorrect-login\">You put incorrect data!<p>";
            request.setAttribute("wrongLogIn", message);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/html-login-and-account/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
