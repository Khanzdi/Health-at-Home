package com.example.brayandavid.homemedicines;

/**
 * Created by Kevin Ortiz on 16/03/2018.
 */

public class Security {

    private static String token;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        Security.token = token;
    }

}
