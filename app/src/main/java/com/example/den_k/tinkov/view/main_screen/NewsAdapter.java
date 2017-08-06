package com.example.den_k.tinkov.view.main_screen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.den_k.tinkov.R;
import com.example.den_k.tinkov.model.data.PostTitle;

import java.util.ArrayList;
import java.util.List;

import lombok.Setter;


public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<PostTitle> mDataSet = new ArrayList<>(0);
    private LayoutInflater inflater;
    @Setter
    private PostTitleItem.PostTitleClickListener postTitleClickListener;

    public NewsAdapter(Context aContext) {
        inflater = LayoutInflater.from(aContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PostTitleItem postTitleItem = new PostTitleItem(
                inflater.inflate(R.layout.post_title_item, parent, false));
        postTitleItem.setClickListener(postTitleClickListener);
        return postTitleItem;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((PostTitleItem) holder).setTitle(mDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public void setPostTitles(List<PostTitle> postTitles) {
        synchronized (mDataSet) {
            mDataSet.clear();
            mDataSet.addAll(postTitles);
            notifyDataSetChanged();
        }
    }

    public List<PostTitle> getPostTitles() {
        return mDataSet;
    }
}
