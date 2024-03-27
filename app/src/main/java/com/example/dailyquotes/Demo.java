package com.example.dailyquotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dailyquotes.Quotes.FragQuote1;

public class Demo extends AppCompatActivity {
    ImageView iv;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        Intent i=getIntent();
        String name=i.getStringExtra("name");
        int img=i.getIntExtra("pic",0);
        iv=findViewById(R.id.image);
        switch (name)
        {
            case "IronMan":
            {
                iv.setImageResource(img);
                break;
            }
        }
    }
}