package com.rottentomatoes.rottentomatoeslist;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.TextView;

public class MovieDetailsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String displayTitle = intent.getStringExtra("Titles");

        setContentView(R.layout.activity_movie_details);
        TextView titleText = (TextView) findViewById(R.id.title_detail);
        titleText.setText(displayTitle);
    }

}
