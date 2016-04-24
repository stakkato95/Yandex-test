package com.github.stakkato95.yandexmobilization.event;

import android.support.annotation.Nullable;

import retrofit2.Response;

/**
 * Created by artsiomkaliaha on 24/04/16.
 */
public class BaseEvent<T> {

    private Response<T> mResponse;
    Throwable mThrowable;

    private T mData;
    private boolean isSuccess;

    public BaseEvent(Response<T> response, Throwable t) {
        mResponse = response;
        mThrowable = t;

        if (response != null) {
            mData = response.body();
        }

        isSuccess = mData != null;
    }

    @Nullable
    public Response<T> getResponse() {
        return mResponse;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    @Nullable
    public T getData() {
        return mData;
    }

    public void setData(T mData) {
        mData = mData;
    }

    @Nullable
    public Throwable getThrowable() {
        return mThrowable;
    }
}
