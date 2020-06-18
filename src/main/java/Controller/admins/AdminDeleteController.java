package Controller.admins;

import DAO.UserDAO;
import DAO.UserJDBCDAO;
import Model.CMSUser;
import Exception.ReadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "AdminDeleteController", urlPatterns = "/admins/delete")
public class AdminDeleteController extends HttpServlet {
    private UserDAO dao;
    private CMSUser userToDelete;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doDelete(request, response);
        response.sendRedirect("/admins");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameters = request.getParameterMap();
        String id = parameters.get("id")[0];
        int idUser = 0;
        try {
            idUser = Integer.parseInt(id);
        } catch(NumberFormatException ex){
            //throw new ServletException("You put incorrect path to page!");
            response.sendRedirect("/admins");
        }
        try {
            dao.deleteUser(idUser);
        } catch (ReadException ex) {
            throw new ServletException("You cannot delete this user");
        }
    }
}
