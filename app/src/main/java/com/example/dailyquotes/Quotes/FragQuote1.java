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

import java.util.ArrayList;


public class FragQuote1 extends Fragment{
    TextView quote, name;
    Button share,fav;
    ImageView iv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag_quote1, container, false);
        share = view.findViewById(R.id.share);
        quote = view.findViewById(R.id.ironmanshare1);
        iv=view.findViewById(R.id.ironImg);
        name = view.findViewById(R.id.IronMan);
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

        fav=view.findViewById(R.id.fav);
        fav.setOnClickListener(new View.OnClickListener() {
            int count=0;
            @Override
            public void onClick(View v) {
//               if(count==0)
               {
                   Toast.makeText(getContext(),"Added to Favorites",Toast.LENGTH_LONG).show();
                   ArrayList<RCModel> arr=new ArrayList<>();
                   arr.add(new RCModel(R.drawable.ironman,name.getText().toString()));
                   Intent i=new Intent(getActivity(), Favroites.class);
                   i.putExtra("favArr",arr);
                   startActivity(i);
                   count++;
               }

            }
        });
        return view;
    }


}