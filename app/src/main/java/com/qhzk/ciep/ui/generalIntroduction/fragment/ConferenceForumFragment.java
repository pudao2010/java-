package com.qhzk.ciep.ui.generalIntroduction.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;
import com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.forum.ForumAgendaFragment;
import com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.forum.ForumInfoFragment;

/**
 * Created by Administrator on 2016/12/14.
 * 大会论坛
 */

public class ConferenceForumFragment extends BaseFragment {

    private ForumInfoFragment mForumInfoFragment;
    private ForumAgendaFragment mForumAgendaFragment;
    private FragmentManager mFragmentManager;
    private RadioGroup mTabContainer;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_conference_forum;
    }

    @Override
    protected void initview() {
        super.initview();
        mTabContainer = (RadioGroup) mRootView.findViewById(R.id.radio_container);

        mFragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        mForumInfoFragment = new ForumInfoFragment();
        mForumAgendaFragment = new ForumAgendaFragment();

        transaction
                .add(R.id.fragment_container, mForumInfoFragment)
                .commit();
        mTabContainer.check(R.id.forum_info);
        mTabContainer.setOnCheckedChangeListener(mOnCheckedChangeListener);
    }

    private RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            switch (checkedId) {
                case R.id.forum_info:
                    if (! mForumInfoFragment.isAdded()){
                        transaction.add(R.id.fragment_container, mForumInfoFragment);
                    }
                    hideFragment(transaction);
                    transaction.show(mForumInfoFragment);
                    break;
                case R.id.forum_agenda:
                    if (! mForumAgendaFragment.isAdded()){
                        transaction.add(R.id.fragment_container, mForumAgendaFragment);
                    }
                    hideFragment(transaction);
                    transaction.show(mForumAgendaFragment);
                    break;
            }
            transaction.commit();
        }
    };

    /**
     *  隐藏所有Fragment
     */
    public void hideFragment(FragmentTransaction transaction){

        if (mForumInfoFragment != null){
            transaction.hide(mForumInfoFragment);
        }
        if (mForumAgendaFragment != null){
            transaction.hide(mForumAgendaFragment);
        }
    }
}
