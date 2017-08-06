package com.example.den_k.tinkov.model.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class Post implements Serializable {

    @SerializedName("title")
    private PostTitle title;

    @SerializedName("creationDate")
    private SimpleDate creationDate;

    @SerializedName("lastModificationDate")
    private SimpleDate lastEditDate;

    @SerializedName("content")
    private String content;

    @SerializedName("typeId")
    private String typeId;
}
