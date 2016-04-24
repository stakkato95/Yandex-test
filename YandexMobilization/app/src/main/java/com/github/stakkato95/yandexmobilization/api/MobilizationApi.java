package com.github.stakkato95.yandexmobilization.api;

import com.github.stakkato95.yandexmobilization.BuildConfig;
import com.github.stakkato95.yandexmobilization.data.database.DatabaseQueryHandler;
import com.github.stakkato95.yandexmobilization.data.model.Artist;
import com.github.stakkato95.yandexmobilization.event.ArtistsEvent;
import com.github.stakkato95.yandexmobilization.event.SyncFailedEvent;
import com.github.stakkato95.yandexmobilization.util.Utils;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by artsiomkaliaha on 24/04/16.
 */
public class MobilizationApi {

    private static volatile MobilizationApi sInstance;

    private final MobilizationService mService;

    public static MobilizationApi getInstance() {
        if (sInstance == null) {
            synchronized (MobilizationApi.class) {
                if (sInstance == null) {
                    sInstance = new MobilizationApi();
                }
            }
        }
        return sInstance;
    }

    MobilizationApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .callbackExecutor(Executors.newFixedThreadPool(Utils.getNumberOfCores()))
                .build();

        mService = retrofit.create(MobilizationService.class);
    }

    public void getArtists() {
        Call<List<Artist>> call = mService.getArtists();
        call.enqueue(new Callback<List<Artist>>() {
            @Override
            public void onResponse(Call<List<Artist>> call, Response<List<Artist>> response) {
                ArtistsEvent event = new ArtistsEvent(response, null);
                if (event.isSuccess()) {
                    DatabaseQueryHandler.saveArtists(event.getData());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<List<Artist>> call, Throwable t) {
                EventBus.getDefault().post(new ArtistsEvent(null, t));
            }
        });
    }
}
