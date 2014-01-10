package com.rottentomatoes.rottentomatoeslist;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by jennatauro on 1/8/2014.
 */

public class RottenTomatoesWebAPITask extends AsyncTask<String, Integer, String>
{
    private ProgressDialog progDialog;
    private Context context;
    private MainActivity activity;
    private static final String debugTag = "RottenTomatoesAPITask";

    /**
     * Construct a task
     * @param activity
     */
    public RottenTomatoesWebAPITask(MainActivity activity) {
        super();
        this.activity = activity;
        this.context = this.activity.getApplicationContext();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progDialog = ProgressDialog.show(this.activity, "Search", "Looking for movies." , true, false);
    }

    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection urlConnection = null;
        String ret="";
        try{
            URL rtUrl = new URL("http://api.rottentomatoes.com/api/public/v1.0/lists/movies/box_office.json?limit=50&country=us&apikey=cub9wdnvd482cd37gsbwb7yf");
            urlConnection = (HttpURLConnection) rtUrl.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String input;
            while((input = in.readLine()) != null){
                ret += input;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            urlConnection.disconnect();
        }
        return ret;
    }

    @Override
    protected void onPostExecute(String result){
        ArrayList <MovieData> moviedata = new ArrayList<MovieData>();

        progDialog.dismiss();
        if(result.length()==0){
            this.activity.alert("Unable to find movie data.  Try again later.");//KEEP GETTING THIS!! which means result from the downloadfromserver has nothing in it
            return;
        }

        try{
            JSONObject respObj = new JSONObject(result);
            JSONArray movies = respObj.getJSONArray("movies");
            for(int i=0;i<movies.length();i++){
                JSONObject movie = movies.getJSONObject(i);
                String movieTitle = movie.getString("title");

                //add other json parsing for image, etc here

                moviedata.add(new MovieData(movieTitle));
            }


        }
        catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.activity.setMovies(moviedata);
    }
}

