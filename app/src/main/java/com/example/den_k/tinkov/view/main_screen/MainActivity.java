package com.example.den_k.tinkov.view.main_screen;

import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.den_k.tinkov.App;
import com.example.den_k.tinkov.R;
import com.example.den_k.tinkov.model.data.PostTitle;
import com.example.den_k.tinkov.utils.Utils;
import com.example.den_k.tinkov.view.base.BasePresentableActivity;
import com.example.den_k.tinkov.view.details_screen.NewsDetailActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BasePresentableActivity<MainActivityPresenter>
        implements MainActivityView, SwipeRefreshLayout.OnRefreshListener,
        PostTitleItem.PostTitleClickListener {

    private static final String STATE_DATA = "com.example.den_k.tinkov.view.key_dataset_titles";
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mList;
    private NewsAdapter mAdapter;
    private View mEmptyListView;

    @Inject
    MainActivityPresenter mainActivityPresenter;

    @Override
    protected MainActivityPresenter getPresenter() {
        return mainActivityPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.getComponent().injectsMainActivityPresenter(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwipeRefreshLayout = ((SwipeRefreshLayout) findViewById(R.id.swipe_to_refresh));
        mEmptyListView = findViewById(R.id.empty_list_view);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mList = (RecyclerView) findViewById(R.id.new_list);
        mAdapter = new NewsAdapter(this);
        mAdapter.setPostTitleClickListener(this);
        mList.setAdapter(mAdapter);
        mList.setLayoutManager(new LinearLayoutManager(this));

        if (savedInstanceState != null) {
            setTitles((ArrayList<PostTitle>)savedInstanceState.getSerializable(STATE_DATA));
        } else {
            getPresenter().getNews();
        }
        updateEmptyListViewState();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(STATE_DATA, (ArrayList<PostTitle>) mAdapter.getPostTitles());
    }

    @Override
    public void onRefresh() {
        getPresenter().getNews();
    }

    @Override
    public void showErrorMsg(String aMsg) {
        Utils.showSnack(mList, aMsg);
        mSwipeRefreshLayout.setRefreshing(false);
        updateEmptyListViewState();
    }

    @Override
    public void onPostTitleClicked(PostTitle postTitle) {
        NewsDetailActivity.start(this, postTitle.getId());
    }

    @Override
    public void setTitles(List<PostTitle> aPostTitles) {
        Collections.sort(aPostTitles, new Comparator<PostTitle>() {
            public int compare(PostTitle o1, PostTitle o2) {
                return ((Long)o2.getPubDate().getMilliseconds()).compareTo(o1.getPubDate().getMilliseconds());
            }
        });
        mAdapter.setPostTitles(aPostTitles);
        mSwipeRefreshLayout.setRefreshing(false);
        updateEmptyListViewState();
    }

    private void updateEmptyListViewState() {
        if (mAdapter.getPostTitles().isEmpty()) {
            mEmptyListView.setVisibility(View.VISIBLE);
        } else {
            mEmptyListView.setVisibility(View.GONE);
        }
    }
}
