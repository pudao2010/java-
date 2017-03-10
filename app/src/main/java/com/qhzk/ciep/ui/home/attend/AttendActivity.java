package com.qhzk.ciep.ui.home.attend;

import android.support.v4.app.Fragment;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.ui.home.attend.plate.SelPlateFragment;
import com.qhzk.ciep.ui.home.attend.saveinfo.SaveInfoFragment;
import com.qhzk.ciep.ui.home.attend.unit_edu.UnitEduFragment;

import java.util.HashMap;

/**
 * Created by QixiongYuan on 2016/12/9.
 * 我要参会Activity
 */

public class AttendActivity extends BaseActivity {
    public HashMap<String, String> mParmas = new HashMap<>();
    private SaveInfoFragment mStep1Fragment;
    private UnitEduFragment mStep2Fragment;
    private Fragment mStep3Fragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_attend;
    }

    @Override
    protected void initview() {
        super.initview();
        mStep1Fragment = new SaveInfoFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mStep1Fragment, mStep1Fragment.getClass().getName())
                .commit();
        mToolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    protected void initdata() {
        super.initdata();
    }

    public void toStep2() {
        mStep2Fragment = new UnitEduFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, mStep2Fragment, "step2")
                .addToBackStack(null)
                .commit();
    }

    public void toStep3() {
        mStep3Fragment = new SelPlateFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, mStep3Fragment, "step3")
                .addToBackStack(null)
                .commit();
    }

}
