package com.kwawannan.newyorkschools.network;

import com.kwawannan.newyorkschools.core.Element;
import com.kwawannan.newyorkschools.core.SerializedName;

import java.util.List;

;

/**
 * The response given to the consumer of an API if there is an error which occurs while processing
 * the request. This
 * contains a list of individual {@link Error} representing each error which has occurred.
 */

public class ErrorResponse {
    @SerializedName(name = "errors")
    @Element(required = true)
    private List<Error> errors;

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public List<Error> getErrors() {
        return errors;
    }
}
