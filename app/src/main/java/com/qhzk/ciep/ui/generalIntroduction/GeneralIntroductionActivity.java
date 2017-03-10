package com.qhzk.ciep.ui.generalIntroduction;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.qhzk.ciep.R;
import com.qhzk.ciep.adapter.GeneralIntroAdapter;
import com.qhzk.ciep.base.BaseActivity;

import butterknife.BindView;

/**
 * 大会介绍页面
 */
public class GeneralIntroductionActivity extends BaseActivity {

    @BindView(R.id.tablayout)
    TabLayout mTablayout;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    private int mCurpostion = 0; //默认position=0
    private GeneralIntroAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_general_introduction;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        mCurpostion = (int) savedInstanceState.get("position");
    }

    @Override
    protected void initdata() {
        super.initdata();
        String[] subTitles = new String[]{"总体介绍", "大会论坛","参展指南", "展位搭建", "大会服务","参展名单","往期回顾"};
        for (String subTitle : subTitles) {
            mTablayout.addTab(mTablayout.newTab().setText(subTitle));
        }
        //TODO  ViewPager + Adapter
        mAdapter = new GeneralIntroAdapter(getSupportFragmentManager());
        mViewpager.setAdapter(mAdapter);
        mViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTablayout));
        mTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewpager.setCurrentItem(tab.getPosition(), true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }

        });
        Log.d("position=======", mCurpostion+"");
        mViewpager.setCurrentItem(mCurpostion);
    }
}
