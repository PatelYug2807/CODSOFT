package com.example.dailyquotes.Quotes;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.dailyquotes.R;


public class FragQuote4 extends Fragment{
    TextView quote, name;
    Button share;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag_quote4, container, false);
        share = view.findViewById(R.id.share);
        quote = view.findViewById(R.id.quote);
        name = view.findViewById(R.id.Namor);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Quote by " + name.getText().toString() + " is- *" + quote.getText().toString() + "*");
                startActivity(shareIntent);
            }
        });
        return view;
    }


}