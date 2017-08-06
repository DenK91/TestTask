package com.example.den_k.tinkov.model.data;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class Response {

    private static final String OK = "OK";

    @SerializedName("resultCode")
    private String resultCode;

    @SerializedName("trackingId")
    private String trackingId;

    public boolean isOK() {
        return getResultCode().equals(OK);
    }

}
