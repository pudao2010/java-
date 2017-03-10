package com.qhzk.ciep.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

import com.qhzk.ciep.ui.home.HomeFragment;
import com.qhzk.ciep.ui.mine.MineFragment;
import com.qhzk.ciep.ui.plate.PlateFragment;
import com.qhzk.ciep.ui.tickets.TicketsFragment;

/**
 * Created by Thisdk on 2016/8/31.
 */

public class MainFrameAdapter extends FragmentPagerAdapter {

    private SparseArray<Fragment> mFragments;

    public MainFrameAdapter(FragmentManager fm) {
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
                    fragment = new HomeFragment();
                    break;
                case 1:
                    fragment = new PlateFragment();
                    break;
                case 2:
                    fragment = new TicketsFragment();
                    break;
                case 3:
                    fragment = new MineFragment();
                    break;
            }
            mFragments.put(position, fragment);
        }
        return fragment;
    }

}
