package com.qhzk.ciep.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

import com.qhzk.ciep.ui.search.news.NewsFragment;
import com.qhzk.ciep.ui.search.unit.UnitFragment;

/**
 * Created by Thisdk on 2016/8/31.
 */

public class SearchFrameAdapter extends FragmentPagerAdapter {

    private SparseArray<Fragment> mFragments;

    public SearchFrameAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new SparseArray<Fragment>();
    }

    @Override
    public Fragment getItem(int position) {
        return getFragment(position);
    }

    @Override
    public int getCount() {
        return 2;
    }

    private Fragment getFragment(int position) {
        Fragment fragment = mFragments.get(position);
        if (fragment == null) {
            switch (position) {
                case 0:
                    fragment = new UnitFragment();
                    break;
                case 1:
                    fragment = new NewsFragment();
                    break;
            }
            mFragments.put(position, fragment);
        }
        return fragment;
    }

}
