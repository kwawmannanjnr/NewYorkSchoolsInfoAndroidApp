package com.kwawannan.newyorkschools.network;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * /**
 * Error class used to indicate when issues arise during execution of the ISS Call. {@code
 * SchoolError} uses a {@code code} to distinguish between different types of errors. An
 * accompanying {@code message} gives a detailed explanation as to the cause of the error.
 */
public class SchoolError {
    public static final int ERROR_CODE_NETWORK_ERROR = 404;
    public static final int ERROR_CODE_REQUEST_TIMEOUT = 408;
    public static final int ERROR_CODE_REQUEST_FAILED = 104;


    private final int code;
    private final String message;

    public SchoolError(@ErrorCode int code, String message) {
        this.code = code;
        this.message = message;
    }

    public
    @ErrorCode
    int code() {
        return code;
    }

    public String message() {
        return message;
    }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({
            ERROR_CODE_NETWORK_ERROR, ERROR_CODE_REQUEST_TIMEOUT, ERROR_CODE_REQUEST_FAILED
    })
    @interface ErrorCode {
    }
}
