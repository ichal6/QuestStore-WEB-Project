package Controller.admins;

import DAO.UserDAO;
import DAO.UserJDBCDAO;
import Model.CMSUser;
import Exception.ReadException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@WebServlet(name = "AdminNewController", urlPatterns = "/admins/new")
public class AdminNewController extends HttpServlet {
    private UserDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            dao = new UserJDBCDAO("src/main/resources/database.properties");
        }
        catch(IOException ex){
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("person-name");
        String email = request.getParameter("person-mail");
        String city = request.getParameter("person-city");

        if(name == null || email == null || city == null){
            response.sendRedirect("/html-cms/admins_add_new.jsp");
        }

        String defaultPassword = "admin";
        String defaultPicture = "../assets/img/admins-images/penelope-cruz.svg";
        Date actualDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        CMSUser newAdmin = new CMSUser.
                Builder().
                userName(name).
                userEmail(email).
                userCity(city).
                userPassword(defaultPassword).
                userDate(actualDate).
                userPicture(defaultPicture).
                userRole(true).
                build();

        try {
            dao.addUser(newAdmin);
        } catch (ReadException ex) {
            throw new ServletException(ex);
        }
        response.sendRedirect("/admins");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/html-cms/admins_add_new.jsp");
    }
}
