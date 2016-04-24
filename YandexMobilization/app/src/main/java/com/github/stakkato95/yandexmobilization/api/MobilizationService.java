package com.github.stakkato95.yandexmobilization.api;

import com.github.stakkato95.yandexmobilization.data.model.Artist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by artsiomkaliaha on 24/04/16.
 */
public interface MobilizationService {

    @GET("mobilization-2016/artists.json")
    Call<List<Artist>> getArtists();
}
