package com.github.stakkato95.yandexmobilization.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;

import com.github.stakkato95.yandexmobilization.App;

/**
 * Created by artsiomkaliaha on 24/04/16.
 */
public final class Utils {

    private static final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();

    public static int getNumberOfCores() {
        return NUMBER_OF_CORES;
    }

    public static boolean isInternetEnabled() {
        ConnectivityManager cm = (ConnectivityManager) App.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
