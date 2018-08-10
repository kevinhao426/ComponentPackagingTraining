package com.individual.kehao.addonsdk.okhttp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*
 * Project Name: ComponentPackagingTraining
 * Package Name: com.individual.kehao.addonsdk
 * File    Name: BaseOkHttpTest
 * Create  By:   Ke Hao
 * Create  Time: 2018/8/9
 * Description :
 */
public class BaseOkHttpTest extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void sendRequest(){
        //Create an okhttpclient obj
        OkHttpClient okHttpClient = new OkHttpClient();

        //create a request
        final Request request = new Request.Builder().url("https://www.imooc.com/").build();

        //a new call
        Call call = okHttpClient.newCall(request);

        //add into dispatching
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            //if request succeed
            @Override
            public void onResponse(Call call, Response response) throws IOException {
            }
        });
    }
}
