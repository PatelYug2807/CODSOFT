package com.example.dailyquotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.example.dailyquotes.RandomClass.*;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    SwipeRefreshLayout swipe;
    RandomClass r1=new RandomClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipe = findViewById(R.id.swipe1);
        swipe.setOnRefreshListener(this);
        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        Fragment f1 =r1.randomFrag();
        getSupportFragmentManager().beginTransaction().replace(R.id.frag1, f1).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(getApplicationContext(), "Favorites", Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public void onRefresh() {
        Fragment f1 = r1.randomFrag();
        getSupportFragmentManager().beginTransaction().replace(R.id.frag1, f1).commit();
        swipe.setRefreshing(false);
    }
}
