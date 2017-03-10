package com.qhzk.ciep.ui.home.attend.saveinfo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.qhzk.ciep.R;
import com.qhzk.ciep.config.Constant;
import com.qhzk.ciep.ui.home.attend.AttendActivity;
import com.qhzk.ciep.utils.SharedPrefUtil;
import com.qhzk.ciep.view.CountrySelectDialog;
import com.qhzk.ciep.widget.MineItemEdit;
import com.qhzk.ciep.widget.MineItemView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我要参会----填写个人信息
 * 2017年1月2日15:07:23
 */

public class SaveInfoFragment extends Fragment {


    @BindView(R.id.real_name)
    MineItemEdit mRealName;
    @BindView(R.id.woman)
    RadioButton mWoman;
    @BindView(R.id.man)
    RadioButton mMan;
    @BindView(R.id.layout_radio)
    RadioGroup mLayoutRadio;
    @BindView(R.id.country)
    MineItemView mCountry;
    @BindView(R.id.mobile)
    MineItemEdit mMobile;
    @BindView(R.id.email)
    MineItemEdit mEmail;

    public static SaveInfoFragment newInstance() {
        Bundle args = new Bundle();
        SaveInfoFragment fragment = new SaveInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    protected String TAG = getClass().getSimpleName();

    protected View mRootView;

    private AttendActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (AttendActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        if (mRootView == null) {
            mRootView = inflater.inflate(getLayoutId(), container, false);
        }
        ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    //校验用户信息是否输入完成,如果完成进入下一步
    public boolean checkUserInfo() {
        return !TextUtils.isEmpty(mRealName.getValue()) &&
                !TextUtils.isEmpty(mCountry.getValue()) &&
                !TextUtils.isEmpty(mMobile.getValue()) &&
                !TextUtils.isEmpty(mEmail.getValue());
    }

    @Override
    public void onStart() {
        super.onStart();
        getFromSharedPref();
    }

    protected int getLayoutId() {
        return R.layout.fragment_save_info;
    }

    /**
     * 保存到sharedpref中
     */
    private void saveToSharedPref() {
        SharedPrefUtil.savePrefString(this.getContext(), Constant.CHINESE_NAME, mRealName.getValue());
        int checkedRadioButtonId = mLayoutRadio.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.woman) {
            SharedPrefUtil.savePrefString(this.getContext(), Constant.GENDER, "女");
        } else {
            SharedPrefUtil.savePrefString(this.getContext(), Constant.GENDER, "男");
        }
        SharedPrefUtil.savePrefString(this.getContext(), Constant.COUNTRY, mCountry.getValue());
        SharedPrefUtil.savePrefString(this.getContext(), Constant.MOBILEPHONE, mMobile.getValue());
        SharedPrefUtil.savePrefString(this.getContext(), Constant.EMAIL, mEmail.getValue());
    }

    /**
     * 从SharedPref读取,回显
     */
    public void getFromSharedPref() {
        mRealName.setValue(SharedPrefUtil.getPrefString(this.getContext(), Constant.CHINESE_NAME, ""));
        String gender = SharedPrefUtil.getPrefString(this.getContext(), Constant.GENDER, "");
        if (gender.equals("女")) {
            mLayoutRadio.check(R.id.woman);
        } else {
            mLayoutRadio.check(R.id.man);
        }
        mCountry.setItemValue(SharedPrefUtil.getPrefString(this.getContext(), Constant.COUNTRY, ""));
        mMobile.setValue(SharedPrefUtil.getPrefString(this.getContext(), Constant.MOBILEPHONE, ""));
        mEmail.setValue(SharedPrefUtil.getPrefString(this.getContext(), Constant.EMAIL, ""));
    }

    @OnClick({R.id.country, R.id.next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.country:
                Dialog dialog = new CountrySelectDialog(this.getContext(), country -> mCountry.setItemValue(country));
                dialog.show();
                break;
            case R.id.next:
                if (checkUserInfo()) {
                    saveToSharedPref();
                    //保存在集合里面
                    AttendActivity activity = (AttendActivity) getActivity();
                    activity.mParmas.put("name", mRealName.getValue());
                    int checkedRadioButtonId = mLayoutRadio.getCheckedRadioButtonId();
                    if (checkedRadioButtonId == R.id.woman) {
                        activity.mParmas.put("gender", "女");
                    } else {
                        activity.mParmas.put("gender", "男");
                    }
                    activity.mParmas.put("nationality", mCountry.getValue());
                    activity.mParmas.put("phoneNum", mMobile.getValue());
                    activity.mParmas.put("email", mEmail.getValue());
                    mActivity.toStep2();
                } else {
                    Toast.makeText(this.getContext(), "请完善个人信息", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

}
