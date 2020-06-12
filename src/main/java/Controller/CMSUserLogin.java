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
    private CMSUser user = new CMSUser(1,"NowyUser", "relaks@wp.pl", "1234",
            "Kraków", new java.sql.Date(Calendar.getInstance().getTime().getTime()),
            "simpleURL", true);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean isCorrectLogIn = tryLogIn(email, password);
        isCorrectLogIn = email.equals(user.getEmail()) && password.equals(user.getPassword());
        if(isCorrectLogIn){

            SessionUser.actualUser = getUserFromDatabase(email, password);
            if(user.isAdmin()){
                response.sendRedirect("/html-cms/dashboard_admin.jsp");
            }
            else{
                response.sendRedirect("/html-cms/dashboard_mentor.jsp");
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
        return true;
    }

    private CMSUser getUserFromDatabase(String email, String password){
        //here should be run DAO and read current user after positive result of tryLogIn method
        return new CMSUser(1,"NowyUser", "relaks@wp.pl", "1234",
                "Kraków", new java.sql.Date(Calendar.getInstance().getTime().getTime()),
                "simpleURL", true);
    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher dispatcher
//                = request.getRequestDispatcher("/html-login-and-account/login.jsp");
//        dispatcher.forward(request, response);
//    }
}
