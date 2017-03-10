package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.exhibitionguide;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;

/**
 * Created by Administrator on 2016/12/14.
 * 参展指南(参会指南, 参展指南, 媒体指南)
 */

public class ExhibitionGuideFragment extends BaseFragment {

    private RadioGroup mTabContainer;
    private FragmentManager mFragmentManager;

    private UnitGuideFragment mUnitGuideFragment;
    private PersonalGuideFragment mPersonalGuideFragment;
//    private MediaGuideFragment mMediaGuideFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_exhibition_guide;
    }

    @Override
    protected void initview() {
        super.initview();
        mTabContainer = (RadioGroup) mRootView.findViewById(R.id.radio_container);
        mUnitGuideFragment = new UnitGuideFragment();
        mPersonalGuideFragment = new PersonalGuideFragment();
//        mMediaGuideFragment = new MediaGuideFragment();

        mFragmentManager = getChildFragmentManager();
        mFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, mPersonalGuideFragment) //TODO 添加默认
                .commit();
        mTabContainer.check(R.id.personal_guide);
        mTabContainer.setOnCheckedChangeListener(mOnCheckedChangeListener);
    }

    private RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            switch (checkedId) {
                    case R.id.personal_guide:
                        if (! mPersonalGuideFragment.isAdded()){
                            transaction.add(R.id.fragment_container, mPersonalGuideFragment);
                        }
                        hideFragment(transaction);
                        transaction.show(mPersonalGuideFragment);
                        break;
                    case R.id.exhibition_guide:
                        if (! mUnitGuideFragment.isAdded()){
                            transaction.add(R.id.fragment_container, mUnitGuideFragment);
                        }
                        hideFragment(transaction);
                        transaction.show(mUnitGuideFragment);
                        break;
                    // 去掉媒体指南
//                    case R.id.media_guide:
//                        if (! mMediaGuideFragment.isAdded()){
//                            transaction.add(R.id.fragment_container, mMediaGuideFragment);
//                        }
//                        hideFragment(transaction);
//                        transaction.show(mMediaGuideFragment);
//                        break;
                }
            transaction.commit();
        }
    };
    //隐藏所有的fragment
    private void hideFragment(FragmentTransaction transaction){

        if(mUnitGuideFragment != null){
            transaction.hide(mUnitGuideFragment);
        }
        if(mPersonalGuideFragment != null){
            transaction.hide(mPersonalGuideFragment);
        }

//        if (mMediaGuideFragment != null){
//            transaction.hide(mMediaGuideFragment);
//        }
    }

}
