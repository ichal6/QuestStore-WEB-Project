package session;

import model.CMSUser;
import exception.SessionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionManager {
    private static HttpSession session;

    public static void setSession(HttpSession session, CMSUser user){
        SessionManager.session = session;
        session.setAttribute("actualUser", user);
        //Set session timeout in seconds:
        //session.setMaxInactiveInterval(10);
    }

    public static CMSUser getActualUser(HttpServletRequest request) throws SessionException {
        //Here we should throw our exception (for example NoSessionException) when actualUser equals null.
        // If user try bypass login page , when we should display error page ex. HTTP 403 forbidden.
        session = request.getSession(false);

        if(session != null || session.getAttribute("actualUser") != null){
            return (CMSUser) session.getAttribute("actualUser");
        }else{
            throw new SessionException("Access denied. You are not log in.");
        }
    }

    public static void logout(){
        if (session != null) {
            session.invalidate();
        }
    }
}
