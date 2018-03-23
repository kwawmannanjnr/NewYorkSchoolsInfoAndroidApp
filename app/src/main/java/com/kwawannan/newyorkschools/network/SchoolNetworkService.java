package com.kwawannan.newyorkschools.network;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.kwawannan.newyorkschools.domain.NYCSchool;
import com.kwawannan.newyorkschools.domain.SATScore;

/**
 * Encapsulate the SchoolNetworkManager
 */
public class SchoolNetworkService implements SchoolNetwork {

    public NetworkManager networkManager;

    @Inject
    public SchoolNetworkService(SchoolNetworkManager networkManager) {
        this.networkManager = networkManager;
    }

    public <R, E> void executeRequest(boolean nextPageReference, Map<String, String> queryParams, String request, String url, Class<NYCSchool> responseClazz,
                                      Class<ErrorResponse> errorResponseClazz, final NewServiceCallBack<NYCSchool[], ErrorResponse> callback) {
        try {
            Map<String, String> headers = new HashMap<>();
            //    HttpBody body = new HttpBody(request, "application/json");
            headers.put("Content-Type", "application/json");
            HttpRequest httpRequest = new HttpRequest.Builder().setMethod(HttpRequest.GET)
                    .setUrl(url)
                    .setPageReference(nextPageReference)
                    .setHeaders(headers)
                    .setQueryParameters(queryParams)
                    // .setBody(body)
                    .build();
            Log.d("SchoolServices", "Executing Request: " + request);
            networkManager.executeRequest(responseClazz, errorResponseClazz, httpRequest, callback);
        } catch (Exception e) {
            Log.e("NetWorkMaanger", e.getLocalizedMessage(), e);
            callback.onFail(new SchoolError(SchoolError.ERROR_CODE_REQUEST_FAILED,
                    "Request was unable to be made"));
        }
    }

    @Override
    public <R, E> void executeRequestSat(boolean nextPageReference, Map<String, String> queryParams, String request, String url, Class<SATScore> responseClazz, Class<ErrorResponse> errorResponseClazz, NewServiceCallBack<SATScore[], ErrorResponse> callback) {
        try {
            Map<String, String> headers = new HashMap<>();
            //    HttpBody body = new HttpBody(request, "application/json");
            headers.put("Content-Type", "application/json");
            HttpRequest httpRequest = new HttpRequest.Builder().setMethod(HttpRequest.GET)
                    .setUrl(url)

                    // .setBody(body)
                    .build();
            Log.d("SchoolServices", "Executing Request: " + request);
            networkManager.executeRequest2(responseClazz, errorResponseClazz, httpRequest, callback);
        } catch (Exception e) {
            Log.e("NetWorkMaanger", e.getLocalizedMessage(), e);
            callback.onFail(new SchoolError(SchoolError.ERROR_CODE_REQUEST_FAILED,
                    "Request was unable to be made"));
        }
    }
}
