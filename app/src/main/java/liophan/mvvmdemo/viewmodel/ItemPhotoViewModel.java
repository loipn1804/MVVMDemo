package liophan.mvvmdemo.viewmodel;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;

import com.googlecode.flickrjandroid.photos.Photo;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import liophan.mvvmdemo.R;

/**
 * Copyright (c) 2017, Stacck Pte Ltd. All rights reserved.
 *
 * @author Lio <lphan@stacck.com>
 * @version 1.0
 * @since February 26, 2017
 */

public class ItemPhotoViewModel implements ViewModel {

    private Photo mPhoto;

    private DisplayImageOptions mImageOptions;

    public ItemPhotoViewModel(Photo photo) {
        mPhoto = photo;
        mImageOptions = new DisplayImageOptions.Builder().cacheInMemory(true)
                .showImageForEmptyUri(R.color.colorAccent)
                .showImageOnLoading(R.color.colorPrimary)
                .cacheOnDisk(true).build();
    }

    public Photo getPhoto() {
        return mPhoto;
    }

    public void setPhoto(Photo photo) {
        mPhoto = photo;
    }

    public String getDescription() {
        return mPhoto.getDescription() != null ? mPhoto.getDescription() : "NA";
    }

    public String getAuthorName() {
        return mPhoto.getOwner().getUsername() != null ? mPhoto.getOwner().getUsername() : "NA";
    }

    @BindingAdapter({"bind:loadImage"})
    public static void loadImage(ImageView view, Photo photo) {
        Log.e("LIO", photo.getId() + " - " + photo.getLargeUrl());
        ImageLoader.getInstance().displayImage(photo.getLargeUrl(), view);
    }

    @Override
    public void destroy() {

    }
}
