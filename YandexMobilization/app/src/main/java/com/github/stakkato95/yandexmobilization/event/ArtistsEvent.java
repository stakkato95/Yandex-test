package com.github.stakkato95.yandexmobilization.event;

import com.github.stakkato95.yandexmobilization.data.model.Artist;

import java.util.List;

import retrofit2.Response;

/**
 * Created by artsiomkaliaha on 24/04/16.
 */
public class ArtistsEvent extends BaseEvent<List<Artist>> {

    public ArtistsEvent(Response<List<Artist>> response, Throwable t) {
        super(response, t);
    }
}
