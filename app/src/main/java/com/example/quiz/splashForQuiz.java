package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class splashForQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_for_quiz);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=getIntent();
                 String name=i.getStringExtra("name");

                switch (name)
                {
                    case "Science Quiz":
                    {
                        startActivity(new Intent(getApplicationContext(), ScienceQuiz.class));
                        finish();
                        break;
                    }
                    case "Maths Quiz":
                    {
                        startActivity(new Intent(getApplicationContext(), MathsQuiz.class));
                        finish();
                        break;
                    }
                    case "Random Quiz":
                    {
                        startActivity(new Intent(getApplicationContext(), RandomQuiz.class));
                        finish();
                        break;
                    }

                }

            }
        },2000);

    }
}