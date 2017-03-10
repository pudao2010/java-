package com.qhzk.ciep.ui.datastatistics;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.qhzk.ciep.R;
import com.qhzk.ciep.adapter.DataStaticsAdapter;
import com.qhzk.ciep.base.BaseActivity;

import butterknife.BindView;

/**
 * 数据统计
 */
public class DatastatisticsActivity extends BaseActivity {

    @BindView(R.id.tablayout)
    TabLayout mTablayout;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    private DataStaticsAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_datastatistics;
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
    protected void initdata() {
        super.initdata();
        String[] subTitles = new String[]{"参会人员", "参展单位","人才对接","项目对接"};
        for (String subTitle : subTitles) {
            mTablayout.addTab(mTablayout.newTab().setText(subTitle));
        }
        //TODO ViewPager + Adapter
        mAdapter = new DataStaticsAdapter(getSupportFragmentManager());
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
    }
}
