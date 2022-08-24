package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Apilib extends AppCompatActivity {
    RecyclerView recyclerView;
    List<AsyncModel> alist;
    LinearLayoutManager layoutManager;
    AsyncAdapter adapter;
    AsyncModel asyncModel;
    DBHelper dbHelper=new DBHelper(Apilib.this);;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apilib);
        recyclerView=(RecyclerView) findViewById(R.id.vollre);
        alist=new ArrayList<>();
        callApi();


    }
    public void callApi(){
        RequestQueue queue= Volley.newRequestQueue(this);
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, "https://reqres.in/api/users?page=2",
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray array=response.getJSONArray("data");
                    for (int i=0;i<array.length();i++){
                       JSONObject object=array.getJSONObject(i);
                      asyncModel= new AsyncModel(Integer.parseInt(object.getString("id")),object.getString("first_name"),
                               object.getString("last_name"),
                               object.getString("email"),
                               object.getString("avatar"));

                      dbHelper.addData(asyncModel);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                layoutManager=new LinearLayoutManager(Apilib.this);
                layoutManager.setOrientation(RecyclerView.VERTICAL);
                recyclerView.setLayoutManager(layoutManager);
                adapter=new AsyncAdapter(dbHelper.getAllData(),Apilib.this);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
    }
}