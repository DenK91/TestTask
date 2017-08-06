package com.example.den_k.tinkov.view.main_screen;

import com.example.den_k.tinkov.model.data.PostTitle;
import com.example.den_k.tinkov.view.base.Presentable;

import java.util.List;

public interface MainActivityView extends Presentable {

    void showErrorMsg(String aMsg);
    void setTitles(List<PostTitle> aPostTitles);

}
