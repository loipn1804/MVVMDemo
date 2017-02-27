package liophan.mvvmdemo.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import liophan.mvvmdemo.R;
import liophan.mvvmdemo.databinding.ItemUserBinding;
import liophan.mvvmdemo.model.User;
import liophan.mvvmdemo.viewmodel.ItemUserViewModel;

/**
 * Copyright (c) 2017, Stacck Pte Ltd. All rights reserved.
 *
 * @author Lio <lphan@stacck.com>
 * @version 1.0
 * @since February 25, 2017
 */

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.RepositoryViewHolder> {

    private List<User> mListData;

    public ListUserAdapter() {
        this.mListData = Collections.emptyList();
    }

    public ListUserAdapter(List<User> listData) {
        this.mListData = listData;
    }

    public void setListData(List<User> listData) {
        this.mListData = listData;
        notifyDataSetChanged();
    }

    @Override
    public RepositoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemUserBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_user,
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
        final ItemUserBinding binding;

        public RepositoryViewHolder(ItemUserBinding binding) {
            super(binding.lnlRoot);
            this.binding = binding;
        }

        void bindRepository(User user) {
            if (binding.getViewModel() == null) {
                binding.setViewModel(new ItemUserViewModel(user));
            } else {
                binding.getViewModel().setUser(user);
            }
        }
    }
}
