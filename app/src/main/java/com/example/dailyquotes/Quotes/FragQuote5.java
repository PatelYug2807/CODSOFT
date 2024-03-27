package com.example.dailyquotes.Quotes;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dailyquotes.R;
import com.example.dailyquotes.RCModel;
import com.google.firebase.database.FirebaseDatabase;


public class FragQuote5 extends Fragment{
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    TextView quote, name;
    Button share,fav;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)

    //Initializing Variables
    {
        View view = inflater.inflate(R.layout.fragment_frag_quote5, container, false);
        share = view.findViewById(R.id.share);
        quote = view.findViewById(R.id.quote);
        name = view.findViewById(R.id.name);
        fav=view.findViewById(R.id.fav);

        //For Sharing to Other App
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

        //Adding to favorites
        fav.setOnClickListener(new View.OnClickListener() {
            int count=0;
            @Override
            public void onClick(View v)
            {
                //Addding to Fav
                if(count==0)
                {
                    Toast.makeText(getContext(),"Added to Favorites",Toast.LENGTH_SHORT).show();
                    fav.setText("Remove");
                    database.getReference().child("Fav").child(name.getText().toString()).setValue(new RCModel(R.drawable.thor,name.getText().toString(),quote.getText().toString()));
                    count++;
                }
                //Removing from Fav
                else
                {
                    Toast.makeText(getContext(),"Removed From Favorites",Toast.LENGTH_SHORT).show();
                    fav.setText("Favorites");
                    database.getReference().child("Fav").child(name.getText().toString()).removeValue();
                    count--;
                }

            }
        });
        return view;
    }


}