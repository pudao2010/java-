package com.qhzk.ciep.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

import com.qhzk.ciep.ui.home.new_center.conference_video.ConferenceVideoFragment;
import com.qhzk.ciep.ui.home.new_center.the_news.TheNewsFragment;
import com.qhzk.ciep.ui.home.new_center.trade_news.TradeNewsFragment;
import com.qhzk.ciep.ui.home.new_center.unit_dynamic.UnitDynamicFragment;

/**
 * Created by Thisdk on 2016/8/31.
 */

public class NewCenterFrameAdapter extends FragmentPagerAdapter {

    private SparseArray<Fragment> mFragments;

    public NewCenterFrameAdapter(FragmentManager fm) {
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
                    fragment = new TheNewsFragment();
                    break;
                case 1:
                    fragment = new TradeNewsFragment();
                    break;
                case 2:
                    fragment = new UnitDynamicFragment();
                    break;
                case 3:
                    fragment = new ConferenceVideoFragment();
                    break;
            }
            mFragments.put(position, fragment);
        }
        return fragment;
    }

}
