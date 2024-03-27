package com.example.dailyquotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.example.dailyquotes.RandomClass.*;
import com.google.firebase.FirebaseApp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    SwipeRefreshLayout swipe;
    RandomClass r1 = new RandomClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipe = findViewById(R.id.swipe1);
        swipe.setOnRefreshListener(this);
        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        Fragment f1 = r1.randomFrag();
        getSupportFragmentManager().beginTransaction().replace(R.id.frag1, f1).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.fav) {
            try {
//                Toast.makeText(MainActivity.this, "Favorites", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, Favroites.class));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("MainActivity", "Error starting FavoritesActivity", e);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRefresh() {
        Fragment f1 = r1.randomFrag();
        getSupportFragmentManager().beginTransaction().replace(R.id.frag1, f1).commit();
        swipe.setRefreshing(false);
    }
}


