package com.example.den_k.tinkov.view.main_screen;

import com.example.den_k.tinkov.view.base.Presentable;
import com.example.den_k.tinkov.view.base.Presenter;

public interface MainActivityPresenter<V extends Presentable> extends Presenter<V> {

    void getNews();
}