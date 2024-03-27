package com.example.dailyquotes.Quotes;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dailyquotes.AdapterRc;
import com.example.dailyquotes.Favroites;
import com.example.dailyquotes.R;
import com.example.dailyquotes.RCModel;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class FragQuote1 extends Fragment{
    TextView quote, name;
    Button share,fav;
    ImageView iv;

    //Creating DB connection
    FirebaseDatabase database=FirebaseDatabase.getInstance();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag_quote1, container, false);

        //Finding ID's

        share = view.findViewById(R.id.share);
        quote = view.findViewById(R.id.ironmanshare1);
        iv=view.findViewById(R.id.ironImg);
        name = view.findViewById(R.id.IronMan);
        fav=view.findViewById(R.id.fav);

        //Creating onClickListener on share btn

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

        //Adding Favroites

        fav.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                {
                        database.getReference().child("Fav").child("Iron").setValue(new RCModel(R.drawable.ironman,name.getText().toString()));
                }

            }
        });

        return view;
    }


}