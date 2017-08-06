package com.example.den_k.tinkov.di;

import com.example.den_k.tinkov.view.main_screen.MainActivityPresenter;
import com.example.den_k.tinkov.view.main_screen.MainActivityPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
class MainActivityModule {

    @Provides
    MainActivityPresenter providePresenter() {
        return new MainActivityPresenterImpl();
    }

}
