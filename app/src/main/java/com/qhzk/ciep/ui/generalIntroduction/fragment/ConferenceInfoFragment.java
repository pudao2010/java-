package com.qhzk.ciep.ui.generalIntroduction.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;
import com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.MeetingInfoFragment;
import com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.activity.ActivityFragment;
import com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.agenda.AgendaFragment;
import com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.commend.CommendFragment;
import com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.exhibitionmap.ExhibitionMapFragment;

/**
 * Created by Administrator on 2016/12/14.
 * 大会总体介绍
 */

public class ConferenceInfoFragment extends BaseFragment {

    private FragmentManager mFragmentManager;
    private MeetingInfoFragment mMeetingInfoFragment;
    private CommendFragment mCommendFragment;
    private AgendaFragment mAgendaFragment;
    private ActivityFragment mActivityFragment;
    private ExhibitionMapFragment mExhibitionMapFragment;
    private RadioGroup mTabContainer;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_conference_info;
    }

    @Override
    protected void initview() {
        super.initview();
        mTabContainer = (RadioGroup) mRootView.findViewById(R.id.radio_container);
        mFragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        mMeetingInfoFragment = new MeetingInfoFragment();
        mCommendFragment = new CommendFragment();
        mAgendaFragment = new AgendaFragment();
        mActivityFragment = new ActivityFragment();
        mExhibitionMapFragment = new ExhibitionMapFragment();

        transaction
                .add(R.id.fragment_container, mMeetingInfoFragment)
                .commit();
        mTabContainer.check(R.id.conference_info);
    }

    @Override
    protected void initdata() {
        super.initdata();
        mTabContainer.setOnCheckedChangeListener(mOnCheckedChangeListener);
    }

    private RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            switch (checkedId) {
                case R.id.conference_info:
                    // 会议介绍
                    if (! mMeetingInfoFragment.isAdded()){
                        transaction.add(R.id.fragment_container, mMeetingInfoFragment);
                    }
                    hideFragment(transaction);
                    transaction.show(mMeetingInfoFragment);
                    break;
                case R.id.conference_commend:
                    // 签约表彰
                    if (! mCommendFragment.isAdded()){
                        transaction.add(R.id.fragment_container, mCommendFragment);
                    }
                    hideFragment(transaction);
                    transaction.show(mCommendFragment);
                    break;
                case R.id.exhibition_map:
                    // 展馆规划图
                    if (! mExhibitionMapFragment.isAdded()){
                        transaction.add(R.id.fragment_container, mExhibitionMapFragment);
                    }
                    hideFragment(transaction);
                    transaction.show(mExhibitionMapFragment);
                    break;
                case R.id.main_agenda:
                    // 主要日程
                    if (! mAgendaFragment.isAdded()){
                        transaction.add(R.id.fragment_container, mAgendaFragment);
                    }
                    hideFragment(transaction);
                    transaction.show(mAgendaFragment);
                    break;
                case R.id.main_activity:
                    // 主要活动
                    if (! mActivityFragment.isAdded()){
                        transaction.add(R.id.fragment_container, mActivityFragment);
                    }
                    hideFragment(transaction);
                    transaction.show(mActivityFragment);
                    break;
            }
            transaction.commit();
        }
    };

    //隐藏所有的fragment
    private void hideFragment(FragmentTransaction transaction){

        if(mMeetingInfoFragment != null){
            transaction.hide(mMeetingInfoFragment);
        }
        if(mCommendFragment != null){
            transaction.hide(mCommendFragment);
        }

        if (mAgendaFragment != null){
            transaction.hide(mAgendaFragment);
        }

        if (mActivityFragment != null){
            transaction.hide(mActivityFragment);
        }

        if (mExhibitionMapFragment != null){
            transaction.hide(mExhibitionMapFragment);
        }
    }
}
