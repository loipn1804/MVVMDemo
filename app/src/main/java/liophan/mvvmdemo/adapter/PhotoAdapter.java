package liophan.mvvmdemo.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.googlecode.flickrjandroid.photos.Photo;

import java.util.Collections;
import java.util.List;

import liophan.mvvmdemo.R;
import liophan.mvvmdemo.databinding.ItemPhotoBinding;
import liophan.mvvmdemo.viewmodel.ItemPhotoViewModel;

/**
 * Copyright (c) 2017, Stacck Pte Ltd. All rights reserved.
 *
 * @author Lio <lphan@stacck.com>
 * @version 1.0
 * @since February 26, 2017
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.RepositoryViewHolder> {

    private List<Photo> mListData;

    public PhotoAdapter() {
        this.mListData = Collections.emptyList();
    }

    public PhotoAdapter(List<Photo> listData) {
        this.mListData = listData;
    }

    public void setListData(List<Photo> listData) {
        this.mListData = listData;
        notifyDataSetChanged();
    }

    @Override
    public RepositoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemPhotoBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_photo,
                parent,
                false);
        return new RepositoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RepositoryViewHolder holder, int position) {
        holder.bindRepository(mListData.get(position));
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    public static class RepositoryViewHolder extends RecyclerView.ViewHolder {
        final ItemPhotoBinding binding;

        public RepositoryViewHolder(ItemPhotoBinding binding) {
            super(binding.lnlRoot);
            this.binding = binding;
        }

        void bindRepository(Photo photo) {
            if (binding.getViewModel() == null) {
                binding.setViewModel(new ItemPhotoViewModel(photo));
            } else {
                binding.getViewModel().setPhoto(photo);
            }
        }
    }
}
