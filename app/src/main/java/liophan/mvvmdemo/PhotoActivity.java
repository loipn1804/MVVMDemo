package liophan.mvvmdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.googlecode.flickrjandroid.photos.Photo;

import java.util.List;

import liophan.mvvmdemo.adapter.PhotoAdapter;
import liophan.mvvmdemo.databinding.ActivityPhotoBinding;
import liophan.mvvmdemo.viewmodel.PhotoActivityViewModel;

/**
 * Copyright (c) 2017, Stacck Pte Ltd. All rights reserved.
 *
 * @author Lio <lphan@stacck.com>
 * @version 1.0
 * @since February 26, 2017
 */

public class PhotoActivity extends AppCompatActivity implements PhotoActivityViewModel.PhotoActivityViewModelListener {

    private ActivityPhotoBinding mBinding;
    private PhotoActivityViewModel mViewModel;

    private PhotoAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_photo);
        mViewModel = new PhotoActivityViewModel(this);
        mBinding.setViewModel(mViewModel);

        setupRecyclerView(mBinding.recyclerView);
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        mAdapter = new PhotoAdapter();
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void updateListData(List<Photo> photos) {
        mAdapter.setListData(photos);
    }
}
