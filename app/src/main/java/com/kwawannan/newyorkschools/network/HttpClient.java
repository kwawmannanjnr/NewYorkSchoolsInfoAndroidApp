package com.kwawannan.newyorkschools.network;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@code Client} used execute requests and return the response
 */
public class HttpClient {

    private static final String CONTENT_LENGTH_HEADER = "Content-Length";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";

    private HttpConfiguration configuration;

    HttpClient(HttpConfiguration configuration) {
        this.configuration = configuration;
    }

    public static HttpClient createClient(HttpConfiguration configuration) {
        return new HttpClient(configuration);
    }

    /**
     * Executes the given {@code} request on an {@link HttpURLConnection} and returns the response
     *
     * @param httpRequest request to be executed
     * @return {@code HttpResponse} returned from the connection
     * @throws IOException exception thrown if the output stream cannot be given
     */
    HttpResponse execute(HttpRequest httpRequest) throws IOException {
        HttpURLConnection connection = getRequest(httpRequest);

        //HttpBody body = httpRequest.getBody();
        //OutputStream outputStream = connection.getOutputStream();
        //  writeTo(outputStream , httpRequest.getQueryParameters());
        //  outputStream.flush();
        //  outputStream.close();

        return getResponse(connection);
    }

    void writeTo(OutputStream out, Map<String, String> queryParameters) throws IOException {
        if (out == null) {
            throw new IllegalArgumentException("Output stream cannot be null");
        }
        StringBuilder result = new StringBuilder();

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
        // out.write(content);

        result.append(URLEncoder.encode("lat", "UTF-8"));
        result.append("=");
        result.append(URLEncoder.encode(queryParameters.get("lat"), "UTF-8"));
        result.append("&");
        result.append(URLEncoder.encode("lon", "UTF-8"));
        result.append("=");
        result.append(URLEncoder.encode(queryParameters.get("lon"), "UTF-8"));
    }

    private HttpURLConnection getRequest(HttpRequest httpRequest) throws IOException {
        HttpURLConnection connection;


        URL url = new URL(httpRequest.getUrl());

        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(httpRequest.getMethod());

        connection.setConnectTimeout(configuration.getTimeoutInMillis());
        connection.setReadTimeout(configuration.getTimeoutInMillis());
        connection.setDoInput(true);
        //In case of 302 if we decide to go with caching approach ??  YAGNI??
        connection.setInstanceFollowRedirects(false);

        // In case of SSL Certificate pinning
        //connection.setSSLSocketFactory(getSocketFactory());
        for (Map.Entry<String, String> entry : httpRequest.getAllHeaders().entrySet()) {
            connection.setRequestProperty(entry.getKey(), entry.getValue());
        }

        HttpBody body = httpRequest.getBody();
        if (body != null) {
            connection.setRequestProperty(CONTENT_LENGTH_HEADER, String.valueOf(body.getContentLength()));
            connection.setRequestProperty(CONTENT_TYPE_HEADER, body.getContentType());
            connection.setDoOutput(true);
        }

        return connection;
    }

    private HttpResponse getResponse(HttpURLConnection connection) throws IOException {

        int statusCode = connection.getResponseCode();

        InputStream content;
        if (statusCode < 400) {
            content = connection.getInputStream();
        } else {
            content = connection.getErrorStream();
        }

        int totalSize = connection.getContentLength();
        String reason = connection.getResponseMessage();

        Map<String, String> headers = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : connection.getHeaderFields().entrySet()) {
            if (entry.getKey() != null && !entry.getValue().isEmpty()) {
                headers.put(entry.getKey(), entry.getValue() == null ? "" : entry.getValue().get(0));
            }
        }

        String contentType = connection.getContentType();

        return new HttpResponse.Builder().statusCode(statusCode)
                .content(content)
                .size(totalSize)
                .reason(reason)
                .headers(headers)
                .contentType(contentType)
                .build();
    }
}