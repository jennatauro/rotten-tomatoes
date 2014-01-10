package com.rottentomatoes.rottentomatoeslist;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class MovieDetailsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String displayTitle = intent.getStringExtra("Titles");
        String displayGeneralCons = intent.getStringExtra("GeneralCons");
        String displaySynopsis = intent.getStringExtra("Synopsis");
        String displayImageUrl = intent.getStringExtra("Images");

        setContentView(R.layout.activity_movie_details);
        TextView titleText = (TextView) findViewById(R.id.title_detail);
        titleText.setText(displayTitle);

        TextView consText = (TextView) findViewById(R.id.gencons_detail);
        consText.setText(displayGeneralCons);

        TextView synopsisText = (TextView) findViewById(R.id.synopsis_detail);
        synopsisText.setText(displaySynopsis);

        new DownloadImageTask((ImageView) findViewById(R.id.image_detail)).execute(displayImageUrl);


    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

}
