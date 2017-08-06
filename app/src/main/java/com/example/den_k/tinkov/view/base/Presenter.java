package com.example.den_k.tinkov.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

public interface Presenter<V extends Presentable> {
    void putView(V view);
    V getView();
    void onCreate(@Nullable Bundle savedInstanceState);
    void onDestroy();
    void onStart();
    void onStop();
    void onResume();
    void onPause();
}
