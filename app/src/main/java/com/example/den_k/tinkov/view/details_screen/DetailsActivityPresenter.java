package com.example.den_k.tinkov.view.details_screen;

import com.example.den_k.tinkov.view.base.Presentable;
import com.example.den_k.tinkov.view.base.Presenter;

public interface DetailsActivityPresenter<V extends Presentable> extends Presenter<V> {

    void loadPost(String aId);
}