import DAO.IUserDAO;
import DAO.ReadException;
import DAO.UserDBDAO;
import Model.CMSUser;

import java.io.IOException;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws IOException, ReadException {
        IUserDAO dao = new UserDBDAO("src/main/resources/database.properties");
        CMSUser userAdmin = new CMSUser(1,"NowyUser", "relaks@wp.pl", "1234",
                "Kraków", new java.sql.Date(Calendar.getInstance().getTime().getTime()),
                "simpleURL", true);
        dao.addUser(userAdmin);
    }
}
