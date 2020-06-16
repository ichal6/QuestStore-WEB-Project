import DAO.IUserDAO;
import DAO.ReadException;
import DAO.UserDBDAO;
import Model.CMSUser;

import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, ReadException {
        //Code only for testing
        IUserDAO dao = new UserDBDAO("src/main/resources/database.properties");
        CMSUser userAdmin = new CMSUser(1,"NowyUser", "relaks@wp.pl", "1234",
                "Kraków", new java.sql.Date(Calendar.getInstance().getTime().getTime()),
                "simpleURL", true);
        dao.addUser(userAdmin);
        dao.editUser(2, userAdmin);
        dao.deleteUser(3);
        CMSUser user = dao.getCMSUser(4);

        System.out.println(user);
        for (Map.Entry<Integer,CMSUser> entry : dao.getAllUsers().entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
    }
}
