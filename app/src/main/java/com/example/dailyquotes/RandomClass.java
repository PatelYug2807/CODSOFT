package com.example.dailyquotes;

import androidx.fragment.app.Fragment;

import com.example.dailyquotes.Quotes.FragQuote1;
import com.example.dailyquotes.Quotes.FragQuote10;
import com.example.dailyquotes.Quotes.FragQuote11;
import com.example.dailyquotes.Quotes.FragQuote12;
import com.example.dailyquotes.Quotes.FragQuote13;
import com.example.dailyquotes.Quotes.FragQuote14;
import com.example.dailyquotes.Quotes.FragQuote2;
import com.example.dailyquotes.Quotes.FragQuote3;
import com.example.dailyquotes.Quotes.FragQuote4;
import com.example.dailyquotes.Quotes.FragQuote5;
import com.example.dailyquotes.Quotes.FragQuote6;
import com.example.dailyquotes.Quotes.FragQuote7;
import com.example.dailyquotes.Quotes.FragQuote8;
import com.example.dailyquotes.Quotes.FragQuote9;

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
        fragmentList.add(new FragQuote6());
        fragmentList.add(new FragQuote7());
        fragmentList.add(new FragQuote8());
        fragmentList.add(new FragQuote9());
        fragmentList.add(new FragQuote10());
        fragmentList.add(new FragQuote11());
        fragmentList.add(new FragQuote12());
        fragmentList.add(new FragQuote13());
        fragmentList.add(new FragQuote14());
        Random rd = new Random();
        int randInd = rd.nextInt(fragmentList.size());
        return fragmentList.get(randInd);

    }

}
