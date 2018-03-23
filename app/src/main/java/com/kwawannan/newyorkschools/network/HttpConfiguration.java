package com.kwawannan.newyorkschools.network;

/**
 * This class holds the configuration parameters for HttpClient to perform Http requests.
 */
public class HttpConfiguration {
    private int timeoutInMillis;

    public HttpConfiguration(int timeoutInMillis) {
        this.timeoutInMillis = timeoutInMillis;
    }

    int getTimeoutInMillis() {
        return timeoutInMillis;
    }
}
