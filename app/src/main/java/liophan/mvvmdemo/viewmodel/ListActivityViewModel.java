package liophan.mvvmdemo.viewmodel;

import android.util.Log;
import android.view.View;

import com.googlecode.flickrjandroid.photos.Photo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import liophan.mvvmdemo.flickr.FlickrApi;
import liophan.mvvmdemo.model.User;
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
 * @since February 25, 2017
 */

public class ListActivityViewModel implements ViewModel {

    private ListActivityViewModelListener mListener;

    public ListActivityViewModel(ListActivityViewModelListener listener) {
        mListener = listener;
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
        Random random = new Random();
        List<User> users = new ArrayList<>();
        int size = random.nextInt(10) + 5;
        for (int i = 0; i < size; i++) {
            users.add(User.randomUser());
        }
        mListener.updateListUser(users);
    }

    public void action2(View view) {

    }

    public void action3(View view) {

    }

    public void action4(View view) {
        Observable<List<Photo>> observable = Observable.fromCallable(() -> {
            List<Photo> photos = new ArrayList<Photo>();
            try {
                photos = FlickrApi.loadImages(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return photos;
        });

        Action1<List<Photo>> action1 = listPhoto -> {
            for (Photo photo : listPhoto) {
                Log.e("LIO", photo.getUrl() + "\n" + photo.getLargeUrl() + "\n" + photo.getMediumUrl() + "\n" + photo.getThumbnailUrl());
            }
        };

        mSubscriptions.add(observable.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(action1));
    }

    public interface ListActivityViewModelListener {
        void updateListUser(List<User> users);
    }
}
