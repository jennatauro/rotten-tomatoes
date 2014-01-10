package com.rottentomatoes.rottentomatoeslist;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import android.widget.Button;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    private ArrayList<MovieData> movies;
    private ListView movieList;
    private LayoutInflater layoutInflator;
    private Button fetchmoviesButton;
    private RottenTomatoesImageTask imgFetcher;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.movieList = (ListView) findViewById(R.id.movie_list);
        this.layoutInflator = LayoutInflater.from(this);
        this.fetchmoviesButton = (Button)this.findViewById(R.id.fetch_movies_button);
        this.imgFetcher = new RottenTomatoesImageTask(this);


        this.fetchmoviesButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                RottenTomatoesWebAPITask rtTask = new RottenTomatoesWebAPITask(MainActivity.this);
                try {
                    rtTask.execute();
                } catch (Exception e) {
                    rtTask.cancel(true);
                    alert(getResources().getString(R.string.no_movies));
                }


            }
        });
    }

    public void alert (String msg)
    {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    public static class MyViewHolder {
        public TextView movieTitle;
        public ImageView image;
        public MovieData movie;
    }

    public void setMovies(ArrayList<MovieData> movies) {
        this.movies = movies;
        this.movieList.setAdapter(new MovieDataAdapter(this,this.imgFetcher, this.layoutInflator, this.movies));
        this.movieList.setOnItemClickListener(this);
    }


    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        // Then you start a new Activity via Intent
        MyViewHolder holder = (MyViewHolder) v.getTag();
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse(holder.movie.getMovieDetailURL()));
        startActivity(intent);
    }

}