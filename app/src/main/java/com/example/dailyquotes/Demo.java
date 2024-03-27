package com.example.dailyquotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dailyquotes.Quotes.FragQuote1;

public class Demo extends AppCompatActivity {
    //Making all Views
    ImageView iv;
    Button share;
    TextView tv,quote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        //Initializing the views
        quote=findViewById(R.id.quote);
        iv=findViewById(R.id.image);
        tv=findViewById(R.id.name);
        share=findViewById(R.id.share);

        //Getting data from Intent
        Intent i=getIntent();
        String name=i.getStringExtra("name");
        int img=i.getIntExtra("pic",0);
        String qoutes=i.getStringExtra("quote");

        //Setting data to XML
        iv.setImageResource(img);
        quote.setText(qoutes);
        tv.setText(name);

        //share the text

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Quote by " + name + " is- *" + quote.getText().toString() + "*");
                startActivity(shareIntent);
            }
        });


    }
}