package com.qhzk.ciep.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qhzk.ciep.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/12/13.
 * 年月日的滚轮控件,选择出生年月 2016年12月20日14:23:27
 */

public class BirthdayDialog extends Dialog {

    @BindView(R.id.wheelview_year)
    WheelView mWheelviewYear;
    @BindView(R.id.wheelview_month)
    WheelView mWheelviewMonth;
    @BindView(R.id.wheelview_day)
    WheelView mWheelviewDay;
    @BindView(R.id.cancel)
    TextView mCancel;
    @BindView(R.id.confirm)
    TextView mConfirm;
    @BindView(R.id.content_container)
    LinearLayout mContentContainer;

    private ArrayList<String> mYears = new ArrayList<>();
    private ArrayList<String> mMonths = new ArrayList<>();
    private ArrayList<String> mDays = new ArrayList<>();

    public BirthdayDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public BirthdayDialog(Context context, OnBirthSelectListener l) {
        this(context, R.style.Theme_Light_Dialog);
        mOnBirthSelectListener = l;
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_birthday, null);
        ButterKnife.bind(this, view);

        for (int i = 1970; i <= 2016; i++) {
            mYears.add(i+"年");
        }
        for (int i = 1; i < 13; i++) {
            mMonths.add(i+"月");
        }
        for (int i = 1; i < 32; i++) {
            mDays.add(i+"日");
        }
        mWheelviewYear.setData(mYears);
        mWheelviewYear.setDefault(25);
        mWheelviewMonth.setData(mMonths);
        mWheelviewMonth.setDefault(5);
        mWheelviewDay.setData(mDays);
        mWheelviewDay.setDefault(14);
        initWindow();
        setContentView(view);
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
                StringBuilder sb = new StringBuilder();
                String year = mWheelviewYear.getSelectedText();
                year = year.substring(0, year.length()-1);
                sb.append(year);

                String month = mWheelviewMonth.getSelectedText();
                month = month.substring(0, month.length()-1);
                if (Integer.parseInt(month)<10){
                    sb.append("0").append(month);
                }else{
                    sb.append(month);
                }
                String day = mWheelviewDay.getSelectedText();
                day = day.substring(0, day.length()-1);
                if (Integer.parseInt(day)<10){
                    sb.append("0").append(day);
                }else{
                    sb.append(day);
                }
                sb.insert(4, "-").insert(7, "-");
                String s = sb.toString();
                if (mOnBirthSelectListener != null) {
                    mOnBirthSelectListener.onSelect(s);
                }
                dismiss();
                break;
        }
    }

    public interface OnBirthSelectListener{
        void onSelect(String birth);
    }

    private OnBirthSelectListener mOnBirthSelectListener;
}
