package com.example.den_k.tinkov.di;

import com.example.den_k.tinkov.view.details_screen.NewsDetailActivity;
import com.example.den_k.tinkov.view.main_screen.MainActivity;

import dagger.Component;

@Component(modules = {MainActivityModule.class, DetailsActivityModule.class})
public interface AppComponent {

    void injectsMainActivityPresenter(MainActivity mainActivityView);
    void injectsDetailsActivityPresenter(NewsDetailActivity detailActivity);

}
