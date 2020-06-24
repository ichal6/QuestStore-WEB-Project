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

        String sortBy = null;
        if(parameters.containsKey("sortBy")){
            sortBy = parameters.get("sortBy")[0];
        }
        
        boolean order = false;
        if(parameters.containsKey("order")){
            if(parameters.get("order")[0].equals("ASC")){
                order = true;
            }else{
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
            if(type.equals("admin")){
                allUsers = dao.getAllAdmins();
            }else{
                allUsers = dao.getAllMentors();
            }
        } catch (ReadException ex) {
            throw new ServletException(ex);
        }

        if(sortBy != null){
            TypeColumn typeColumn = TypeColumn.returnType(sortBy);
            allUsers = sort(typeColumn, order);
        }


        req.setAttribute("allUsers", allUsers);
        req.setAttribute("type", type);

        RequestDispatcher dispatcher
                = req.getRequestDispatcher("/html-cms/users_list.jsp");
        dispatcher.forward(req, resp);

        //resp.sendRedirect("/html-cms/users_list.jsp");
    }


    private List<CMSUser> sort(TypeColumn typeOfColumn, boolean isAscending) throws ServletException{
        if(allUsers == null){
            throw new ServletException("The list is empty!");
        }
        Comparator<CMSUser> comparator = null;
        switch(typeOfColumn){
            case NAME:
                comparator = Comparator.comparing(CMSUser::getName);
                break;
            case EMAIL:
                comparator = Comparator.comparing(CMSUser::getEmail);
                break;
            case CITY:
                comparator = Comparator.comparing(CMSUser::getCity);
                break;
            case DATE:
                comparator = Comparator.comparing(CMSUser::getDateOfAdding);
                break;
            default:
                return allUsers;
        }
        if(!isAscending){
            comparator = comparator.reversed();
        }
        return allUsers.stream().sorted(comparator).collect(Collectors.toList());
    }
}
