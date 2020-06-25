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

import DAO.UserJDBCDAO;
import exception.NoComparatorException;
import exception.ReadException;
import model.CMSUser;
import sort.ComparatorUser;
import sort.Comparing;
import sort.SortService;


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
        String type = parameters.get("type")[0];

        allUsers = getListFromDatabase(type);

        Boolean order = getOrder(parameters);
        String sortBy = getSortBy(parameters);
        if(order != null && sortBy != null) {
            try {
                allUsers = sortList(allUsers, order, sortBy);
            } catch (NoComparatorException e) {
                //here should be the message for user, that the user cannot sorting the table
                e.printStackTrace();
            }
        }

        req.setAttribute("allUsers", allUsers);
        req.setAttribute("type", type);

        RequestDispatcher dispatcher
                = req.getRequestDispatcher("/html-cms/users_list.jsp");
        dispatcher.forward(req, resp);

    }

    private Boolean getOrder(Map<String, String[]> parameters){
        if (parameters.containsKey("order")) {
             return parameters.get("order")[0].equals("ASC");
        }
        return null;
    }

    private String getSortBy(Map<String, String[]> parameters){
        if (parameters.containsKey("sortBy")) {
            return parameters.get("sortBy")[0];
        }
        return null;
    }

    private List<CMSUser> sortList(List<CMSUser> allUsers, boolean order, String sortBy) throws NoComparatorException{
        Comparing<CMSUser> comparing = new ComparatorUser<>();
        TypeColumn typeColumn = TypeColumn.returnType(sortBy);
        Comparator<CMSUser> comparator = comparing.getComparator(typeColumn);
        SortService<CMSUser> sortService = new SortService<CMSUser>(allUsers, comparator);
        return sortService.sort(order);
    }

    private List<CMSUser> getListFromDatabase(String type) throws ServletException {
        try {
            if (type.equals("admin")) {
                allUsers = dao.getAllAdmins();
            } else {
                allUsers = dao.getAllMentors();
            }
        } catch (ReadException ex) {
            throw new ServletException(ex);
        }
        return allUsers;
    }
}
