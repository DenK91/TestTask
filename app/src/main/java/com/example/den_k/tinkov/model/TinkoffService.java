package com.example.den_k.tinkov.model;

import com.example.den_k.tinkov.model.data.PostResponse;
import com.example.den_k.tinkov.model.data.TitlesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TinkoffService {

    @GET("news")
    Call<TitlesResponse> getNews();

    @GET("news_content")
    Call<PostResponse> getNewsContent(@Query("id") String id);
}
