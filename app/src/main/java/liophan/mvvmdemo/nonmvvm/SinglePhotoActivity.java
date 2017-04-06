package liophan.mvvmdemo.nonmvvm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import liophan.mvvmdemo.R;

/**
 * Copyright (c) 2017, Stacck Pte Ltd. All rights reserved.
 *
 * @author Lio <lphan@stacck.com>
 * @version 1.0
 * @since March 03, 2017
 */

public class SinglePhotoActivity extends AppCompatActivity {

    private ImageView mImageView;

    private DisplayImageOptions mImageOptions;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_photo);

        mImageView = (ImageView) findViewById(R.id.imv);

        mImageOptions = new DisplayImageOptions.Builder().cacheInMemory(true)
                .showImageForEmptyUri(R.color.colorAccent)
                .showImageOnLoading(R.color.colorPrimary)
                .considerExifParams(true)
                .cacheOnDisk(true).build();

        String url = "https://stacck.s3.amazonaws.com/uploads/photos/000/011/011/original/open-uri20170303-30066-12hh92e?1488524114";
        ImageLoader.getInstance().displayImage(url, mImageView, mImageOptions);
    }
}
