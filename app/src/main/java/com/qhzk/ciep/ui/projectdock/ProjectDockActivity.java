package com.qhzk.ciep.ui.projectdock;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;

import com.qhzk.ciep.R;
import com.qhzk.ciep.adapter.ProjectDockAdapter;
import com.qhzk.ciep.ui.projectdock.fragment.ProjectPromotionFragment;
import com.qhzk.ciep.ui.projectdock.fragment.ProjectRequireFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目对接页面
 */
public class ProjectDockActivity extends AppCompatActivity {

    public static final int REQUEST_FILTER_PROJECT = 100;
    @BindView(R.id.filter)
    ImageButton mFilter;
    @BindView(R.id.tablayout)
    TabLayout mTablayout;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private ProjectDockAdapter mAdapter;
    private TabLayout.OnTabSelectedListener mOnTabSelectedListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_dock);
        ButterKnife.bind(this);
        initview();
        initdata();
    }

    protected void initview() {
        mToolbar.setNavigationOnClickListener(v -> finish());
        mDrawerLayout.setStatusBarBackgroundColor(Color.parseColor("#0061c0"));
    }

    protected void initdata() {
        String[] subTitles = new String[]{"项目推介", "项目引进"};
        for (String subTitle : subTitles) {
            mTablayout.addTab(mTablayout.newTab().setText(subTitle));
        }
        mAdapter = new ProjectDockAdapter(getSupportFragmentManager());
        mViewpager.setAdapter(mAdapter);
        mViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTablayout));
        mOnTabSelectedListener = new TabLayout.OnTabSelectedListener() {
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

        };
        mTablayout.addOnTabSelectedListener(mOnTabSelectedListener);
    }

    @OnClick(R.id.filter)
    public void onClick() {
        Intent intent = new Intent(this, ProjectFilterActivity.class);
        startActivityForResult(intent, REQUEST_FILTER_PROJECT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_FILTER_PROJECT && resultCode == RESULT_OK){
            String projectName = data.getStringExtra("projectName");
            String projectType = data.getStringExtra("projectType");
            String projectSector = data.getStringExtra("projectSector");
            String releaseType = data.getStringExtra("releaseType");
            int selectedTabPosition = mTablayout.getSelectedTabPosition();
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            if (selectedTabPosition == 0){
                //处于项目推介
                ProjectRequireFragment fragment = (ProjectRequireFragment) fragments.get(0);
                fragment.onFilter(projectName, projectType, projectSector, releaseType);
            }else{
                //处于项目引进
                ProjectPromotionFragment fragment = (ProjectPromotionFragment) fragments.get(1);
                fragment.onFilter(projectName, projectType, projectSector, releaseType);
            }
        }
    }
}
