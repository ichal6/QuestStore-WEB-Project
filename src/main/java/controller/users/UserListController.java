package controller.users;

import DAO.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import DAO.UserJDBCDAO;
import exception.ReadException;
import model.CMSUser;
import service.SortService;


@WebServlet(name = "UsersList", urlPatterns = "/user-list")
public class UserListController extends HttpServlet {
    private UserDAO dao;
    private List<CMSUser> allUsers;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            dao = new UserJDBCDAO("src/main/resources/database.properties");
        } catch (IOException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameters = req.getParameterMap();
        SortService<CMSUser> sortService;
        String type = parameters.get("type")[0];


        String sortBy = null;
        if (parameters.containsKey("sortBy")) {
            sortBy = parameters.get("sortBy")[0];
        }

        boolean order = false;
        if (parameters.containsKey("order")) {
            if (parameters.get("order")[0].equals("ASC")) {
                order = true;
            } else {
                order = false;
            }
        }
//     ***Print parameters***
//        System.out.println("\n\n");
//        for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
//            System.out.print(entry.getKey() + " : ");
//            for(String value: entry.getValue()){
//                System.out.print(value + " ");
//            }
//        }

        try {
            if (type.equals("admin")) {
                allUsers = dao.getAllAdmins();
            } else {
                allUsers = dao.getAllMentors();
            }
        } catch (ReadException ex) {
            throw new ServletException(ex);
        }

        sortService = new SortService<>(allUsers);

        if (sortBy != null) {
            TypeColumn typeColumn = TypeColumn.returnType(sortBy);
            allUsers = sortService.sort(typeColumn, order);
        }


        req.setAttribute("allUsers", allUsers);
        req.setAttribute("type", type);

        RequestDispatcher dispatcher
                = req.getRequestDispatcher("/html-cms/users_list.jsp");
        dispatcher.forward(req, resp);

        //resp.sendRedirect("/html-cms/users_list.jsp");
    }
}
