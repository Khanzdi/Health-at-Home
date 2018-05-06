package com.example.brayandavid.homemedicines.Conection;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.brayandavid.homemedicines.Objects.LoginChangePassword;
import com.example.brayandavid.homemedicines.Security;

import org.json.JSONObject;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.util.EntityUtils;

/**
 * Created by Kevin Ortiz on 15/03/2018.
 */

public class TaskChangePassword extends AsyncTask<LoginChangePassword, Void, String> {
    static int code;
    public TaskChangePassword(Context loginCPContext) {this.loginCPContext = loginCPContext;}

    private Context loginCPContext;

    public TaskChangePassword() {

    }

    public static void setCode(int code) {
        TaskChangePassword.code = code;
    }

    public static int getCode() {
        return code;
    }

    @Override
    protected String doInBackground(LoginChangePassword... loginChangePasswords) {
        {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost del = new HttpPost("http://13.90.130.197/login/change-password");
            del.setHeader("content-type", "application/json");
            del.setHeader("Authorization", Security.getToken());
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("user", loginChangePasswords[0].getUser());
                jsonObject.put("oldPassword", loginChangePasswords[0].getOldPassword());
                jsonObject.put("newPassword", loginChangePasswords[0].getNewPassword());
                del.setEntity(new StringEntity(jsonObject.toString()));
                HttpResponse resp = httpClient.execute(del);
                String respStr = EntityUtils.toString(resp.getEntity());
                code = resp.getStatusLine().getStatusCode();
                return respStr;

            } catch (Exception ex) {
                Log.e("ServicioRest", "Error!", ex);
            }
            return "";
        }

    }
}
