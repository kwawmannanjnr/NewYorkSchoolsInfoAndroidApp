package com.kwawannan.newyorkschools.network;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * {@code Request} used with {@link HttpClient} to perform a request to a given {@code URL}. This
 * class uses {@link Builder} to produce a usable object. When this object is given to {@link
 * HttpClient}, the {@code client} can execute the network call.
 */
public class HttpRequest {
    static final String POST = "POST";
    static final String GET = "GET";
    static final String PUT = "PUT";
    static final String DELETE = "DELETE";
    static final String HEAD = "HEAD";
    private final String url;
    @Method
    private final String method;
    private final Map<String, String> headers;
    private final Map<String, String> queryParameters;
    private final HttpBody body;

    public boolean isUsePageReference() {
        return usePageReference;
    }

    public void setUsePageReference(boolean usePageReference) {
        this.usePageReference = usePageReference;
    }

    private boolean usePageReference;

    private HttpRequest(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = Collections.unmodifiableMap(new HashMap<>(builder.headers));
        this.queryParameters = Collections.unmodifiableMap(new HashMap<>(builder.queryParameters));
        this.usePageReference = builder.usePageReference;
        this.body = builder.body;
    }

    String getUrl() {
        return url;
    }

    @Method
    String getMethod() {
        return method;
    }

    Map<String, String> getAllHeaders() {
        return headers;
    }

    Map<String, String> getQueryParameters() {
        return queryParameters;
    }

    String getHeader(String name) {
        return headers.get(name);
    }

    HttpBody getBody() {
        return body;
    }

    @StringDef({POST, GET, PUT, DELETE, HEAD})
    @Retention(RetentionPolicy.SOURCE)
    @interface Method {
    }

    static final class Builder {
        @Method
        private String method;
        private String url;
        private Map<String, String> headers;
        private Map<String, String> queryParameters;
        private HttpBody body;
        private boolean usePageReference;

        Builder() {
            this.headers = new HashMap<>();
            this.queryParameters = new HashMap<>();
        }

        /**
         * @param url URL of the server to which the request should be made
         */
        Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        /**
         * @param method Http method must match one of the pre-defined {@code static method strings}
         */
        Builder setMethod(@Method String method) {
            this.method = method;
            return this;
        }

        Builder setPageReference(boolean flag) {
            this.usePageReference = flag;
            return this;
        }

        /**
         * @param body the request body with content
         */
        Builder setBody(HttpBody body) {
            this.body = body;
            return this;
        }

        /**
         * Add header to the existing headers map
         *
         * @param name  header key
         * @param value header value
         */
        Builder addHeader(String name, String value) {
            headers.put(name, value);
            return this;
        }

        /**
         * Add query parameter to existing query parameters
         *
         * @param name  query name
         * @param value query value
         */
        Builder addQueryParameter(String name, String value) {
            queryParameters.put(name, value);
            return this;
        }

        Builder setQueryParameters(Map<String, String> queryParameters) {
            this.queryParameters.putAll(queryParameters);
            return this;
        }

        /**
         * Add to the existing headers the given map
         *
         * @param headers map of headers to include in this request
         */
        Builder addHeaders(Map<String, String> headers) {
            this.headers.putAll(headers);
            return this;
        }

        /**
         * Replace the existing headers with the given map
         *
         * @param headers map of headers to include in this request
         */
        Builder setHeaders(Map<String, String> headers) {
            this.headers = new HashMap<>(headers);
            return this;
        }

        /**
         * @return the formed {@code HttpRequest}
         */
        HttpRequest build() {
            return new HttpRequest(this);
        }
    }
}