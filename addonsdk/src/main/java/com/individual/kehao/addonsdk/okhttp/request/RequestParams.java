package com.individual.kehao.addonsdk.okhttp.request;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * Project Name: ComponentPackagingTraining
 * Package Name: com.individual.kehao.addonsdk.okhttp.request
 * File    Name: RequestParams
 * Create  By:   Ke Hao
 * Create  Time: 2018/8/9
 * Description : packaging all request parameters to a HashMap
 */
public class RequestParams {
    public ConcurrentHashMap<String, String> urlParams = new ConcurrentHashMap<String, String>();
    public ConcurrentHashMap<String, Object> fileParams = new ConcurrentHashMap<String, Object>();

    /**
     * Constructs a new empty {@code RequestParams} instance
     */
    public RequestParams() {
        this((Map<String, String>) null);
    }

    /**
     * constructs a new RequestParams instance Containing the key/value string
     * params from the specified map
     * @param source source key/value to add
     */

    public RequestParams(Map<String, String> source) {
        if (source != null) {
            for (Map.Entry<String, String> entry : source.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * Constructs a new RequestParams instance and populate it with a single
     * initial key/value string param.
     *
     * @param key   the key name for the intial param.
     * @param value the value string for the initial param.
     */
    public RequestParams(final String key, final String value) {
        this(new HashMap<String, String>() {
            {
                put(key, value);
            }
        });
    }

    /**
     * adds a key/value string pair to request
     *
     * @param key   the key name for the new param
     * @param value the value string for the new param
     */
    public void put(String key, String value) {
        if (key != null && value != null) {
            urlParams.put(key, value);
        }
    }

    public void put(String key, Object object) throws FileNotFoundException {
        if (key != null) {
            fileParams.put(key, object);
        }
    }

    public boolean hasParams() {
        if (urlParams.size() > 0 || fileParams.size() > 0) {
            return true;
        }
        return false;
    }

}