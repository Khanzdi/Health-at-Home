package com.example.brayandavid.homemedicines.Conection;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.example.brayandavid.homemedicines.Objects.Product;
import com.google.common.io.ByteStreams;
import com.loopj.android.http.HttpGet;

import java.io.IOException;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;


/**
 * Created by Kevin Ortiz on 16/03/2018.
 */

public class TaskImages extends AsyncTask<Product, Bitmap, Bitmap> {
    private Context mContext;

    private ImageView imageView;
    public TaskImages(ImageView imageView) {
        this.imageView = imageView;
    }
    @Override
    protected Bitmap doInBackground(Product... products) {
        Product product = products[0];
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://13.90.130.197/product/" + product.getId() + "/image/1");
        httpGet.setHeader("content-type", "application/json");

        HttpResponse resp = null;
        try {
            byte[] image = ByteStreams.toByteArray(httpClient.execute(httpGet).getEntity().getContent());
            Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }
}