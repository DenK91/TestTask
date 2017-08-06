package com.example.den_k.tinkov.model.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class SimpleDate implements Serializable {

    @SerializedName("milliseconds")
    private long milliseconds;
}