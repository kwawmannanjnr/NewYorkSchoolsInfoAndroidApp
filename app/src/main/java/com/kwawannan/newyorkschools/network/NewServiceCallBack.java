package com.kwawannan.newyorkschools.network;

import com.kwawannan.newyorkschools.domain.NYCSchool;
import com.kwawannan.newyorkschools.domain.SATScore;



/**
 * Callback interface to be notified when an error response or failure occurs, in addition to normal
 * successful response
 */

public interface NewServiceCallBack<R, E> {
    /**
     * Notifies the listener that a successful response has been returned by the server
     *
     * @param response the server response returned from the server as an object {@code <R>}
     */
    void onResponse(NYCSchool[] response);

    /**
     * Notifies the listener that a successful response has been returned by the server
     *
     * @param response the server response returned from the server as an object {@code <R>}
     */
    void onResponse(SATScore[] response);

    /**
     * Notifies the listener that an error was returned from the network call
     *
     * @param error error given by the network call
     */
    void onErrorResponse(E error);

    /**
     * Notifies the listener that an exception has occurred while performing the network call
     *
     * @param error details of the failure that occurred
     */
    void onFail(SchoolError error);
}
