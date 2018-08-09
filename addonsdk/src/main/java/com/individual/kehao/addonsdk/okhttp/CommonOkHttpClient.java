package com.individual.kehao.addonsdk.okhttp;

import com.individual.kehao.addonsdk.okhttp.https.HttpsUtils;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/*
 * Project Name: ComponentPackagingTraining
 * Package Name: com.individual.kehao.addonsdk
 * File    Name: CommonOkHttpClient
 * Create  By:   Ke Hao
 * Create  Time: 2018/8/9
 * Description : send request; request parameter config; http support
 */
public class CommonOkHttpClient {

    private static final int TIME_OUT = 30; //time out
    private static OkHttpClient okHttpClient;

    //config params for client
    static {

        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        //fillin time out
        okHttpBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);

        okHttpBuilder.followRedirects(true);

        okHttpBuilder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        });

        okHttpBuilder.sslSocketFactory(HttpsUtils.initSSLSocketFactory(), HttpsUtils.initTrustManager());
        okHttpClient = okHttpBuilder.build();
    }

    /**
     * send specific http/https request
     * @param request
     * @param commCallback
     * @return call
     */
    public static Call sendRequest(Request request, Callback commCallback) {
        Call call = okHttpClient.newCall(request);
        call.enqueue(commCallback);
        return call;
    }
}
