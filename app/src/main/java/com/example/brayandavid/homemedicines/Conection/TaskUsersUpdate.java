package com.example.brayandavid.homemedicines.Conection;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.brayandavid.homemedicines.Objects.User;
import com.example.brayandavid.homemedicines.Security;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.util.EntityUtils;

/**
 * Created by Kevin Ortiz on 14/03/2018.
 */
public class TaskUsersUpdate extends AsyncTask<String, Integer, List<User>> {


    private Context usersContext;

    public TaskUsersUpdate(Context context) {
        usersContext = context;
    }

    @Override
    protected List<User> doInBackground(String... strings) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet del = new HttpGet("http://13.90.130.197/user");
        del.setHeader("content-type", "application/json");
        del.setHeader("Authorization", Security.getToken());
        try {
            HttpResponse resp = httpClient.execute(del);
            String respStr = EntityUtils.toString(resp.getEntity());

            JSONArray respJSON = new JSONArray(respStr);

            List<User> userList = new ArrayList<>();

            for (int i = 0; i < respJSON.length(); i++) {
                JSONObject obj = respJSON.getJSONObject(i);

                User user = new User();
                user.setAge(obj.getInt("age"));
                user.setName(obj.getString("name"));
                user.setGender(obj.getString("gender"));
                user.setLasName(obj.getString("lastName"));
                user.setType(obj.getString("type"));
                user.setUser(obj.getString("user"));
                user.setPassword(obj.getString("password"));
                user.setWorkingHours(obj.getString("workingHours"));


                userList.add(user);
            }

            return userList;
        } catch (Exception ex) {
            Log.e("ServicioRest", "Error!", ex);
        }
        return new ArrayList<>();
    }


    @Override
    protected void onPostExecute(List<User> users) {
        try {
            super.onPostExecute(users);
        }catch (Exception e) {
            System.out.print(e.toString());
        }
    }
}
