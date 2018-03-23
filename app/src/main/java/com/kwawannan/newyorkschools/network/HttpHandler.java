package com.kwawannan.newyorkschools.network;

import android.support.annotation.NonNull;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Handler to execute {@link HttpRequest} for a given {@link HttpClient} and return responses on
 * the given {@link ServiceCallback}
 */

public class HttpHandler {
    public static final String IMAGE_PNG = "image/png";
    private final Scheduler scheduler;

    public HttpHandler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    /**
     * Executes a given {@link HttpRequest} with the given {@link HttpClient} and returns the
     * response
     * to the given {@link ServiceCallback}.
     *
     * @param client   {@code HttpClient} to execute the request with
     * @param request  {@code HttpRequest} encapsulating the request parameters
     * @param callback listener to receive response from the network call
     */
    void execute(@NonNull final HttpClient client, @NonNull final HttpRequest request,
                 @NonNull final HttpCallback callback) {
        scheduler.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    HttpResponse httpResponse = client.execute(request);
                    InputStream responseStream = httpResponse.getContent();
                    //Check inputstream for errorStream
                    ByteArrayOutputStream result = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int length;

                    String stringResult;
                    while ((length = responseStream.read(buffer)) != -1) {
                        result.write(buffer, 0, length);
                    }

                    if (IMAGE_PNG.equalsIgnoreCase(httpResponse.getContentType())) {
                        stringResult = Base64.encodeToString(result.toByteArray(), Base64.NO_WRAP);
                    } else {
                        stringResult = result.toString("UTF-8");
                    }

                    Log.d("HttpHandler", "Received Response: " + stringResult);
                    if (httpResponse.getStatusCode() < 400) {
                        scheduler.notifyResponse(stringResult, httpResponse.getAllHeaders(), callback);
                    } else if (httpResponse.getStatusCode() == 408) {
                        scheduler.notifyFailure(
                                new SchoolError(SchoolError.ERROR_CODE_REQUEST_TIMEOUT, stringResult),
                                callback);
                    } else {
                        scheduler.notifyError(stringResult, callback);
                    }
                } catch (IOException e) {
                    Log.e("HttpHandler", e.getLocalizedMessage(), e);
                    scheduler.notifyFailure(new SchoolError(SchoolError.ERROR_CODE_REQUEST_FAILED,
                            "The request failed to complete"), callback);
                }
            }
        });
    }
}