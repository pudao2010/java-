package com.qhzk.ciep.common.okhttp.request;


import com.qhzk.ciep.common.okhttp.callback.Callback;

import java.util.Map;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;

public abstract class OkHttpRequest {

    protected String url;
    protected Object tag;
    protected Map<String, String> params;
    protected Map<String, String> headers;
    protected Request.Builder builder = new Request.Builder();

    protected OkHttpRequest(String url, Object tag, Map<String, String> params, Map<String, String> headers) {
        this.url = url;
        this.tag = tag;
        this.params = params;
        this.headers = headers;
        if (url == null) {
            throw new IllegalArgumentException("url can not be null.");
        }
        initBuilder();
    }

    private void initBuilder() {
        builder.url(url).tag(tag);
        appendHeaders();
    }

    protected abstract RequestBody buildRequestBody();

    protected RequestBody wrapRequestBody(RequestBody requestBody, Callback callback) {
        return requestBody;
    }

    protected abstract Request buildRequest(RequestBody requestBody);

    public RequestCall build() {
        return new RequestCall(this);
    }

    public Request generateRequest(Callback callback) {
        RequestBody requestBody = buildRequestBody();
        RequestBody wrappedRequestBody = wrapRequestBody(requestBody, callback);
        return buildRequest(wrappedRequestBody);
    }

    protected void appendHeaders() {
        Headers.Builder headerBuilder = new Headers.Builder();
        if (headers == null || headers.isEmpty()) return;
        for (String key : headers.keySet()) {
            headerBuilder.add(key, headers.get(key));
        }
        builder.headers(headerBuilder.build());
    }

}
