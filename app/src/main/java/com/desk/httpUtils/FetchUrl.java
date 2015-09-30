package com.desk.httpUtils;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by kshitij.sharma on 9/30/2015.
 */
public class FetchUrl {

    Context context;
    URL url;

    public FetchUrl(Context context) {
        super();
        this.context = context;
    }

    public String getdata(String url) {
        if (url == null) {
            System.out.println("url is null");
            return null;
        }

        new service().execute(url);

        return null;
    }

    private class service extends AsyncTask<String, Integer, String> {

        public service() {
            super();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            URL url = null;
            try {
                url = new URL(params[0]);
                System.out.println("url recieved in async task " + url);

                URLConnection connection = url.openConnection();
                connection.connect();
                InputStream inputStream = new BufferedInputStream(url.openStream(),10*1024);

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }
}
