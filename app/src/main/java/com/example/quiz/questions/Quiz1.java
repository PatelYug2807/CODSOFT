package com.example.quiz.questions;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz.R;
import com.example.quiz.ScienceQuiz;


public class Quiz1 extends Fragment {

    // Define TextView for question number
    TextView no;
   final String ans="Sir Isaac Newton";
    Button next,previous;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz1, container, false);

        // Find the TextView by ID
        no = view.findViewById(R.id.QueNo);

        next=view.findViewById(R.id.next);
        previous=view.findViewById(R.id.previous);

        // Create an instance of ScienceQuiz to get the question count
        ScienceQuiz sq = new ScienceQuiz();

        // Set the question number text
        no.setText(String.valueOf(sq.getCount())+".");

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               RadioGroup radioGroup=view.findViewById(R.id.radioGrp);
               int selected=radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton=view.findViewById(selected);
                String ans=radioButton.getText().toString();
                if(selected!=-1)
                {
                    Toast.makeText(getContext(), "Selected answer: " + ans, Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
