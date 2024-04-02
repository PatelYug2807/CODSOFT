package com.example.quiz;

import androidx.fragment.app.Fragment;

import com.example.quiz.questions.Quiz1;

import java.util.ArrayList;
import java.util.Random;

public class RandomSci {

    private ArrayList<Fragment> arr;

    public Fragment randomFrag()
    {
        //adding all the fragments
        arr.add(new Quiz1());

        //creating a random object to pass a random fragment
        Random rd = new Random();
        int randInd = rd.nextInt(arr.size());
        return arr.get(randInd);
    }
}
