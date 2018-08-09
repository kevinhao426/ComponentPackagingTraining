package com.individual.kehao.componentpackagingtraining.view.fragment.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.individual.kehao.componentpackagingtraining.R;
import com.individual.kehao.componentpackagingtraining.view.fragment.BaseFragment;

/*
 * Project Name: ComponentPackagingTraining
 * Package Name: com.individual.kehao.componentpackagingtraining.view.fragment.home
 * File    Name: HomeFragment
 * Create  By:   Ke Hao
 * Create  Time: 2018/8/8
 * Description :
 */
public class HomeFragment extends BaseFragment{

    private View mContentView;

    public HomeFragment(){
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getActivity();
        mContentView = inflater.inflate(R.layout.fragment_home_layout, container, false);
        return mContentView;
    }
}
