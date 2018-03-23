package com.kwawannan.newyorkschools.network;

import com.kwawannan.newyorkschools.domain.NYCSchool;
import com.kwawannan.newyorkschools.domain.SATScore;

/**
 * Created by Kwaw Annan on 3/23/2018.
 */

public interface NetworkManager {

    public <T, E> void executeRequest(final Class<NYCSchool> responseType, final Class<ErrorResponse> errorResponseType,
                                      final HttpRequest request, final NewServiceCallBack<NYCSchool[], ErrorResponse> callback);

    public <T, E> void executeRequest2(final Class<SATScore> responseType, final Class<ErrorResponse> errorResponseType,
                                       final HttpRequest request, final NewServiceCallBack<SATScore[], ErrorResponse> callback);

}
