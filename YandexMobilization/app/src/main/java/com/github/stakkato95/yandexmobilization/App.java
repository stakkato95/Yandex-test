package com.github.stakkato95.yandexmobilization;

import android.app.Application;
import android.content.Intent;

import com.github.stakkato95.yandexmobilization.service.SyncService;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by artsiomkaliaha on 24/04/16.
 */
public class App extends Application {

    private static App sInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;

        FlowManager.init(this);

        startSync();
    }

    private void startSync() {
        startService(new Intent(this, SyncService.class));
    }

    public static App getInstance() {
        return sInstance;
    }
}
