package com.qhzk.ciep.ui.plate.booth;

import android.os.Bundle;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;

/**
 * Created by Thisdk on 2016/9/12.
 */

public class BoothFragment extends BaseFragment {

    public static BoothFragment newInstance() {
        Bundle args = new Bundle();
        BoothFragment fragment = new BoothFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_booth;
    }
}
