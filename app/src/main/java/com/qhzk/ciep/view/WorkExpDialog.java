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
 * 单位规模
 */

public class WorkExpDialog extends Dialog {

    private ArrayList<String> mExpectSalarys;
    private WheelView mWheelView;

    public WorkExpDialog(Context context, OnSelectListener l) {
        this(context, R.style.Theme_Light_Dialog);
        mOnCountrySelectListener = l;
    }

    public WorkExpDialog(Context context, int themeResId) {
        super(context, R.style.Theme_Light_Dialog);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.country_select, null);
        ButterKnife.bind(this, view);
        mWheelView = (WheelView) view.findViewById(R.id.wheelview_country);
        String[] expectSalary = context.getResources().getStringArray(R.array.workyear);
        mExpectSalarys = new ArrayList<>();
        for (int i = 0; i < expectSalary.length; i++) {
            mExpectSalarys.add(expectSalary[i]);
        }
        mWheelView.setData(mExpectSalarys);
        mWheelView.setDefault(0);
        initWindow();
        setContentView(view);
        setCanceledOnTouchOutside(true);
    }

    private void initWindow() {
        //设置dialog在屏幕底部
        Window window = getWindow();
        if (window != null) {
            window.setGravity(Gravity.BOTTOM);
        }
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
                String entsize = mWheelView.getSelectedText();
                if (mOnCountrySelectListener != null) {
                    mOnCountrySelectListener.onCountrySelect(entsize);
                }
                dismiss();
                break;
        }
    }

    public interface OnSelectListener {
        void onCountrySelect(String entsize);
    }

    private OnSelectListener mOnCountrySelectListener;

}
