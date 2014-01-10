package com.rottentomatoes.rottentomatoeslist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by jennatauro on 1/9/2014.
 */
public class MovieDetails extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        TextView myTextView = (TextView) findViewById(R.id.test_text);
        myTextView.setText("YOOOOOO");


    }

}
