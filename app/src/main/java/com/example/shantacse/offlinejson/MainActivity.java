package com.example.shantacse.offlinejson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    employeeAdapter adapter;
    List<employee> employeeLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.myrecycle);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        employeeLists = new ArrayList<>();

        callofflinedata();
    }


    public void callofflinedata() {

        String json;

        try
        {
            InputStream is = getApplicationContext().getAssets().open("a.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer,"UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0 ; i < jsonArray.length(); i++)
            {
                JSONObject object = jsonArray.getJSONObject(i);
                employeeLists.add(new employee(

                   object.getString("name"),
                   object.getString("phone")

                ));
            }

            adapter = new employeeAdapter(employeeLists, getApplicationContext());
            recyclerView.setAdapter(adapter);

        } catch (IOException e)
        {
            e.printStackTrace();

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
