package com.kwawannan.newyorkschools.network;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * {@code Scheduler} manages threading of {@link Runnable} tasks. A {@link Runnable} given to this
 * {@code Scheduler} will execute on a background thread defined by the {@link ThreadPoolExecutor}
 * used to construct this object.
 */

public class Scheduler {
    private final ThreadPoolExecutor threadPoolExecutor;
    private final Handler postHandler;

    public Scheduler(@NonNull ThreadPoolExecutor threadPoolExecutor) {
        this.threadPoolExecutor = threadPoolExecutor;
        postHandler = new Handler(Looper.myLooper());
    }

    void execute(Runnable runnable) {
        threadPoolExecutor.execute(runnable);
    }

    <T> void notifyResponse(final String response, final Map<String, String> header,
                            final HttpCallback httpCallback) {
        postHandler.post(new Runnable() {
            @Override
            public void run() {
                httpCallback.onResponse(response, header);
            }
        });
    }

    <T> void notifyError(final String error, final HttpCallback httpCallback) {
        postHandler.post(new Runnable() {
            @Override
            public void run() {
                httpCallback.onErrorResponse(error);
            }
        });
    }

    <T> void notifyFailure(final SchoolError error, final HttpCallback httpCallback) {
        postHandler.post(new Runnable() {
            @Override
            public void run() {
                httpCallback.onFail(error);
            }
        });
    }
}
