package com.kwawannan.newyorkschools.network;

import android.util.Log;

import com.kwawannan.newyorkschools.domain.NYCSchool;
import com.kwawannan.newyorkschools.domain.SATScore;

import java.util.Map;

import javax.inject.Inject;

/**
 * Implementation to communicate with the remote Nyc School server
 */
public class SchoolServicesImpl implements SchoolServices {

    private static final String TAG = SchoolServicesImpl.class.getSimpleName();

//    private static final String BASEURL_ENDPOINT = "https://data.cityofnewyork.us/resource/97mf-9njv.json";

    // private Serializer serializer;

    public SchoolNetwork schoolNetworkService;

    @Inject
    public SchoolServicesImpl(SchoolNetwork schoolNetworkService) {
        this.schoolNetworkService = schoolNetworkService;
    }


    @Override
    public void nycSchoolLookup(boolean nextPageReference, Map<String, String> queryParameters, String BASEURL_ENDPOINT,
                                NewServiceCallBack<NYCSchool[], ErrorResponse> callback) {
        executeRequest(nextPageReference, queryParameters, BASEURL_ENDPOINT, NYCSchool.class,
                ErrorResponse.class, callback);
    }

    @Override
    public void satScoreLookup(NewServiceCallBack<SATScore[], ErrorResponse> callback, String endpoint) {

        executeRequestSAT(false, null, endpoint, SATScore.class, ErrorResponse.class, callback);

    }

    /**
     * This method will pass an Object representation of the payload , any query parameters , the endpoint , and a Callback to asynchronously pass the results back
     *
     * @param <R>                {@link NYCSchool}
     * @param <E>                {@link ErrorResponse}
     * @param queryParameters    latitude and longitude
     * @param endpoint           /iss-pass.json?
     * @param responseClazz      {@link NYCSchool}
     * @param errorResponseClazz {@link ErrorResponse}
     * @param callback           {@link NewServiceCallBack}
     */
    private <R, E> void executeRequest(boolean nextPageReference, Map<String, String> queryParameters, String endpoint, Class<NYCSchool> responseClazz,
                                       Class<ErrorResponse> errorResponseClazz, final NewServiceCallBack<NYCSchool[], ErrorResponse> callback) {

        Log.d("executeRequest", endpoint);
        String requestJson = null;

        schoolNetworkService.executeRequest(nextPageReference, queryParameters, requestJson, endpoint, responseClazz, errorResponseClazz, callback);
    }

    /**
     * This method will pass an Object representation of the payload , any query parameters , the endpoint , and a Callback to asynchronously pass the results back
     *
     * @param <R>                {@link NYCSchool}
     * @param <E>                {@link ErrorResponse}
     * @param queryParameters    latitude and longitude
     * @param endpoint           /iss-pass.json?
     * @param responseClazz      {@link NYCSchool}
     * @param errorResponseClazz {@link ErrorResponse}
     * @param callback           {@link NewServiceCallBack}
     */
    private <R, E> void executeRequestSAT(boolean nextPageReference, Map<String, String> queryParameters, String endpoint, Class<SATScore> responseClazz,
                                          Class<ErrorResponse> errorResponseClazz, final NewServiceCallBack<SATScore[], ErrorResponse> callback) {

        Log.d("executeRequest", endpoint);
        String requestJson = null;

        schoolNetworkService.executeRequestSat(nextPageReference, queryParameters, requestJson, endpoint, responseClazz, errorResponseClazz, callback);
    }
}
