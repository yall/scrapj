package org.scrapj.http;

import org.scrapj.context.Callback;
import org.scrapj.context.DummyCallback;

import java.util.HashMap;
import java.util.Map;

public class RequestBuilder {

    private String url;

    private Method method;

    private Map<String, String> headers = new HashMap<>();

    private Callback callback = DummyCallback.INSTANCE;

    public static RequestBuilder create() {
        return new RequestBuilder();
    }

    public RequestBuilder url(String url) {
        this.url = url;
        return this;
    }

    public RequestBuilder header(String name, String value) {
        this.headers.put(name, value);
        return this;
    }

    public RequestBuilder method(Method method) {
        this.method = method;
        return this;
    }

    public RequestBuilder callback(Callback callback) {
        this.callback = callback;
        return this;
    }

    public Request build() {
        Request request = new Request();
        request.setUrl(this.url);
        request.setHeaders(this.headers);
        request.setMethod(this.method);
        request.setCallback(this.callback);
        return request;
    }

}
