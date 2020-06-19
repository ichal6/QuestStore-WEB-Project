package Session;

import Model.CMSUser;
import Exception.SessionException;

public class SessionManager {
    private static CMSUser actualUser;
    private static boolean isLogin;

    public static void setActualUser(CMSUser actualUser) {
        SessionManager.actualUser = actualUser;
        isLogin = true;
    }

    public static CMSUser getActualUser() throws SessionException {
        //Here we should throw our exception (for example NoSessionException) when actualUser equals null.
        // If user try bypass login page , when we should display error page ex. HTTP 403 forbidden.
        if(isLogin){
            return actualUser;
        }else{
            throw new SessionException("Access denied. You are not log in.");
        }
    }

    public static void logout(){
        isLogin = false;
        actualUser = null;
    }
}
