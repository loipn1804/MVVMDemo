package liophan.mvvmdemo.viewmodel;

import android.databinding.BaseObservable;

import liophan.mvvmdemo.model.User;

/**
 * Copyright (c) 2017, Stacck Pte Ltd. All rights reserved.
 *
 * @author Lio <lphan@stacck.com>
 * @version 1.0
 * @since February 25, 2017
 */

public class ItemUserViewModel extends BaseObservable implements ViewModel {

    private User mUser;

    public ItemUserViewModel(User user) {
        mUser = user;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
        notifyChange();
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

    @Override
    public void destroy() {

    }
}
