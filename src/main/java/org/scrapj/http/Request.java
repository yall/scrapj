package org.scrapj.http;

import org.scrapj.context.Callback;

import java.util.HashMap;
import java.util.Map;

public class Request {

    private String url;

    private Map<String, String> headers = new HashMap<>();

    private Method method;

    private Callback callback;

    Request() {
    }

    public String getUrl() {
        return url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Method getMethod() {
        return method;
    }

    public Callback getCallback() {
        return callback;
    }

    void setMethod(Method method) {
        this.method = method;
    }

    void setUrl(String url) {
        this.url = url;
    }

    void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }
}
