package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //Creating data members
    TextView science,maths,random;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //finding all by there id's
        science=findViewById(R.id.science);
        maths=findViewById(R.id.maths);
        random=findViewById(R.id.random);

        //creating on click listener to all the textviews
        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //redirecting to splash and the the quiz
                Intent i=new Intent(getApplicationContext(),splashForQuiz.class);
                i.putExtra("name",science.getText().toString());
                startActivity(i);
            }
        });

        maths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //redirecting to splash and the the quiz
                Intent i=new Intent(getApplicationContext(),splashForQuiz.class);
                i.putExtra("name",random.getText().toString());
                startActivity(i);
            }
        });

        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //redirecting to splash and the the quiz
                Intent i=new Intent(getApplicationContext(),splashForQuiz.class);
                i.putExtra("name",random.getText().toString());
                startActivity(i);
            }
        });

    }
}