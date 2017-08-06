package com.example.den_k.tinkov.view.details_screen;

import com.example.den_k.tinkov.model.data.Post;
import com.example.den_k.tinkov.view.base.Presentable;

public interface DetailsActivityView extends Presentable {

    void showErrorMsg(String aMsg);
    void setPost(Post aPost);

}
