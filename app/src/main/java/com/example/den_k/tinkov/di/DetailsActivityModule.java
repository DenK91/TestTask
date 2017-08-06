package com.example.den_k.tinkov.di;

import com.example.den_k.tinkov.view.details_screen.DetailsActivityPresenter;
import com.example.den_k.tinkov.view.details_screen.DetailsActivityPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
class DetailsActivityModule {

    @Provides
    DetailsActivityPresenter providePresenter() {
        return new DetailsActivityPresenterImpl();
    }

}
