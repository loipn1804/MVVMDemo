package liophan.mvvmdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import liophan.mvvmdemo.adapter.ListUserAdapter;
import liophan.mvvmdemo.databinding.ActivityListUserBinding;
import liophan.mvvmdemo.model.User;
import liophan.mvvmdemo.viewmodel.ListActivityViewModel;

/**
 * Copyright (c) 2017, Stacck Pte Ltd. All rights reserved.
 *
 * @author Lio <lphan@stacck.com>
 * @version 1.0
 * @since February 25, 2017
 */

public class ListUserActivity extends AppCompatActivity implements ListActivityViewModel.ListActivityViewModelListener {

    private ActivityListUserBinding mBinding;
    private ListActivityViewModel mListActivityViewModel;

    private ListUserAdapter mListUserAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    private void initView() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_list_user);
        mListActivityViewModel = new ListActivityViewModel(this);
        mBinding.setViewModel(mListActivityViewModel);

        setupRecyclerView(mBinding.recyclerView);
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        mListUserAdapter = new ListUserAdapter();
        recyclerView.setAdapter(mListUserAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void updateListUser(List<User> users) {
        mListUserAdapter.setListData(users);
    }

    @Override
    protected void onDestroy() {
        mListActivityViewModel.destroy();
        super.onDestroy();
    }
}
