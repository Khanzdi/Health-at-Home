package com.example.brayandavid.homemedicines.Conection;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.brayandavid.homemedicines.Objects.Login;

import org.json.JSONObject;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.util.EntityUtils;

/**
 * Created by Kevin Ortiz on 14/03/2018.
 */
public class TaskLogin extends AsyncTask<Login, Void, String> {

    static int code;

    public static int getCode() {
        return code;
    }

    public static void setCode(int code) {
        TaskLogin.code = code;
    }

    private Context loginContext;

    public TaskLogin(Context context) {
        loginContext = context;
    }

    public TaskLogin() {

    }

    @Override
    protected String doInBackground(Login... logins) {
        {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost del = new HttpPost("http://13.90.130.197/login");
            del.setHeader("content-type", "application/json");

            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("user", logins[0].getUser());
                jsonObject.put("password", logins[0].getPassword());
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
