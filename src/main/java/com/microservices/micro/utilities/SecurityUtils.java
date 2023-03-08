package com.microservices.micro.utilities;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

public class SecurityUtils {

    private SecurityUtils() {
    }

    /** Get the login of the current user. */
    public static String getCurrentUserLogin() {
        return "";
    }

    public static boolean isAuthenticated() {
        return false;
    }

    public static User getCurrentUser() {
        return null;
    }

    public static boolean isCurrentUserInRole(String authority) {
        return true;
    }

}

