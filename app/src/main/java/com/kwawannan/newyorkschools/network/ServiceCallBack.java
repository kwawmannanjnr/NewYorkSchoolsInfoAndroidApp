package com.kwawannan.newyorkschools.network;

/**
 * Callback interface to notify when an HttpResponse is returned
 */

interface ServiceCallback<R> {
  /**
   * Notifies the listener that a successful response has been returned by the server
   *
   * @param response the server response returned from the server as an object {@code <R>}
   */
  void onResponse(R response);

  /**
   * Notifies the listener that an error was returned from the network call
   *
   * @param error {@link SchoolError} object for the error given by the network call
   */
  void onError(SchoolError error);
}
