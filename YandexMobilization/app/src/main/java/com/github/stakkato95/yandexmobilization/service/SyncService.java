package com.github.stakkato95.yandexmobilization.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.github.stakkato95.yandexmobilization.api.MobilizationApi;
import com.github.stakkato95.yandexmobilization.event.ArtistsEvent;
import com.github.stakkato95.yandexmobilization.event.SyncFailedEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by artsiomkaliaha on 24/04/16.
 */
public class SyncService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        if (Utils.isInternetEnabled()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    MobilizationApi.getInstance().getArtists();
                }
            }).start();
//        } else {
//
//            EventBus.getDefault().post(SyncFailedEvent.INSTANCE);
//        }

        return START_REDELIVER_INTENT;
    }

    public void onEvent(ArtistsEvent event) {
        EventBus.getDefault().post(SyncFailedEvent.INSTANCE);
    }
}
