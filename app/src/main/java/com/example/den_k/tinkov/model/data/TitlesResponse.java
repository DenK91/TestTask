package com.example.den_k.tinkov.model.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;

@Getter
public class TitlesResponse extends Response {

    @SerializedName("payload")
    private List<PostTitle> titles;
}
