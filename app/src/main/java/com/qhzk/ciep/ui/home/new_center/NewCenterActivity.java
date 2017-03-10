package com.qhzk.ciep.ui.home.new_center;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.qhzk.ciep.R;
import com.qhzk.ciep.adapter.NewCenterFrameAdapter;
import com.qhzk.ciep.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by QixiongYuan on 2016/12/9.
 * 新闻中心页面
 */

public class NewCenterActivity extends BaseActivity {

    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    @BindView(R.id.tablayout)
    TabLayout mTablayout;

    private NewCenterFrameAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_new_center;
    }

    @Override
    protected void initview() {
        super.initview();
        //  ToolBar的返回键
        mToolbar.setNavigationOnClickListener(v -> finish());
        mTablayout.addTab(mTablayout.newTab().setText("大会新闻"));
        mTablayout.addTab(mTablayout.newTab().setText("行业新闻"));
        mTablayout.addTab(mTablayout.newTab().setText("单位动态"));
        mTablayout.addTab(mTablayout.newTab().setText("大会视频"));

        mAdapter = new NewCenterFrameAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTablayout));
        mTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition(), true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }

        });

    }

    @Override
    protected void initdata() {
        super.initdata();
    }
}
