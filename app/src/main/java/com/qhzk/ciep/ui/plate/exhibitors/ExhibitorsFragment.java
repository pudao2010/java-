package com.qhzk.ciep.ui.plate.exhibitors;

import android.os.Bundle;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;

/**
 * Created by Thisdk on 2016/9/12.
 */

public class ExhibitorsFragment extends BaseFragment {

    public static ExhibitorsFragment newInstance() {
        Bundle args = new Bundle();
        ExhibitorsFragment fragment = new ExhibitorsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_exhibitors;
    }

}
