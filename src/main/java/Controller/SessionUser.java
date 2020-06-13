package Controller;

import Model.CMSUser;

public class SessionUser {
    private static CMSUser actualUser;

    public static void setActualUser(CMSUser actualUser) {
        SessionUser.actualUser = actualUser;
    }

    public static CMSUser getActualUser() {
        return actualUser;
    }
}
