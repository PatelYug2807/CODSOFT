package com.example.todo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    // Adding all the data members
Button addNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        // Finding all the id's

        addNote=findViewById(R.id.addBtn);

        //Listener on addNote to add a Note

        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Calling the add fragment
               startActivity(new Intent(getApplicationContext(),AddTask.class));


            }
        });




    }
}