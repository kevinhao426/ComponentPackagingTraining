package com.individual.kehao.addonsdk.okhttp.listener;

/*
 * Project Name: ComponentPackagingTraining
 * Package Name: com.individual.kehao.addonsdk.okhttp.listener
 * File    Name: DisposeDataHandler
 * Create  By:   Ke Hao
 * Create  Time: 2018/8/9
 * Description :
 */
public class DisposeDataHandler {

    public DisposeDataListener mListener = null;

    public Class<?> mClass = null;

    public DisposeDataHandler(DisposeDataListener listener){
        this.mListener = listener;
    }

    public DisposeDataHandler(DisposeDataListener listener, Class<?> clazz){
        this.mListener = listener;
        this.mClass = clazz;
    }
}
