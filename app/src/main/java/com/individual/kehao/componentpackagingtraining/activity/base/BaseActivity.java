package com.individual.kehao.componentpackagingtraining.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/*
 * Project Name: ComponentPackagingTraining
 * Package Name: com.individual.kehao.componentpackagingtraining.activity.base
 * File    Name: BaseActivity
 * Create  By:   Ke Hao
 * Create  Time: 2018/8/8
 * Description : provide shared public actions for all activities
 */
public class BaseActivity extends AppCompatActivity {

    public String TAG;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getComponentName().getShortClassName();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
