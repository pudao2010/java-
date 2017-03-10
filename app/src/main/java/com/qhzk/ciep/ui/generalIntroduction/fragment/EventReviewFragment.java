package com.qhzk.ciep.ui.generalIntroduction.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;
import com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.eventreview.AchievementFragment;
import com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.eventreview.ExhibitorlistFragment;
import com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.eventreview.RelateVideoFragment;

/**
 * Created by Administrator on 2016/12/14.
 * 往届回顾
 */

public class EventReviewFragment extends BaseFragment {

    private AchievementFragment mAchievementFragment;
    private RelateVideoFragment mRelateVideoFragment;
    private ExhibitorlistFragment mExhibitorlistFragment;
    private RadioGroup mTabContainer;
    private FragmentManager mFragmentManager;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_event_review;
    }

    @Override
    protected void initview() {
        super.initview();
        mTabContainer = (RadioGroup) mRootView.findViewById(R.id.radio_container);

        mFragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        mAchievementFragment = new AchievementFragment();
        mRelateVideoFragment = new RelateVideoFragment();
        mExhibitorlistFragment = new ExhibitorlistFragment();

        transaction
                .add(R.id.fragment_container, mAchievementFragment)
                .commit();
        mTabContainer.check(R.id.achieve_result);
        mTabContainer.setOnCheckedChangeListener(mOnCheckedChangeListener);
    }

    private RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            switch (checkedId) {
                case R.id.achieve_result:
                    if (! mAchievementFragment.isAdded()){
                        transaction.add(R.id.fragment_container, mAchievementFragment);
                    }
                    hideFragment(transaction);
                    transaction.show(mAchievementFragment);
                    break;
                case R.id.related_video:
                    if (! mRelateVideoFragment.isAdded()){
                        transaction.add(R.id.fragment_container, mRelateVideoFragment);
                    }
                    hideFragment(transaction);
                    transaction.show(mRelateVideoFragment);
                    break;
                case R.id.exhibitor_list:
                    if (! mExhibitorlistFragment.isAdded()){
                        transaction.add(R.id.fragment_container, mExhibitorlistFragment);
                    }
                    hideFragment(transaction);
                    transaction.show(mExhibitorlistFragment);
                    break;
            }
            transaction.commit();
        }
    };

    /**
     *  隐藏所有Fragment
     */
    public void hideFragment(FragmentTransaction transaction){

        if (mAchievementFragment != null){
            transaction.hide(mAchievementFragment);
        }
        if (mRelateVideoFragment != null){
            transaction.hide(mRelateVideoFragment);
        }
        if (mExhibitorlistFragment != null){
            transaction.hide(mExhibitorlistFragment);
        }
    }
}
