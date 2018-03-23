package com.kwawannan.newyorkschools.network;

import com.kwawannan.newyorkschools.domain.NYCSchool;
import com.kwawannan.newyorkschools.domain.SATScore;

import java.util.Map;

/**
 * Class to perform network requests with a given {@link HttpRequest} and return a response of an
 * expected type
 */
public interface SchoolServices {

    void nycSchoolLookup(boolean usePageReference, Map<String, String> queryParameters, String baseUrlEndpoint,
                         NewServiceCallBack<NYCSchool[], ErrorResponse> callback);


    void satScoreLookup(
            NewServiceCallBack<SATScore[], ErrorResponse> callback, String endpoint);
}
