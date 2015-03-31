package com.cheesecake.task;

import android.os.AsyncTask;
import android.util.Log;

import com.cheesecake.pojo.ArticlePojo;
import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by tiozao on 3/30/15.
 */
public class RequestJSONTask extends AsyncTask<String, Void, ArticlePojo[]> {

    public static final int OK = 200;

    @Override
    protected ArticlePojo[] doInBackground(String... params) {
        HttpClient client = new DefaultHttpClient();
        HttpGet getMethod = new HttpGet(params[0]);
        ArticlePojo[] articles = null;

        try {
            HttpResponse response = client.execute(getMethod);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == OK){
                HttpEntity entity = response.getEntity();
                articles = parseJSON(entity.getContent());
            } else {
                Log.e("Parse JSON", "Failed to search for articles.");
            }
        } catch (IOException e) {
            Log.e("Error parsing JSON", e.getMessage());
        }

        return articles;
    }

    private ArticlePojo[] parseJSON(InputStream inputStream) {
        Gson gson = new Gson();
        InputStreamReader reader = new InputStreamReader(inputStream);
        return gson.fromJson(reader, ArticlePojo[].class);
    }

}
