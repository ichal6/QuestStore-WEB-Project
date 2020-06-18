package Controller.admins;

import DAO.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import DAO.UserJDBCDAO;
import Exception.ReadException;
import Model.CMSUser;


@WebServlet(name = "AdminList", urlPatterns = "/admins")
public class AdminListController extends HttpServlet {
    private UserDAO dao;
    private List<CMSUser> allAdmins;

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
        try {
            allAdmins = dao.getAllAdmins();
        } catch (ReadException ex) {
            throw new ServletException(ex);
        }

        req.setAttribute("allAdmins", allAdmins);

        RequestDispatcher dispatcher
                = req.getRequestDispatcher("/html-cms/admins_list.jsp");
        dispatcher.forward(req, resp);

        //resp.sendRedirect("/html-cms/admins_list.jsp");
    }
}
