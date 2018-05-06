package com.example.brayandavid.homemedicines.Objects;

/**
 * Created by Kevin Ortiz on 15/03/2018.
 */

public class LoginChangePassword {
   String newPassword;
   String oldPassword;
    String user;

    public LoginChangePassword(String newPassword, String oldPassword, String user) {
        this.newPassword = newPassword;
        this.oldPassword = oldPassword;
        this.user = user;
    }

    public LoginChangePassword() {

    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
