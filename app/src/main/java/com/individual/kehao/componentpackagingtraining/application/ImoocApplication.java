package com.individual.kehao.componentpackagingtraining.application;

import android.app.Application;

/*
 * Project Name: ComponentPackagingTraining
 * Package Name: com.individual.kehao.componentpackagingtraining.application
 * File    Name: ImoocApplication
 * Create  By:   Ke Hao
 * Create  Time: 2018/8/8
 * Description : 1. entrance
 *               2. initialization
 *               3. context
 */
public class ImoocApplication extends Application {
    private static ImoocApplication mApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

    public static ImoocApplication getInstance(){
        return mApplication;
    }
}
