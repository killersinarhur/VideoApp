package com.ramon.videoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ramon.videoapp.movie.DiscoverMovieFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container,DiscoverMovieFragment.newInstance())
                .addToBackStack("discover")
                .commit();

    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount()>1){
            getSupportFragmentManager().popBackStack();
        }else{
            finish();
        }

    }
}
