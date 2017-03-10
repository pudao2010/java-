package com.qhzk.ciep.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.qhzk.ciep.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/12/26.
 * 国籍选择
 */

public class CountrySelectDialog extends Dialog {

    private ArrayList<String> mCountrys;
    private WheelView mWheelViewCountry;

    public CountrySelectDialog(Context context, OnCountrySelectListener l) {
        this(context, R.style.Theme_Light_Dialog);
        mOnCountrySelectListener = l;
    }

    public CountrySelectDialog(Context context, int themeResId) {
        super(context, R.style.Theme_Light_Dialog);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.country_select, null);
        ButterKnife.bind(this, view);
        mWheelViewCountry = (WheelView) view.findViewById(R.id.wheelview_country);
        String[] countryArray = context.getResources().getStringArray(R.array.state);
        mCountrys = new ArrayList<>();
        for (int i = 0; i < countryArray.length; i++) {
            mCountrys.add(countryArray[i]);
        }
        mWheelViewCountry.setData(mCountrys);
        mWheelViewCountry.setDefault(0);
        initWindow();
        setContentView(view);
        setCanceledOnTouchOutside(true);
    }

    private void initWindow() {
        //设置dialog在屏幕底部
        Window window = getWindow();
        window.setGravity(Gravity.BOTTOM);
        //设置dialog弹出时的动画效果，从屏幕底部向上弹出
        window.setWindowAnimations(R.style.dialogStyle);
        window.getDecorView().setPadding(0, 0, 0, 0);
        //获得window窗口的属性
        WindowManager.LayoutParams lp = window.getAttributes();
        //设置窗口宽度为充满全屏
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        //设置窗口高度为包裹内容
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //将设置好的属性set回去
        window.setAttributes(lp);
    }

    @OnClick({R.id.cancel, R.id.confirm})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel:
                dismiss();
                break;
            case R.id.confirm:
                String country = mWheelViewCountry.getSelectedText();
                if (mOnCountrySelectListener != null) {
                    mOnCountrySelectListener.onCountrySelect(country);
                }
                dismiss();
                break;
        }
    }

    public interface OnCountrySelectListener{
        void onCountrySelect(String country);
    }

    private OnCountrySelectListener mOnCountrySelectListener;

}
