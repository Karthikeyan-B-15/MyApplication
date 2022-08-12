package com.example.myapplication;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.transform.sax.SAXResult;

public class AsyncData extends AsyncTask<Void,Void,String> {
    TextView gettext;
    AsyncData(TextView gettext){
        this.gettext=gettext;
    }
    String data1;
    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL url=new URL("https://reqres.in/api/users?page=2");
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            InputStream inputStream=connection.getInputStream();
            if(inputStream==null){
                return "Data is not fetch";
            }
            BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuilder stringBuilder=new StringBuilder();
            while ((line=br.readLine())!=null){
                stringBuilder.append(line);
            }
           return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s.equalsIgnoreCase("Data is not fetch")){
           gettext.setText("Data is not found");
        }
        else{
            try {
               JSONObject root=new JSONObject(s);

                JSONArray array=root.getJSONArray("data");
                int size = array.length();
                ArrayList<JSONObject> arrays = new ArrayList<JSONObject>();
                for (int i = 0; i < size; i++) {
                    JSONObject object = array.getJSONObject(i);
                    //Blah blah blah...
                    arrays.add(object);
                }
                JSONObject[] jsons = new JSONObject[arrays.size()];
                arrays.toArray(jsons);
                String data=jsons[0].getString("email");
                data1= root.getString("data");
                gettext.setText(data);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
