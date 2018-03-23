package com.kwawannan.newyorkschools.core;

/**
 * Serializer
 */

import org.json.JSONException;

/**
 * Serializer interface to convert a String to an object and backk
 */

public interface Serializer {

    /**
     * Convert an object of any type into a JSON representation of its data.
     *
     * @param object the object who structure will be converted to JSON representation
     * @return a String representation of the object passed in
     */
    <T> String serialize(T object) throws JSONException;

    /**
     * Transform a JSON string representing an object of a given type to that object itself
     *
     * @param clazz      the type represented by the JSON string
     * @param serialized JSON string representation of the object to be returned
     * @return the object represented by the JSON string
     */
    <T> T deserialize(Class<T> clazz, String serialized) throws JSONException;
}
