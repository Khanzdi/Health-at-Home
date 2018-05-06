package com.example.brayandavid.homemedicines.Conection;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.brayandavid.homemedicines.Objects.User;

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

public class TaskUserRegistry extends AsyncTask<User, Void, String>{
    static int code;
    private Context loginContext;

    public Context getLoginContext() {
        return loginContext;
    }

    public void setLoginContext(Context loginContext) {
        this.loginContext = loginContext;
    }

    public static int getCode() {
        return code;
    }

    public static void setCode(int code) {
        TaskUserRegistry.code = code;
    }

    public TaskUserRegistry() {
    }

    @Override
    protected String doInBackground(User... users) {

        HttpClient httpClient = new DefaultHttpClient();
        HttpPost del = new HttpPost("http://13.90.130.197/user");
        del.setHeader("content-type", "application/json");

                try {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("age", users[0].getAge());
                    jsonObject.put("gender", users[0].getGender());
                    jsonObject.put("name", users[0].getName());
                    jsonObject.put("lasName", users[0].getLasName());
                    jsonObject.put("password", users[0].getPassword());
                    jsonObject.put("type", users[0].getType());
                    jsonObject.put("user", users[0].getUser());
                    jsonObject.put("workingHours", users[0].getWorkingHours());
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
