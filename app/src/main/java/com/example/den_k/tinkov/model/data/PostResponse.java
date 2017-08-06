package com.example.den_k.tinkov.model.data;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class PostResponse extends Response {

    @SerializedName("payload")
    private Post post;

}
