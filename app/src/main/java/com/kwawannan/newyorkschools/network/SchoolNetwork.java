package com.kwawannan.newyorkschools.network;

import com.kwawannan.newyorkschools.domain.NYCSchool;
import com.kwawannan.newyorkschools.domain.SATScore;

import java.util.Map;


/**
 * Responsible for Making Network Request
 */
public interface SchoolNetwork {
    /**
     * @param <R>
     * @param <E>
     * @param nextPageReference  Only if next page reference is true do we bypass all the other query parameters
     * @param queryParams
     * @param request
     * @param url
     * @param responseClazz
     * @param errorResponseClazz
     * @param callback
     */
    <R, E> void executeRequest(boolean nextPageReference, Map<String, String> queryParams, String request, String url, Class<NYCSchool> responseClazz,
                               Class<ErrorResponse> errorResponseClazz, final NewServiceCallBack<NYCSchool[], ErrorResponse> callback);

    <R, E> void executeRequestSat(boolean nextPageReference, Map<String, String> queryParams, String request, String url, Class<SATScore> responseClazz,
                                  Class<ErrorResponse> errorResponseClazz, final NewServiceCallBack<SATScore[], ErrorResponse> callback);
}
