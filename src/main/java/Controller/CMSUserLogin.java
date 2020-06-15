package Controller;

import Model.CMSUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

@WebServlet(name = "CMSUserLogin", urlPatterns = "/CMSUserLogin")
public class CMSUserLogin extends HttpServlet {
    private CMSUser userAdmin = new CMSUser(1,"NowyUser", "relaks@wp.pl", "1234",
            "Kraków", new java.sql.Date(Calendar.getInstance().getTime().getTime()),
            "simpleURL", true);
    private CMSUser userMentor = new CMSUser(1,"Nowy Mentor", "mentor@wp.pl", "1234",
            "Kraków", new java.sql.Date(Calendar.getInstance().getTime().getTime()),
            "simpleURL", false);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/html-login-and-account/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean isCorrectLogIn = tryLogIn(email, password);
        if(isCorrectLogIn){
            CMSUser user = getUserFromDatabase(email, password);
            SessionManager.setActualUser(user);
            if(SessionManager.getActualUser().isAdmin()){
                response.sendRedirect("/dashboard");
            }
            else{
                response.sendRedirect("/dashboard");
            }
        }
        else{
            String message = "<p class=\"warning-incorrect-login\">You put incorrect data!<p>";
            request.setAttribute("wrongLogIn", message);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/html-login-and-account/login.jsp");
            dispatcher.forward(request, response);
        }
    }

    private boolean tryLogIn(String email, String password){
        // It will be request to database
        if(email.equals(userAdmin.getEmail()) && password.equals(userAdmin.getPassword())){
            return true;
        }
        else return email.equals(userMentor.getEmail()) && password.equals(userMentor.getPassword());
    }

    private CMSUser getUserFromDatabase(String email, String password){
        //here should be run DAO and read current user after positive result of tryLogIn method
        if(email.equals("relaks@wp.pl")){
            return userAdmin;
        }
        else{
            return userMentor;
        }
    }
}
