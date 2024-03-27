package com.example.dailyquotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Favroites extends AppCompatActivity {
    //Creating a Arraylist to send to Adapter
    ArrayList<RCModel> favoritesList=new ArrayList<>();

    //Creating Adapter
    AdapterRc adapter = new AdapterRc(favoritesList, this);

    //Creating DB connection
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favroites);

        //Finiding RecyclerView by Id
        RecyclerView rc = findViewById(R.id.rcViev);

        //Retriving data From DB
        database.getReference("Fav").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                favoritesList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    // Getting RCModel object from dataSnapshot
                    RCModel rcModel = dataSnapshot.getValue(RCModel.class);

                    // Adding the retrieved RCModel object to the favoritesList
                    favoritesList.add(rcModel);
                }


                // Notifying the adapter that data has changed
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //Sending List to Adapter
        rc.setAdapter(adapter);

        //Creating Layout for Recycler view
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rc.setLayoutManager(lm);
    }
}
