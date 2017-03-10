package com.qhzk.ciep.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

import com.qhzk.ciep.ui.plate.booth.BoothFragment;
import com.qhzk.ciep.ui.plate.exhibitors.ExhibitorsFragment;
import com.qhzk.ciep.ui.plate.forum.ForumFragment;
import com.qhzk.ciep.ui.plate.overview.OverviewFragment;

/**
 * Created by Thisdk on 2016/8/31.
 */

public class PlateFrameAdapter extends FragmentPagerAdapter {

    private SparseArray<Fragment> mFragments;

    public PlateFrameAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new SparseArray<Fragment>();
    }

    @Override
    public Fragment getItem(int position) {
        return getFragment(position);
    }

    @Override
    public int getCount() {
        return 4;
    }

    private Fragment getFragment(int position) {
        Fragment fragment = mFragments.get(position);
        if (fragment == null) {
            switch (position) {
                case 0:
                    fragment = new OverviewFragment();
                    break;
                case 1:
                    fragment = new ExhibitorsFragment();
                    break;
                case 2:
                    fragment = new BoothFragment();
                    break;
                case 3:
                    fragment = new ForumFragment();
                    break;
            }
            mFragments.put(position, fragment);
        }
        return fragment;
    }

}
