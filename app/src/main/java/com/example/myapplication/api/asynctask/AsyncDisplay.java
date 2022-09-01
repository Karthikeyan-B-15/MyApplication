package com.example.myapplication.api.asynctask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AsyncDisplay extends AppCompatActivity {
    TextView display;
    String jsondata;
    AsyncAdapter adapter;
    RecyclerView recyclerView;
    List<AsyncModel> alist;
    LinearLayoutManager layoutManager;
    Bitmap imgmap;
    JSONObject[] jsons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_display);
        recyclerView=(RecyclerView)findViewById(R.id.asynccycle);
        alist=new ArrayList<>();
        Intent intent=getIntent();
        try {
            JSONArray array =new JSONArray(intent.getStringExtra("json"));
            int size = array.length();
            ArrayList<JSONObject> arrays = new ArrayList<JSONObject>();
            for (int i = 0; i < size; i++) {
                JSONObject object = array.getJSONObject(i);
                arrays.add(object);
            }
             jsons = new JSONObject[arrays.size()];
            arrays.toArray(jsons);
            for(int i=0;i<size;i++){
//
                alist.add(new AsyncModel(jsons[i].getString("first_name"),
                        jsons[i].getString("last_name"),
                        jsons[i].getString("email"),
                        jsons[i].getString("avatar")));
            }
        } catch (JSONException e) {
            e.printStackTrace();

        }
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new AsyncAdapter(alist,this);
        recyclerView.setAdapter(adapter);
    }
    public static Drawable LoadImage(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }
}