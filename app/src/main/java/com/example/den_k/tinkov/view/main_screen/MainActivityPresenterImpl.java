package com.example.den_k.tinkov.view.main_screen;

import com.example.den_k.tinkov.model.data.PostTitle;
import com.example.den_k.tinkov.usecases.GetNewsUseCase;
import com.example.den_k.tinkov.utils.db.DBUtils;
import com.example.den_k.tinkov.view.base.BasePresenter;

import java.util.List;

public class MainActivityPresenterImpl extends BasePresenter<MainActivityView>
        implements MainActivityPresenter<MainActivityView> {

    @Override
    public void getNews() {
        new GetNewsUseCase() {

            @Override
            public void onSuccess(List<PostTitle> titles) {
                getView().setTitles(titles);
                DBUtils.saveAllNews(titles);
            }

            @Override
            public void onError(String aErrMsg) {
                List<PostTitle> titles = DBUtils.getAllNews();
                if (titles != null && !titles.isEmpty()) {
                    getView().setTitles(titles);
                    getView().showErrorMsg("Загружено из базы данных");
                } else {
                    getView().showErrorMsg(aErrMsg);
                }
            }

        }.execute();
    }
}
