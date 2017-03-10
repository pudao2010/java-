package com.qhzk.ciep.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

import com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.boothbuild.BoothbuildFragment;
import com.qhzk.ciep.ui.generalIntroduction.fragment.ConferenceForumFragment;
import com.qhzk.ciep.ui.generalIntroduction.fragment.ConferenceInfoFragment;
import com.qhzk.ciep.ui.generalIntroduction.fragment.ConferenceServiceFragment;
import com.qhzk.ciep.ui.generalIntroduction.fragment.EventReviewFragment;
import com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.exhibitionguide.ExhibitionGuideFragment;
import com.qhzk.ciep.ui.generalIntroduction.fragment.UnitListFragment;

/**
 * Created by Administrator on 2016/12/14.
 * 大会介绍的viewpager适配
 */

public class GeneralIntroAdapter extends FragmentPagerAdapter {

    private SparseArray<Fragment> mFragments;

    public GeneralIntroAdapter(FragmentManager fm) {
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
                    fragment = new ConferenceInfoFragment();
                    break;
                case 1:
                    fragment = new ConferenceForumFragment();
                    break;
                case 2:
                    fragment = new ExhibitionGuideFragment();
                    break;
                case 3:
                    fragment = new BoothbuildFragment();
                    break;
                case 4:
                    fragment = new ConferenceServiceFragment();
                    break;
                case 5:
                    fragment = new UnitListFragment();
                    break;
                case 6:
                    fragment = new EventReviewFragment();
                    break;
            }
            mFragments.put(position, fragment);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 7;
    }
}
