package liophan.mvvmdemo.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableInt;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import liophan.mvvmdemo.model.User;

/**
 * Copyright (c) 2017, Stacck Pte Ltd. All rights reserved.
 *
 * @author Lio <lphan@stacck.com>
 * @version 1.0
 * @since February 23, 2017
 */

public class UserViewModel extends BaseObservable implements ViewModel {

    private Context mContext;

    public ObservableInt txtNameVisibility;

    private User mUser;

    public UserViewModel(Context context, User user) {
        mContext = context;
        txtNameVisibility = new ObservableInt(View.VISIBLE);
        mUser = user;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }

    public String getName() {
        return mUser.getName();
    }

    public String getSchool() {
        return mUser.getSchool();
    }

    public int getAge() {
        return mUser.getAge();
    }

    public void btnActionClick(View view) {
        setUser(User.randomUser());
        notifyChange();
    }

    public void toggleView(View view) {
        if (txtNameVisibility.get() == View.VISIBLE) {
            txtNameVisibility.set(View.INVISIBLE);
        } else {
            txtNameVisibility.set(View.VISIBLE);
        }
    }

    @BindingAdapter({"bind:textView"})
    public static void textView(TextView view, User user) {
        view.setText(user.getName() + "-" + user.getSchool() + "-" + user.getAge());
    }

    @Override
    public void destroy() {

    }
}
