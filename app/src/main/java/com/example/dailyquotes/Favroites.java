package com.example.dailyquotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Favroites extends AppCompatActivity {
    ArrayList<RCModel> favoritesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favroites);


        RecyclerView rc = findViewById(R.id.rcViev);

        // Retrieve the ArrayList of favorites from the intent
         favoritesList = new ArrayList<>();
        ArrayList<RCModel> receivedList;
        receivedList = (ArrayList<RCModel>) getIntent().getSerializableExtra("favArr");

        if (receivedList != null) {
            favoritesList.addAll(receivedList);
        }

        favoritesList.add(new RCModel(R.drawable.aquman, "hello"));
        favoritesList.add(new RCModel(R.drawable.aquman, "hello"));

        AdapterRc adapter = new AdapterRc(favoritesList, this);
        rc.setAdapter(adapter);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        rc.setLayoutManager(lm);
    }
}
