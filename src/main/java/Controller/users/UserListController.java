package Controller.users;

import DAO.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import DAO.UserJDBCDAO;
import Exception.ReadException;
import Model.CMSUser;


@WebServlet(name = "UsersList", urlPatterns = "/user-list")
public class UserListController extends HttpServlet {
    private UserDAO dao;
    private List<CMSUser> allUsers;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameters = req.getParameterMap();
        String type = parameters.get("type")[0];

        try {
            if(type.equals("admin")){
                allUsers = dao.getAllAdmins();
            }else{
                allUsers = dao.getAllMentors();
            }
        } catch (ReadException ex) {
            throw new ServletException(ex);
        }

        req.setAttribute("allUsers", allUsers);
        req.setAttribute("type", type);

        RequestDispatcher dispatcher
                = req.getRequestDispatcher("/html-cms/users_list.jsp");
        dispatcher.forward(req, resp);

        //resp.sendRedirect("/html-cms/users_list.jsp");
    }
}
