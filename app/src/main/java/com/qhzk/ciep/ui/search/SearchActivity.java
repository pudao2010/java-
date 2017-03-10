package com.qhzk.ciep.ui.search;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.qhzk.ciep.R;
import com.qhzk.ciep.adapter.SearchFrameAdapter;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.entity.SearchNewEntity;
import com.qhzk.ciep.entity.SearchUnitEntity;
import com.qhzk.ciep.ui.search.news.NewsFragment;
import com.qhzk.ciep.ui.search.unit.UnitFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by pudao on 2016/11/10.
 * 2017年1月3日09:53:53
 */

public class SearchActivity extends BaseActivity<SearchPresenter> implements SearchView {

    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    @BindView(R.id.tablayout)
    TabLayout mTablayout;
    @BindView(R.id.keyword)
    EditText mKeyword;
    private SearchFrameAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initview() {
        super.initview();

        mTablayout.addTab(mTablayout.newTab().setText("参展单位"));
        mTablayout.addTab(mTablayout.newTab().setText("新闻"));

        mAdapter = new SearchFrameAdapter(getSupportFragmentManager());
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


    @OnClick({R.id.back, R.id.search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.search:
                //TODO 搜索
                String keyword = mKeyword.getText().toString();
                if (!TextUtils.isEmpty(keyword)){
                    int selectedTabPosition = mTablayout.getSelectedTabPosition();
                    if (selectedTabPosition==0){
                        // 搜索单位
                        mActivityPresenter.searchUnit(keyword);
                    }else{
                        // 搜索新闻
                        mActivityPresenter.searchNew(keyword);
                    }
                }else{
                    return;
                }
                break;
        }
    }

    @Override
    public void onSearchNewSuccess(List<SearchNewEntity.NewsBean.RowsBean> rows) {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        NewsFragment fragment = (NewsFragment) fragments.get(1);
        fragment.onSearchSuccess(rows);
    }

    @Override
    public void onSearchNewFailed(List<SearchNewEntity.NewsBean.RowsBean> rows) {
        showToast("没有符合条件的结果");
    }

    @Override
    public void onError(Exception e) {
        showToast("发生错误 : "+e);
    }

    @Override
    public void onSearchUnitSuccess(List<SearchUnitEntity.EnterpriseBean.RowsBean> rows) {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        UnitFragment fragment = (UnitFragment) fragments.get(0);
        fragment.onSearchSuccess(rows);
    }

    @Override
    public void onSearchUnitFailed(List<SearchUnitEntity.EnterpriseBean.RowsBean> rows) {
        showToast("没有符合条件的结果");
    }
}
