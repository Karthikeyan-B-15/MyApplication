package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AsyncDisplay extends AppCompatActivity {
    TextView display;
    String jsondata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_display);
        display=(TextView)findViewById(R.id.disdata);
        Intent intent=getIntent();
        try {
            JSONArray array =new JSONArray(intent.getStringExtra("json"));
            int size = array.length();
            ArrayList<JSONObject> arrays = new ArrayList<JSONObject>();
            for (int i = 0; i < size; i++) {
                JSONObject object = array.getJSONObject(i);
                //Blah blah blah...
                arrays.add(object);
            }
            JSONObject[] jsons = new JSONObject[arrays.size()];
            arrays.toArray(jsons);
           display.setText(jsons[1].getString("email"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}