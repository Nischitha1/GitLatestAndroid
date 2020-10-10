package com.nischitha.albumlist.pojo;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("artistName")
    public String artistName;
    @SerializedName("trackId")
    public Integer trackId;
    @SerializedName("trackName")
    public String trackName;
    @SerializedName("trackPrice")
    public Double trackPrice;
    @SerializedName("releaseDate")
    public String releaseDate;
    @SerializedName("primaryGenreName")
    public String primaryGenreName;
}
