package com.qhzk.ciep.common.okhttp.request;


import com.qhzk.ciep.common.okhttp.OkHttpClientManage;
import com.qhzk.ciep.common.okhttp.callback.Callback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;


public class RequestCall {

    private OkHttpRequest okHttpRequest;
    private Request request;
    private Call call;

    public RequestCall(OkHttpRequest request) {
        this.okHttpRequest = request;
    }

    public Call buildCall(Callback callback) {
        request = generateRequest(callback);
        return OkHttpClientManage.getOkHttpNoCacheClient().newCall(request);
    }

    private Request generateRequest(Callback callback) {
        return okHttpRequest.generateRequest(callback);
    }

    public void execute(Callback callback) {
        call = buildCall(callback);
        if (callback != null) {
            callback.onBefore(request);
        }
        OkHttpClientManage.getOkHttpClientManage().execute(this, callback);
    }

    public Call getCall() {
        return call;
    }

    public Request getRequest() {
        return request;
    }

    public OkHttpRequest getOkHttpRequest() {
        return okHttpRequest;
    }

    public Response execute() throws IOException {
        call = buildCall(null);
        return call.execute();
    }

    public void cancel() {
        if (call != null) {
            call.cancel();
        }
    }

}
