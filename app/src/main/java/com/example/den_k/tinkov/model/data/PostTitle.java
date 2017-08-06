package com.example.den_k.tinkov.model.data;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class PostTitle implements Serializable {

    @SerializedName("id")
    private String id;

    @SerializedName("text")
    private String text;

    @SerializedName("name")
    private String name;

    @SerializedName("publicationDate")
    private SimpleDate pubDate;

    @SerializedName("bankInfoTypeId")
    private int infoTypeId;
}

