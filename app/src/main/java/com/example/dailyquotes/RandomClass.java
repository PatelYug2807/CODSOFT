package com.example.dailyquotes;

import android.content.Context;
import android.content.Intent;

import java.util.Random;

public class RandomClass {
    private static final String[] ACTIVITY_CLASSES = {
            "com.example.dailyquotes.Quotes.Quote1",
            "com.example.dailyquotes.Quotes.Quote2",
//            "com.example.dailyquotes.Quote3",
//            "com.example.dailyquotes.Quote4",
//            "com.example.dailyquotes.Quote5",
//            "com.example.dailyquotes.Quote6",
//            "com.example.dailyquotes.Quote7",
//            "com.example.dailyquotes.Quote8",
//            "com.example.dailyquotes.Quote9",
//            "com.example.dailyquotes.Quote10",
//            "com.example.dailyquotes.Quote11",
//            "com.example.dailyquotes.Quote12",
//            "com.example.dailyquotes.Quote13",
//            "com.example.dailyquotes.Quote14"


    };
    public static void startRandomActivity(Context context) {
        Random random = new Random();
        int index = random.nextInt(ACTIVITY_CLASSES.length);
        String className = ACTIVITY_CLASSES[index];
        try {
            Class<?> clazz = Class.forName(className);
            Intent intent = new Intent(context, clazz);
            context.startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
