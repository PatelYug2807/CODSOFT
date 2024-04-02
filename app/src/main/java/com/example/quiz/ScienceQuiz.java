package com.example.quiz;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.quiz.questions.Quiz1;

import java.util.Random;

public class ScienceQuiz extends AppCompatActivity {
    //creating arraylist and
        int count=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_science_quiz);
        RandomSci rs=new RandomSci();
        getSupportFragmentManager().beginTransaction().replace(R.id.scienceAc,new Quiz1()).commit();



    }

    public int getCount() {
        return count;
    }
}