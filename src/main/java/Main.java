import DAO.UserDAO;
import Exception.ReadException;
import DAO.UserJDBCDAO;
import Model.CMSUser;

import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, ReadException {
        //Code only for testing
        UserDAO dao = new UserJDBCDAO("src/main/resources/database.properties");
        CMSUser userAdmin = new CMSUser(1,"NowyUser", "relaks@wp.pl", "1234",
                "Kraków", new java.sql.Date(Calendar.getInstance().getTime().getTime()),
                "simpleURL", false);
        dao.addUser(userAdmin);
        dao.editUser(2, userAdmin);
        dao.deleteUser(3);
        CMSUser user = dao.getCMSUser(4);

        System.out.println(user);
        System.out.println("List of Admins:");
//        for (Map.Entry<Integer,CMSUser> entry : dao.getAllAdmins().entrySet())
//            System.out.println("Key = " + entry.getKey() +
//                    ", Value = " + entry.getValue());
//        System.out.println("Lista mentorów:");
//        for (Map.Entry<Integer,CMSUser> entry : dao.getAllMentors().entrySet())
//            System.out.println("Key = " + entry.getKey() +
//                    ", Value = " + entry.getValue());
    }
}
