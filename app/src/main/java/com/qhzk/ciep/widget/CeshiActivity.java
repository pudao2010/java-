package com.qhzk.ciep.widget;

import android.app.Dialog;
import android.view.View;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.view.BirthdayDialog;
import com.qhzk.ciep.view.CountrySelectDialog;

import butterknife.BindView;
import butterknife.OnClick;

public class CeshiActivity extends BaseActivity {

    @BindView(R.id.birthday)
    MineItemView mBirthday;
    @BindView(R.id.country)
    MineItemView mCountry;
    @BindView(R.id.desc)
    MineItemEdit mDesc;

    @Override
    public int getLayoutId() {
        return R.layout.activity_ceshi;
    }

    @OnClick({R.id.birthday, R.id.country})
    public void onClick(View view) {
        Dialog dialog;
        switch (view.getId()) {
            case R.id.birthday:
                dialog = new BirthdayDialog(this, birth -> mBirthday.setItemValue(birth));
                dialog.show();
                break;
            case R.id.country:
                dialog = new CountrySelectDialog(this, country -> mCountry.setItemValue(country));
                dialog.show();
                break;
        }
    }
}
