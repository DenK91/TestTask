package com.example.den_k.tinkov.view.details_screen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.example.den_k.tinkov.App;
import com.example.den_k.tinkov.R;
import com.example.den_k.tinkov.model.data.Post;
import com.example.den_k.tinkov.utils.Utils;
import com.example.den_k.tinkov.view.base.BasePresentableActivity;

import javax.inject.Inject;

public class NewsDetailActivity extends BasePresentableActivity<DetailsActivityPresenter>
        implements DetailsActivityView {

    private static final String KEY_ID = "com.example.den_k.tinkov.view.key_id";
    private static final String KEY_POST = "com.example.den_k.tinkov.view.key_post";

    private TextView mContent;
    private Post mPost;
    private View mRootView;

    public static void start(Context aContext, String aId) {
        Intent intent = new Intent(aContext, NewsDetailActivity.class);
        intent.putExtra(KEY_ID, aId);
        aContext.startActivity(intent);
    }

    @Inject
    DetailsActivityPresenter detailsActivityPresenter;

    @Override
    protected DetailsActivityPresenter getPresenter() {
        return detailsActivityPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.getComponent().injectsDetailsActivityPresenter(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        mContent = (TextView) findViewById(R.id.post_content);
        mRootView = findViewById(R.id.content);

        if (savedInstanceState != null) {
            mPost = (Post)savedInstanceState.getSerializable(KEY_POST);
        } else {
            String id = getIntent().getStringExtra(KEY_ID);
            if (!TextUtils.isEmpty(id)) {
                getPresenter().loadPost(id);
            }
        }
        updateUi();
    }

    private void updateUi() {
        if (mPost != null && !TextUtils.isEmpty(mPost.getContent())) {
            mContent.setText(Utils.fromHtml(mPost.getContent()));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(KEY_POST, mPost);
    }

    @Override
    public void showErrorMsg(String aMsg) {
        Utils.showSnack(mRootView, aMsg);
    }

    @Override
    public void setPost(Post aPost) {
        mPost = aPost;
        updateUi();
    }
}
