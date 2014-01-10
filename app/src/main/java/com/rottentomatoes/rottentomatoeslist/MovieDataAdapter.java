package com.rottentomatoes.rottentomatoeslist;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rottentomatoes.rottentomatoeslist.MainActivity.MyViewHolder;

import java.util.ArrayList;

public class MovieDataAdapter extends BaseAdapter{

    private MainActivity activity;
    private LayoutInflater layoutInflater;
    private ArrayList<MovieData> movies;
    private RottenTomatoesImageTask imgFetcher;


    public MovieDataAdapter (MainActivity a, RottenTomatoesImageTask i, LayoutInflater l, ArrayList<MovieData> data)
    {
        this.activity = a;
        this.imgFetcher = i;
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
            holder.image = (ImageView) convertView.findViewById(R.id.movie_image);
            convertView.setTag(holder);
        }
        else {
            holder = (MyViewHolder) convertView.getTag();
        }

        MovieData movie = movies.get(pos);
        holder.movie = movie;
        holder.movieTitle.setText(movie.getTitle());

        if(movie.getImageUrl() != null) {
            holder.image.setTag(movie.getImageUrl());
            Drawable dr = imgFetcher.loadImage(this, holder.image);
            if(dr != null) {
                holder.image.setImageDrawable(dr);
            }
        } else {
            holder.image.setImageResource(R.drawable.tomato_whole_red_1);
        }

        return convertView;
    }
}
