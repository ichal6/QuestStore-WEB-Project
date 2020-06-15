package Controller;

import Model.CMSUser;

public class SessionManager {
    private static CMSUser actualUser;

    public static void setActualUser(CMSUser actualUser) {
        SessionManager.actualUser = actualUser;
    }

    public static CMSUser getActualUser() {
        //Here we should throw our exception (for example NoSessionException) when actualUser equals null.
        // If user try bypass login page , when we should display error page ex. HTTP 403 forbidden.
        return actualUser;
    }
}
