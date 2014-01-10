package com.rottentomatoes.rottentomatoeslist;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.rottentomatoes.rottentomatoeslist.MainActivity.MyViewHolder;

import java.util.ArrayList;

public class MovieDataAdapter extends BaseAdapter{ //implements View.OnClickListener {

    private static final String debugTag = "MovieDataAdapter";
    private MainActivity activity;
    private LayoutInflater layoutInflater;
    private ArrayList<MovieData> movies;


    public MovieDataAdapter (MainActivity a, LayoutInflater l, ArrayList<MovieData> data)
    {
        this.activity = a;
        this.layoutInflater = l;
        this.movies = data;
    }

    @Override
    public int getCount() {
        return this.movies.size();
    }

    @Override
    public boolean areAllItemsEnabled ()
    {
        return true;
    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        MyViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate (R.layout.listview_row, parent, false);
            holder = new MyViewHolder();
            holder.movieTitle = (TextView) convertView.findViewById(R.id.movie_title);
            convertView.setTag(holder);
        }
        else {
            holder = (MyViewHolder) convertView.getTag();
        }

        MovieData movie = movies.get(pos);
        holder.movie = movie;
        holder.movieTitle.setText(movie.getTitle());

        return convertView;
    }
}
