package com.kwawannan.newyorkschools.network;

import java.util.Map;

/**
 * Callback interface used to receive Http response data. Data comes back as a string as either an
 * error or a response.
 */

public interface HttpCallback {
    /**
     * Notifies the listener that a successful response has been returned by the server
     *
     * @param response the server response returned from the server as an object {@code <R>}
     * @param header
     */
    void onResponse(String response, Map<String, String> header);

    /**
     * Notifies the listener that an error was returned from the network call
     *
     * @param error error given by the network call
     */
    void onErrorResponse(String error);

    /**
     * Notifies the listener that an exception has occurred while performing the network call
     *
     * @param error details of the failure that occurred
     */
    void onFail(SchoolError error);
}
