package com.qhzk.ciep.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;

import com.qhzk.ciep.ui.datastatistics.fragment.AttendanceFragment;
import com.qhzk.ciep.ui.datastatistics.fragment.JobSearchFragment;
import com.qhzk.ciep.ui.datastatistics.fragment.ProjectStatisticsFragemnt;
import com.qhzk.ciep.ui.datastatistics.fragment.UnitStatisticsFragment;

/**
 * Created by Administrator on 2016/12/14.
 * 数据统计的viewpager适配
 */

public class DataStaticsAdapter extends FragmentStatePagerAdapter {

    private SparseArray<Fragment> mFragments;

    public DataStaticsAdapter(FragmentManager fm) {
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
                    fragment = new AttendanceFragment();
                    break;
                case 1:
                    fragment = new UnitStatisticsFragment();
                    break;
                case 2:
                    fragment = new JobSearchFragment();
                    break;
                case 3:
                    fragment = new ProjectStatisticsFragemnt();
                    break;
            }
            mFragments.put(position, fragment);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
