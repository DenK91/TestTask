package com.example.den_k.tinkov.view.main_screen;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.den_k.tinkov.R;
import com.example.den_k.tinkov.model.data.PostTitle;
import com.example.den_k.tinkov.utils.Utils;

import lombok.Setter;

public class PostTitleItem extends RecyclerView.ViewHolder {

    private TextView mTitle;
    private TextView mTime;
    @Setter
    private PostTitleClickListener clickListener;
    private PostTitle mPostTitle;

    public interface PostTitleClickListener {
        void onPostTitleClicked(PostTitle postTitle);
    }

    public PostTitleItem(View itemView) {
        super(itemView);
        mTitle = (TextView) itemView.findViewById(R.id.title_view);
        mTime = (TextView) itemView.findViewById(R.id.time_view);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null && mPostTitle != null) {
                    clickListener.onPostTitleClicked(mPostTitle);
                }
            }
        });
    }

    public void setTitle(PostTitle postTitle) {
        mPostTitle = postTitle;
        updateUi();
    }

    private void updateUi() {
        mTitle.setText(Utils.fromHtml(mPostTitle.getText()));
        if (mPostTitle.getPubDate() != null) {
            mTime.setVisibility(View.VISIBLE);
            mTime.setText(Utils.getTimeString(mPostTitle.getPubDate().getMilliseconds()));
        } else {
            mTime.setVisibility(View.GONE);
        }
    }
}
