package Controller;

import Model.CMSUser;

public class SessionManager {
    private static CMSUser actualUser;

    public static void setActualUser(CMSUser actualUser) {
        SessionManager.actualUser = actualUser;
    }

    public static CMSUser getActualUser() {
        return actualUser;
    }
}
