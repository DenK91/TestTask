package com.example.den_k.tinkov.view.details_screen;

import com.example.den_k.tinkov.model.data.Post;
import com.example.den_k.tinkov.usecases.GetNewsContentUseCase;
import com.example.den_k.tinkov.utils.db.DBUtils;
import com.example.den_k.tinkov.view.base.BasePresenter;

public class DetailsActivityPresenterImpl extends BasePresenter<DetailsActivityView>
        implements DetailsActivityPresenter<DetailsActivityView> {

    @Override
    public void loadPost(final String aId) {
        new GetNewsContentUseCase(aId) {

            @Override
            public void onSuccess(Post aPost) {
                getView().setPost(aPost);
                DBUtils.savePost(aPost);
            }

            @Override
            public void onError(String aErrMsg) {
                Post post = DBUtils.getPost(aId);
                if (post != null) {
                    getView().setPost(post);
                    getView().showErrorMsg("Загружено из базы данных");
                } else {
                    getView().showErrorMsg(aErrMsg);
                }
            }

        }.execute();
    }
}
