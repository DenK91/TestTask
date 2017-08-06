package com.example.den_k.tinkov.usecases;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.den_k.tinkov.model.TinkoffApi;
import com.example.den_k.tinkov.model.data.Post;
import com.example.den_k.tinkov.model.data.PostResponse;
import com.example.den_k.tinkov.model.data.PostTitle;
import com.example.den_k.tinkov.model.data.TitlesResponse;

import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class GetNewsContentUseCase extends BaseUseCase<Post> {

    private String mId;

    public GetNewsContentUseCase(String aId) {
        mId = aId;
    }

    @Override
    public void execute() {
        if (TextUtils.isEmpty(mId)) {
            onError(DEFAULT_ERROR_MSG);
        }
        TinkoffApi.getTinkoffService().getNewsContent(mId).enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(@NonNull Call<PostResponse> call, @NonNull Response<PostResponse> response) {
                int code = response.code();
                if (code == HttpURLConnection.HTTP_OK) {
                    PostResponse postResponse = response.body();
                    if (postResponse != null && postResponse.isOK()) {
                        onSuccess(postResponse.getPost());
                    } else {
                        onError(DEFAULT_ERROR_MSG);
                    }
                } else {
                    onError(DEFAULT_ERROR_MSG);
                }
            }

            @Override
            public void onFailure(@NonNull Call<PostResponse> call, @NonNull Throwable t) {
                onError(DEFAULT_ERROR_MSG);
            }
        });
    }
}
