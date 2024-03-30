package com.example.todo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Adding all the data members
Button addNote;
RecyclerView rc;
ArrayList<RCModel> mylist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        // Finding all the id's

        addNote=findViewById(R.id.addBtn);
        rc=findViewById(R.id.rc);

        mylist=getData();
        rc.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        AdapterRC adapter = new AdapterRC(mylist,getApplicationContext());

        rc.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        //Listener on addNote to add a Note

        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Calling the add fragment
               startActivity(new Intent(getApplicationContext(),AddTask.class));
            }
        });




    }

    public ArrayList<RCModel> getData() {
        ArrayList<RCModel> arr = new ArrayList<>();
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("list", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = preferences.getString("list1", null);
        if (json != null) {
            Type type = new TypeToken<ArrayList<RCModel>>() {}.getType();
            arr = gson.fromJson(json, type);
        }
        Log.e("data","ffgf");
        return arr;
    }
}