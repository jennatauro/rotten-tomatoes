package com.rottentomatoes.rottentomatoeslist;

import android.app.Activity;
import android.content.Context;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import java.util.ArrayList;

import org.json.JSONArray;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ArrayList<MovieData> movies;
    private ListView movieList;
    private LayoutInflater layoutInflator;
    private Button movieButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        this.movieList = (ListView) findViewById(R.id.movie_list);
        this.layoutInflator = LayoutInflater.from(this);
        this.movieButton = (Button)this.findViewById(R.id.movie_button);


        this.movieButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                RottenTomatoesWebAPITask rtTask = new RottenTomatoesWebAPITask(MainActivity.this);
                try {
                    rtTask.execute();
                }
                catch (Exception e)
                {
                    rtTask.cancel(true);
                    alert (getResources().getString(R.string.no_movies));
                }


            }
        });
    }


    public void alert (String msg)
    {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }


    /**
     * Bundle to hold refs to row items views.
     *
     */
    public static class MyViewHolder {
        public TextView movieTitle;
        public Button movieButton;
        public MovieData movie;
    }


    public void setMovies(ArrayList<MovieData> movies) {
        this.movies = movies;
        this.movieList.setAdapter(new MovieDataAdapter(this,this.layoutInflator, this.movies));
    }


}