package com.qhzk.ciep.ui.generalIntroduction.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;
import com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.meetingservice.ExhibitionTipFragment;
import com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.meetingservice.RecommendHotelFragment;
import com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.meetingservice.TrafficGuideFragment;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/14.
 * 大会服务(参展手册, 推荐酒店, 交通指南)
 */

public class ConferenceServiceFragment extends BaseFragment {

    @BindView(R.id.radio_container)
    RadioGroup mRadioContainer;
    private FragmentManager mFragmentManager;
    private ExhibitionTipFragment mExhibitionTipFragment;
    private RecommendHotelFragment mRecommendHotelFragment;
    private TrafficGuideFragment mTrafficGuideFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_conference_service;
    }

    @Override
    protected void initview() {
        super.initview();
        mFragmentManager = getChildFragmentManager();
        mExhibitionTipFragment = new ExhibitionTipFragment();
        mRecommendHotelFragment = new RecommendHotelFragment();
        mTrafficGuideFragment = new TrafficGuideFragment();
        mFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, mExhibitionTipFragment)
                .commit();

        mRadioContainer.check(R.id.exhibition_tip);
    }

    @Override
    protected void initdata() {
        super.initdata();
        mRadioContainer.setOnCheckedChangeListener(mOnCheckedChangeListener);
    }

    private RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = (radioGroup, checkedId) -> {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        switch (checkedId) {
            case R.id.exhibition_tip:
                if (! mExhibitionTipFragment.isAdded()){
                    transaction.add(R.id.fragment_container, mExhibitionTipFragment);
                }
                hideFragment(transaction);
                transaction.show(mExhibitionTipFragment);
                break;
            case R.id.recommend_hotel:
                if (! mRecommendHotelFragment.isAdded()){
                    transaction.add(R.id.fragment_container, mRecommendHotelFragment);
                }
                hideFragment(transaction);
                transaction.show(mRecommendHotelFragment);
                break;
            case R.id.traffic_guide:
                if (! mTrafficGuideFragment.isAdded()){
                    transaction.add(R.id.fragment_container, mTrafficGuideFragment);
                }
                hideFragment(transaction);
                transaction.show(mTrafficGuideFragment);
                break;
        }
        transaction.commit();
    };

    //隐藏所有的fragment
    private void hideFragment(FragmentTransaction transaction){

        if(mExhibitionTipFragment != null){
            transaction.hide(mExhibitionTipFragment);
        }
        if(mRecommendHotelFragment != null){
            transaction.hide(mRecommendHotelFragment);
        }
        if (mTrafficGuideFragment != null){
            transaction.hide(mTrafficGuideFragment);
        }
    }
}
