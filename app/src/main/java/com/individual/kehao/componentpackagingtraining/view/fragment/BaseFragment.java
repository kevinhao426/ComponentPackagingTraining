package com.individual.kehao.componentpackagingtraining.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/*
 * Project Name: ComponentPackagingTraining
 * Package Name: com.individual.kehao.componentpackagingtraining.view.fragment
 * File    Name: BaseFragment
 * Create  By:   Ke Hao
 * Create  Time: 2018/8/8
 * Description : provide shared public events or actions for all fragments
 */
public class BaseFragment extends Fragment {

    protected Activity mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
