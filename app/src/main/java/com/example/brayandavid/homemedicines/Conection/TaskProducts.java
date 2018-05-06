package com.example.brayandavid.homemedicines.Conection;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.brayandavid.homemedicines.Objects.Category;
import com.example.brayandavid.homemedicines.Objects.Product;
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
public class TaskProducts extends AsyncTask<String, Integer, List<Product>> {

    private Context mContext;

    public TaskProducts(Context context) {
        mContext = context;
    }

    @Override
    protected List<Product> doInBackground(String... strings) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet del = new HttpGet("http://13.90.130.197/product");
        del.setHeader("content-type", "application/json");
        del.setHeader("Authorization", Security.getToken());

        try {
            HttpResponse resp = httpClient.execute(del);
            String respStr = EntityUtils.toString(resp.getEntity());

            JSONArray respJSON = new JSONArray(respStr);

            List<Product> productsList = new ArrayList<>();

            for (int i = 0; i < respJSON.length(); i++) {
                JSONObject obj = respJSON.getJSONObject(i);

                Product product = new Product();
                product.setId(obj.getString("id"));
                product.setName(obj.getString("name"));
                product.setDescription(obj.getString("description"));
                product.setEachPrice(obj.getDouble("eachPrice"));
                product.setMedicalCharacteristics(obj.getString("medical_characteristics"));
                product.setVolume(obj.getString("volume"));

              /*  List<String> phothos = new ArrayList<>();
                JSONArray photosJson = obj.getJSONArray("photos");
                for (int j = 0; j < photosJson.length(); j++)
                    phothos.add(photosJson.getString(j));

                product.setPhotos(phothos);*/

                JSONObject categoryJson = obj.getJSONObject("category");
                Category category = new Category();
                category.setId(categoryJson.getString("id"));
                category.setName(categoryJson.getString("name"));

                product.setCategory(category);
                productsList.add(product);
            }

            return productsList;
        } catch (Exception ex) {
            Log.e("ServicioRest", "Error!", ex);
        }
        return new ArrayList<>();
    }


    @Override
    protected void onPostExecute(List<Product> products) {
        try {
            super.onPostExecute(products);
        }catch (Exception e) {
            System.out.print(e.toString());
        }
    }
}
