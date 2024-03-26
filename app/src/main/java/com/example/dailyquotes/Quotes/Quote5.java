package com.example.dailyquotes.Quotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dailyquotes.R;
import com.example.dailyquotes.RandomClass;

public class Quote5 extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    TextView quote,name;
    Button share;
    SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote5);

        share = findViewById(R.id.share);
        quote = findViewById(R.id.quote);
        swipe = findViewById(R.id.swipe1);
        name=findViewById(R.id.Captian);
        swipe.setOnRefreshListener(this);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT,"Quote by "+name.getText().toString()+" is- *"+quote.getText().toString()+"*");
                startActivity(shareIntent);
            }
        });
    }

    @Override
    public void onRefresh() {
//        RandomClass.startRandomActivity( this);
        swipe.setRefreshing(false);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
