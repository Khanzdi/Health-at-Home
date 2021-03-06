package com.example.brayandavid.homemedicines.Conection;

import android.os.AsyncTask;
import android.util.Log;

import com.example.brayandavid.homemedicines.Objects.Buyer;
import com.example.brayandavid.homemedicines.Objects.Category;
import com.example.brayandavid.homemedicines.Security;
import com.loopj.android.http.HttpGet;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.util.EntityUtils;

/**
 * Created by Kevin Ortiz on 15/03/2018.
 */

public class TaskBuy extends AsyncTask<String, Integer, List<Buyer>>{
static int code;

    public TaskBuy() {}

    @Override
    protected List<Buyer> doInBackground(String... strings) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet del = new HttpGet("http://13.90.130.197/product/category/");
        del.setHeader("content-type", "application/json");
        del.setHeader("Authorization", Security.getToken());
        try {
            HttpResponse resp = httpClient.execute(del);
            String respStr = EntityUtils.toString(resp.getEntity());

            JSONArray respJSON = new JSONArray(respStr);

            List<Buyer> productsList = new ArrayList<>();

            for (int i = 0; i < respJSON.length(); i++) {
                JSONObject obj = respJSON.getJSONObject(i);

                Buyer buyer = new Buyer();
                buyer.setFullName(obj.getString("fullName"));
                buyer.setContactPhone(obj.getString("contactPhone"));
                buyer.setDniNumber(obj.getInt("dniNumber"));
                buyer.setEmailAddress(obj.getString("emailAddress"));
                buyer.setMerchantBuyerId(obj.getString("merchantBuyerId"));



                JSONObject categoryJson = obj.getJSONObject("category");
                Category category = new Category();
                category.setId(categoryJson.getString("id"));
                category.setName(categoryJson.getString("name"));


                productsList.add(buyer);
            }

            return productsList;
        } catch (Exception ex) {
            Log.e("ServicioRest", "Error!", ex);
        }
        return new ArrayList<>();
    }

    public static int getCode() {return code;}

    public static void setCode(int code) {TaskBuy.code = code;}



}
