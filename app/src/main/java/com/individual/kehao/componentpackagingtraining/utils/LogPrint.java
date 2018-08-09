package com.individual.kehao.componentpackagingtraining.utils;

import android.util.Log;

public class LogPrint {

    //开关
    private static final  boolean DEBUG = true;
    //TAG
    private static final String TAG = "HIGHLIGHT HERE";

    //五个等级  DIWE

    public static void d(String text){
        if(DEBUG){
            Log.d(TAG,text);
        }
    }

    public static void i(String text){
        if(DEBUG){
            Log.i(TAG,text);
        }
    }

    public static void w(String text){
        if(DEBUG){
            Log.w(TAG,text);
        }
    }

    public static void e(String text){
        if(DEBUG){
            Log.e(TAG,text);
        }
    }
}
