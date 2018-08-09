package com.individual.kehao.addonsdk.okhttp.request;

/*
 * Project Name: ComponentPackagingTraining
 * Package Name: com.individual.kehao.addonsdk.okhttp.request
 * File    Name: CommonRequest
 * Create  By:   Ke Hao
 * Create  Time: 2018/8/9
 * Description : receive request params, generate request object
 */

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Request;

public class CommonRequest {

    /**
     *
     * @param url
     * @param params
     * @return a generated request object
     */
    public static Request createPostRequest(String url, RequestParams params){
        FormBody.Builder mFormBodyBuild = new FormBody.Builder();
        if (params!=null){

            for(Map.Entry<String, String> entry:params.urlParams.entrySet()){
                //traversing and add all request params to request member class
                mFormBodyBuild.add(entry.getKey(), entry.getValue());
            }
        }

        FormBody formBody = mFormBodyBuild.build();

        return new Request.Builder().url(url).post(formBody).build();
    }

    /**
     *
     * @param url
     * @param params
     * @return return a get request with params
     */
    public static Request createGetRequest(String url, RequestParams params){
        StringBuilder urlBuilder = new StringBuilder(url).append("?");

        if(params!=null){
            for(Map.Entry<String, String> entry:params.urlParams.entrySet()){

                urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }

        return new Request.Builder().url(urlBuilder.substring(0,urlBuilder.length()-1)).get().build();
    }
}
