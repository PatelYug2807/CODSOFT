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
import com.example.dailyquotes.RCModel;
import com.google.firebase.database.FirebaseDatabase;


public class FragQuote2 extends Fragment{
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    TextView quote, name;
    Button share,fav;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag_quote2, container, false);
        share = view.findViewById(R.id.share);
        quote = view.findViewById(R.id.quote);
        name = view.findViewById(R.id.Captian);
        fav=view.findViewById(R.id.fav);
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
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                {
                    database.getReference().child("Fav").child("Cap").setValue(new RCModel(R.drawable.captian,name.getText().toString()));
                }
            }
        });
        return view;
    }


}