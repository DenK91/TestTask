package com.example.den_k.tinkov.model;

import com.example.den_k.tinkov.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TinkoffApi {

    private Retrofit retrofit;
    private TinkoffService tinkoffService;

    private static TinkoffApi INSTANCE;

    private static TinkoffApi getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TinkoffApi();
        }
        return INSTANCE;
    }

    private TinkoffApi() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static TinkoffService getTinkoffService() {
        if (getInstance().tinkoffService == null) {
            getInstance().tinkoffService = getInstance().retrofit.create(TinkoffService.class);
        }
        return getInstance().tinkoffService;
    }

}
