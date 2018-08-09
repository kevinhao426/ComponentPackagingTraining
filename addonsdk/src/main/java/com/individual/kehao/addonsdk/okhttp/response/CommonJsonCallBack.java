package com.individual.kehao.addonsdk.okhttp.response;

import android.os.Handler;
import android.os.Looper;

import com.alibaba.fastjson.JSON;
import com.individual.kehao.addonsdk.okhttp.exception.OkHttpException;
import com.individual.kehao.addonsdk.okhttp.listener.DisposeDataHandler;
import com.individual.kehao.addonsdk.okhttp.listener.DisposeDataListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


/**
 * Project Name: ComponentPackagingTraining
 * Package Name: com.individual.kehao.addonsdk.okhttp.response
 * File    Name: CommonJsonCallBack
 * Create  By:   Ke Hao
 * Create  Time: 2018/8/9
 * Description : response to Json callback
 */
public class CommonJsonCallBack implements Callback{

    //relate to server return
    protected final String RESULT_CODE = "ecode";
    protected final int RESULT_CODE_VALUE= 0;
    protected final String ERROR_MSG = "emsg";
    protected final String EMPTY_MSG = "";

    //customise error
    protected final int NETWORK_ERROR = -1;
    protected final int JSON_ERROR = -2;
    protected final int OTHER_ERROR = -3;

    private Handler mDeliveryHandler;
    private DisposeDataListener mListener;
    private Class<?> mClass;

    public CommonJsonCallBack(DisposeDataHandler handler){
        this.mListener = handler.mListener;
        this.mClass = handler.mClass;
        this.mDeliveryHandler = new Handler(Looper.getMainLooper());
    }

    /**
     * fail processing
     * @param call
     * @param e
     */
    @Override
    public void onFailure(final Call call, final IOException e) {
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                mListener.onFailure(new OkHttpException(NETWORK_ERROR, e));
            }
        });
    }

    /**
     * response processing
     * @param call
     * @param response
     * @throws IOException
     */
    @Override
    public void onResponse(Call call, final Response response) throws IOException {
        final String result = response.body().string();
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                handleResponse(result);
            }
        });
    }

    private void handleResponse(Object responseObj) {

        if (responseObj == null && responseObj.toString().trim().equals("")){
            mListener.onFailure(new OkHttpException(NETWORK_ERROR, EMPTY_MSG));
        }

        try {
            JSONObject result = new JSONObject(responseObj.toString());
            //try analysis json
            if (result.has(RESULT_CODE)){
                //get result code, if it is 0 then the response is correct
                if (result.getInt(RESULT_CODE)==RESULT_CODE_VALUE){
                    //no need analysis, return to app layer
                    if (mClass == null){
                        mListener.onSuccess(responseObj);
                    }else {
                        //turn jsonObject to module
                        Object obj = JSON.parseObject(String.valueOf(result));

                        if (obj != null){
                            mListener.onSuccess(obj);
                        }else {
                            //illegal Json
                            mListener.onFailure(new OkHttpException(JSON_ERROR, EMPTY_MSG));
                        }
                    }
                }else {
                    mListener.onFailure(new OkHttpException(OTHER_ERROR, result.get(RESULT_CODE)));
                }
            }
        } catch (JSONException e) {
            mListener.onFailure(new OkHttpException(OTHER_ERROR, e.getMessage()));
        }
    }
}
