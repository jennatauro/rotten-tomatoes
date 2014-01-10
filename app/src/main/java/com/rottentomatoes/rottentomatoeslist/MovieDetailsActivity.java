package com.rottentomatoes.rottentomatoeslist;

import android.content.Intent;
import android.graphics.drawable.Drawable;
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
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetailsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String displayTitle = intent.getStringExtra("Titles");
        //String displayImageUrl = intent.getStringExtra("Images");
        String displayGeneralCons = intent.getStringExtra("GeneralCons");
        String displaySynopsis = intent.getStringExtra("Synopsis");

        setContentView(R.layout.activity_movie_details);
        TextView titleText = (TextView) findViewById(R.id.title_detail);
        titleText.setText(displayTitle);

        TextView consText = (TextView) findViewById(R.id.gencons_detail);
        consText.setText(displayGeneralCons);

        TextView synopsisText = (TextView) findViewById(R.id.synopsis_detail);
        synopsisText.setText(displaySynopsis);


    }

}
