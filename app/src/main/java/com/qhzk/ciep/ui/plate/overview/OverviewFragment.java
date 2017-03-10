package com.qhzk.ciep.ui.plate.overview;

import android.os.Bundle;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;

/**
 * Created by Thisdk on 2016/9/12.
 */

public class OverviewFragment extends BaseFragment {

    public static OverviewFragment newInstance() {
        Bundle args = new Bundle();
        OverviewFragment fragment = new OverviewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_overview;
    }

}
