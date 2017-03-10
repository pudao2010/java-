package com.qhzk.ciep.ui.plate.forum;

import android.os.Bundle;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;

/**
 * Created by Thisdk on 2016/9/12.
 * 大会论坛
 */

public class ForumFragment extends BaseFragment {

    public static ForumFragment newInstance() {
        Bundle args = new Bundle();
        ForumFragment fragment = new ForumFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_forum;
    }
}
