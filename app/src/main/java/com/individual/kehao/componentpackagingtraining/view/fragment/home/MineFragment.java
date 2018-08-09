package com.individual.kehao.componentpackagingtraining.view.fragment.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.individual.kehao.componentpackagingtraining.R;
import com.individual.kehao.componentpackagingtraining.view.fragment.BaseFragment;

/*
 * Project Name: ComponentPackagingTraining
 * Package Name: com.individual.kehao.componentpackagingtraining.view.fragment.home
 * File    Name: MineFragment
 * Create  By:   Ke Hao
 * Create  Time: 2018/8/8
 * Description :
 */
public class MineFragment extends BaseFragment {
    private View mContentView;

    public MineFragment(){
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getActivity();
        mContentView = inflater.inflate(R.layout.fragment_mine_layout, container, false);
        return mContentView;
    }
}
