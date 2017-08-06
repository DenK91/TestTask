package com.example.den_k.tinkov.usecases;

import android.support.annotation.NonNull;

import com.example.den_k.tinkov.model.TinkoffApi;
import com.example.den_k.tinkov.model.data.PostTitle;
import com.example.den_k.tinkov.model.data.TitlesResponse;

import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class GetNewsUseCase extends BaseUseCase<List<PostTitle>> {

    @Override
    public void execute() {
        TinkoffApi.getTinkoffService().getNews().enqueue(new Callback<TitlesResponse>() {
            @Override
            public void onResponse(@NonNull Call<TitlesResponse> call, @NonNull Response<TitlesResponse> response) {
                int code = response.code();
                if (code == HttpURLConnection.HTTP_OK) {
                    TitlesResponse postResponse = response.body();
                    if (postResponse != null && postResponse.isOK()) {
                        onSuccess(postResponse.getTitles());
                    } else {
                        onError(DEFAULT_ERROR_MSG);
                    }
                } else {
                    onError(DEFAULT_ERROR_MSG);
                }
            }

            @Override
            public void onFailure(@NonNull Call<TitlesResponse> call, @NonNull Throwable t) {
                onError(DEFAULT_ERROR_MSG);
            }
        });
    }
}
