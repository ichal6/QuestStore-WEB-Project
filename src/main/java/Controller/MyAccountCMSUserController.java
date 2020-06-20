package Controller;

import DAO.UserDAO;
import DAO.UserJDBCDAO;
import Model.CMSUser;
import Exception.ReadException;
import Session.SessionManager;
import Exception.SessionException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MyAccountCMSUSer", urlPatterns = "/cms-user/my-account")
public class MyAccountCMSUserController extends HttpServlet {
    private UserDAO dao;
    private CMSUser userToEdit;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            dao = new UserJDBCDAO("src/main/resources/database.properties");
            userToEdit = SessionManager.getActualUser();
        }
        catch(IOException | SessionException ex){
            throw new ServletException(ex);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("person-name");
        String email = request.getParameter("person-mail");

        if(name == null || email == null){
            response.sendRedirect("/dashboard");
        }

        userToEdit.setName(name);
        userToEdit.setEmail(email);

        try {
            dao.editUser(userToEdit.getID(), userToEdit);
        } catch (ReadException ex) {
            throw new ServletException(ex);
        }
        response.sendRedirect("/dashboard");

        //        response.sendRedirect("/dashboard");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.sendRedirect("/html-login-and-account/my-account.jsp");
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/html-login-and-account/my-account.jsp");
        dispatcher.forward(request, response);
    }
}
