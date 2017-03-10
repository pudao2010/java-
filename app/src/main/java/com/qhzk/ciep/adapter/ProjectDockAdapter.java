package com.qhzk.ciep.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;

import com.qhzk.ciep.ui.projectdock.fragment.ProjectPromotionFragment;
import com.qhzk.ciep.ui.projectdock.fragment.ProjectRequireFragment;

/**
 * Created by Administrator on 2016/12/14.
 * 项目对接的viewpager适配
 */

public class ProjectDockAdapter extends FragmentStatePagerAdapter {

    private SparseArray<Fragment> mFragments;

    public ProjectDockAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new SparseArray<>();
    }

    @Override
    public Fragment getItem(int position) {
        return getFragmentByPosition(position);
    }

    private Fragment getFragmentByPosition(int position) {
        Fragment fragment = mFragments.get(position);
        if (fragment == null){
            switch (position){
                case 0:
                    fragment = new ProjectRequireFragment();
                    break;
                case 1:
                    fragment = new ProjectPromotionFragment();
                    break;
            }
            mFragments.put(position, fragment);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
