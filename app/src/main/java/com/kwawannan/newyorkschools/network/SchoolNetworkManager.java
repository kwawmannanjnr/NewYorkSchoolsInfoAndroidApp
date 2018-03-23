package com.kwawannan.newyorkschools.network;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import com.kwawannan.newyorkschools.core.JsonSerializer;
import com.kwawannan.newyorkschools.domain.NYCSchool;
import com.kwawannan.newyorkschools.domain.SATScore;

/**
 * Class to perform network requests with a given {@link HttpRequest} and return a response of an
 * expected type
 */
public class SchoolNetworkManager implements NetworkManager {
    private static final String TAG = SchoolNetworkManager.class.getSimpleName();
    public JsonSerializer jsonSerializer;
    public HttpClient httpClient;
    public HttpHandler httpHandler;


    @Inject
    public SchoolNetworkManager() {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(NetworkConstants.POOL_SIZE, NetworkConstants.MAX_POOL_SIZE,
                        NetworkConstants.TIMEOUT, TimeUnit.SECONDS,
                        new ArrayBlockingQueue<Runnable>(NetworkConstants.POOL_SIZE));
        Scheduler scheduler = new Scheduler(threadPoolExecutor);
        HttpHandler httpHandler = new HttpHandler(scheduler);
        HttpConfiguration httpConfiguration = new HttpConfiguration(NetworkConstants.TIMEOUT_MILLIS);
        HttpClient httpClient = HttpClient.createClient(httpConfiguration);
        JsonSerializer jsonSerializer = new JsonSerializer();

        this.jsonSerializer = jsonSerializer;
        this.httpClient = httpClient;
        this.httpHandler = httpHandler;
    }

    public <T, E> void executeRequest(final Class<NYCSchool> responseType, final Class<ErrorResponse> errorResponseType,
                                      final HttpRequest request, final NewServiceCallBack<NYCSchool[], ErrorResponse> callback) {
        httpHandler.execute(httpClient, request, new HttpCallback() {
            @Override
            public void onResponse(String response, Map<String, String> header) {

                try {
                    Gson gson = new Gson();

                    callback.onResponse(gson.fromJson(response, NYCSchool[].class));
                } catch (Exception ex) {
                    Log.e(TAG, "onErrorResponse: " + ex.getLocalizedMessage(), ex);
                    callback.onFail(new SchoolError(SchoolError.ERROR_CODE_REQUEST_FAILED,
                            "Unexpected Response From Server"));
                }

            }

            @Override
            public void onErrorResponse(String error) {
                Log.e(TAG, "Communication error from server : " + error);
                try {
                    callback.onErrorResponse(jsonSerializer.deserialize(errorResponseType, error));
                } catch (JSONException e) {
                    Log.e(TAG, "onErrorResponse: " + e.getLocalizedMessage());
                    callback.onFail(
                            new SchoolError(SchoolError.ERROR_CODE_REQUEST_FAILED, "Unexpected Response From Server"));
                }
            }

            @Override
            public void onFail(SchoolError error) {
                callback.onFail(error);
            }
        });
    }

    @Override
    public <T, E> void executeRequest2(final Class<SATScore> responseType, Class<ErrorResponse> errorResponseType, final HttpRequest request, final NewServiceCallBack<SATScore[], ErrorResponse> callback) {
        httpHandler.execute(httpClient, request, new HttpCallback() {
            @Override
            public void onResponse(String response, Map<String, String> header) {

                try {
                    Gson gson = new Gson();

                    callback.onResponse(gson.fromJson(response, SATScore[].class));
                } catch (Exception ex) {
                    Log.e(TAG, "onErrorResponse: " + ex.getLocalizedMessage(), ex);
                    callback.onFail(new SchoolError(SchoolError.ERROR_CODE_REQUEST_FAILED,
                            "Unexpected Response From Server"));
                }

            }

            @Override
            public void onErrorResponse(String error) {
                Log.e(TAG, "Communication error from server : " + error);

            }

            @Override
            public void onFail(SchoolError error) {
                callback.onFail(error);
            }
        });
    }


}
