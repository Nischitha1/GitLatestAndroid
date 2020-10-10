package com.nischitha.albumlist.retrofit;


import com.nischitha.albumlist.pojo.Albumn;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface APIInterface {

    @GET("search")
    Call<Albumn> getAlbums(@Query("term") String artistName);
}
