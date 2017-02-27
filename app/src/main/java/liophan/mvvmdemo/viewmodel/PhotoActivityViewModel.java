package liophan.mvvmdemo.viewmodel;

import android.util.Log;
import android.view.View;

import com.googlecode.flickrjandroid.photos.Photo;

import java.util.ArrayList;
import java.util.List;

import liophan.mvvmdemo.flickr.FlickrApi;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Copyright (c) 2017, Stacck Pte Ltd. All rights reserved.
 *
 * @author Lio <lphan@stacck.com>
 * @version 1.0
 * @since February 26, 2017
 */

public class PhotoActivityViewModel implements ViewModel {
    private PhotoActivityViewModelListener mListener;

    public PhotoActivityViewModel(PhotoActivityViewModelListener listener) {
        mListener = listener;
        loadListPhoto();
    }

    private CompositeSubscription mSubscriptions = new CompositeSubscription();

    @Override
    public void destroy() {
        mListener = null;
        if (mSubscriptions != null) {
            mSubscriptions.clear();
        }
    }

    public void action1(View view) {
        loadListPhoto();
    }

    public void action2(View view) {

    }

    public void action3(View view) {

    }

    public void action4(View view) {

    }

    private void loadListPhoto() {
        Observable<List<Photo>> observable = Observable.fromCallable(() -> {
            List<Photo> photos = new ArrayList<>();
            try {
                photos = FlickrApi.loadImages(30);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return photos;
        });

        Action1<List<Photo>> action1 = listPhoto -> {
            for (Photo photo : listPhoto) {
                Log.e("LIO", photo.getUrl() + "\n" + photo.getLargeUrl() + "\n" + photo.getMediumUrl() + "\n" + photo.getThumbnailUrl());
            }
            mListener.updateListData(listPhoto);
        };

        mSubscriptions.add(observable.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(action1));
    }

    public interface PhotoActivityViewModelListener {
        void updateListData(List<Photo> photos);
    }
}
