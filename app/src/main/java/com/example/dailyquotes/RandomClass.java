package com.example.dailyquotes;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.example.dailyquotes.Quotes.FragQuote1;
import com.example.dailyquotes.Quotes.FragQuote2;
import com.example.dailyquotes.Quotes.FragQuote3;
import com.example.dailyquotes.Quotes.FragQuote4;
import com.example.dailyquotes.Quotes.FragQuote5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomClass {
    private  List<Fragment> fragmentList = new ArrayList<>();

    public  Fragment randomFrag() {
        fragmentList.add(new FragQuote1());
        fragmentList.add(new FragQuote2());
        fragmentList.add(new FragQuote3());
        fragmentList.add(new FragQuote4());
        fragmentList.add(new FragQuote5());
//        fragmentList.add(new FragQuote6());
//        fragmentList.add(new FragQuote7());
//        fragmentList.add(new FragQuote8());
//        fragmentList.add(new FragQuote9());
//        fragmentList.add(new FragQuote10());
        Random rd = new Random();
        int randInd = rd.nextInt(fragmentList.size());
        return fragmentList.get(randInd);

    }

}
