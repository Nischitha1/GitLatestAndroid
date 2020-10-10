package com.nischitha.albumlist.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Albumn {
    @SerializedName("resultCount")
    public Integer resultCount;
    @SerializedName("results")
    public List<Result> results;
}
