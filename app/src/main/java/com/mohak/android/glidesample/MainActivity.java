package com.mohak.android.glidesample;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

public class MainActivity extends AppCompatActivity {

    ImageView imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image);
        imageView2 = findViewById(R.id.image2);
        imageView3 = findViewById(R.id.image3);
        imageView4 = findViewById(R.id.image4);
        imageView5 = findViewById(R.id.image5);
        imageView6 = findViewById(R.id.image6);
        imageView7 = findViewById(R.id.image7);
        progressBar = findViewById(R.id.pb_circular);

        progressBar.setVisibility(View.VISIBLE);


        Glide.with(this)
                .load("https://www.android.com/static/2016/img/share/andy-lg.png")
                .into(imageView);

        RequestOptions requestOptions = new RequestOptions()
                .centerCrop();

        Glide.with(this)
                .setDefaultRequestOptions(requestOptions)
                .load("https://www.android.com/static/2016/img/share/andy-lg.png")
                .into(imageView2);

        RequestOptions requestOptions2 = new RequestOptions()
                .circleCrop();

        Glide.with(this)
                .setDefaultRequestOptions(requestOptions2)
                .load("https://www.android.com/static/2016/img/share/andy-lg.png")
                .into(imageView3);

        RequestOptions requestOptions3 = new RequestOptions()
                .override(50, 50);

        Glide.with(this)
                .setDefaultRequestOptions(requestOptions3)
                .load("https://www.android.com/static/2016/img/share/andy-lg.png")
                .into(imageView4);

        RequestOptions requestOptions4 = new RequestOptions()
                .error(R.drawable.errorimage);

        Glide.with(this)
                .setDefaultRequestOptions(requestOptions4)
                .load("https://cdn-images-1.medium.com/max/1200/1*OFJKA8dRYZSb-Kprx-VReg.png")
                .into(imageView5);

        RequestOptions requestOptions5 = new RequestOptions()
                .error(R.drawable.errorimage)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE);

        Glide.with(this)
                .setDefaultRequestOptions(requestOptions5)
                .load("https://sdtimes.com/wp-content/uploads/2018/03/2NqZJYQI_400x400.png")
                .into(imageView6);

        RequestOptions requestOptions6 = new RequestOptions()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.errorimage);

        Glide.with(this)
                .setDefaultRequestOptions(requestOptions6)
                .load("https://sdtimes.com/wp-content/uploads/2018/03/2NqZJYQI_400x400.png")
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        progressBar.setVisibility(View.INVISIBLE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        progressBar.setVisibility(View.INVISIBLE);
                        return false;
                    }
                }).into(imageView7);
    }
}
