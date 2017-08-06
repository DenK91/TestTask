package com.example.den_k.tinkov.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

public abstract class BasePresenter<V extends Presentable> implements Presenter<V> {

    private V mView;

    @Override
    public void putView(V view) {
        mView = view;
    }

    @Override
    public V getView() {
        return mView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {}

    @Override
    public void onDestroy() {}

    @Override
    public void onPause() {}

    @Override
    public void onResume() {}

    @Override
    public void onStart() {}

    @Override
    public void onStop() {}

}
