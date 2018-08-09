package com.individual.kehao.componentpackagingtraining.activity;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.individual.kehao.componentpackagingtraining.R;
import com.individual.kehao.componentpackagingtraining.activity.base.BaseActivity;
import com.individual.kehao.componentpackagingtraining.utils.LogPrint;
import com.individual.kehao.componentpackagingtraining.view.fragment.home.HomeFragment;
import com.individual.kehao.componentpackagingtraining.view.fragment.home.MessageFragment;
import com.individual.kehao.componentpackagingtraining.view.fragment.home.MineFragment;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    /*
     * about fragments
     * */
    private FragmentManager fm;
    private HomeFragment mHomeFragment;
    private MessageFragment mMessageFragment;
    private MineFragment mMineFragment;
    private Fragment mCurrent;

    private RelativeLayout mHomeLayout;
    private RelativeLayout mPondLayout;
    private RelativeLayout mMessageLayout;
    private RelativeLayout mMineLayout;

    private TextView mHomeView;
    private TextView mPondView;
    private TextView mMessageView;
    private TextView mMineView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);

        initView();

        //set default fragment
        mHomeFragment = new HomeFragment();
        fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout, mHomeFragment);
        fragmentTransaction.commit();

    }

    private void initView() {
        mHomeLayout = findViewById(R.id.home_layout_view);
        mHomeLayout.setOnClickListener(this);
        mPondLayout = findViewById(R.id.pond_layout_view);
        mPondLayout.setOnClickListener(this);
        mMessageLayout = findViewById(R.id.message_layout_view);
        mMessageLayout.setOnClickListener(this);
        mMineLayout = findViewById(R.id.mine_layout_view);
        mMineLayout.setOnClickListener(this);

        mHomeView = findViewById(R.id.home_image_view);
        mPondView = findViewById(R.id.fish_image_view);
        mMessageView = findViewById(R.id.message_image_view);
        mMineView = findViewById(R.id.mine_image_view);

        mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);
        LogPrint.i("tag: finish init");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * this function is used to hide a specific fragment
     *
     * @param fragment
     * @param ft
     */
    private void hideFragment(Fragment fragment, FragmentTransaction ft) {
        if (fragment != null) {
            ft.hide(fragment);
        }
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        switch (view.getId()) {
            case R.id.home_layout_view:
                LogPrint.i("tag: 1");
                //icon change
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person);

                //hide other fragments
                hideFragment(mMessageFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);

                //show Home Fragment
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content_layout, mHomeFragment);
                } else {
                    fragmentTransaction.show(mHomeFragment);
                }
                break;

            case R.id.message_layout_view:
                LogPrint.i("tag: 2");
                //icon change
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message_selected);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person);

                //hide other fragments
                hideFragment(mHomeFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);

                //show Message Fragment
                if (mMessageFragment == null) {
                    mMessageFragment = new MessageFragment();
                    fragmentTransaction.add(R.id.content_layout, mMessageFragment);
                } else {
                    fragmentTransaction.show(mMessageFragment);
                }
                break;

            case R.id.mine_layout_view:
                LogPrint.i("tag: 3");
                //icon change
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person_selected);

                //hide other fragments
                hideFragment(mHomeFragment, fragmentTransaction);
                hideFragment(mMessageFragment, fragmentTransaction);

                //show Mine Fragment
                if (mMineFragment == null) {
                    mMineFragment = new MineFragment();
                    fragmentTransaction.add(R.id.content_layout, mMineFragment);
                } else {
                    fragmentTransaction.show(mMineFragment);
                }
                break;
        }

        fragmentTransaction.commit();
    }
}
