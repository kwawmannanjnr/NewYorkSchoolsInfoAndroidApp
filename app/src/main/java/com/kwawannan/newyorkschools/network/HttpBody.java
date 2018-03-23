package com.kwawannan.newyorkschools.network;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * Body of {@link HttpRequest}, encapsulating the payload
 */
public class HttpBody {
    private final String contentType;
    private final long contentLength;
    private final byte[] content;
    private final ByteArrayInputStream contentInputStream;

    HttpBody(String content, String contentType) throws UnsupportedEncodingException {
        this(content.getBytes("UTF-8"), contentType);
    }

    HttpBody(byte[] content, String contentType) {
        this.contentType = contentType;
        this.contentLength = content.length;
        this.content = content;
        this.contentInputStream = new ByteArrayInputStream(content);
    }

    public InputStream getContent() {
        return contentInputStream;
    }

    long getContentLength() {
        return contentLength;
    }

    String getContentType() {
        return contentType;
    }


}