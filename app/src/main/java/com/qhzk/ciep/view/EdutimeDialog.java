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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 2016年12月27日14:42:44
 * 教育起止时间
 */

public class EdutimeDialog extends Dialog {

    @BindView(R.id.wheelview_fromyear)
    WheelView mWheelviewFromyear;
    @BindView(R.id.wheelview_frommonth)
    WheelView mWheelviewFrommonth;
    @BindView(R.id.wheelview_endyear)
    WheelView mWheelviewEndyear;
    @BindView(R.id.wheelview_endmonth)
    WheelView mWheelviewEndmonth;
    private ArrayList<String> mYears = new ArrayList<>();
    private ArrayList<String> mMonths = new ArrayList<>();

    public EdutimeDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public EdutimeDialog(Context context, OnEdutimeSelectListener l) {
        this(context, R.style.Theme_Light_Dialog);
        mOnEdutimeSelectListener = l;
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_edutime, null);
        ButterKnife.bind(this, view);
        for (int i = 1949; i < 2016; i++) {
            mYears.add(i+"年");
        }
        for (int i = 1; i <= 12; i++) {
            if (i<10){
                mMonths.add("0"+i+"月");
            } else{
                mMonths.add(i+"月");
            }
        }
        mWheelviewFromyear.setData(mYears);
        mWheelviewFromyear.setDefault(50);
        mWheelviewFrommonth.setData(mMonths);
        mWheelviewFrommonth.setDefault(8);
        mWheelviewEndyear.setData(mYears);
        mWheelviewEndyear.setDefault(50);
        mWheelviewEndmonth.setData(mMonths);
        mWheelviewEndmonth.setDefault(6);
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
                String fromYear = mWheelviewFromyear.getSelectedText();
                // 去掉"年"
                fromYear = fromYear.replace("年", "");
                String fromMonth = mWheelviewFrommonth.getSelectedText();
                // 去掉"月"
                fromMonth = fromMonth.replace("月","");
                String endYear = mWheelviewEndyear.getSelectedText();
                // 去掉"年"
                endYear = endYear.replace("年","");
                String endMonth = mWheelviewEndmonth.getSelectedText();
                // 去掉"月"
                endMonth = endMonth.replace("月", "");
                StringBuilder sb = new StringBuilder();
                sb.append(fromYear)
                        .append("-")
                        .append(fromMonth)
                        .append("-01")
                        .append("至")
                        .append(endYear)
                        .append("-")
                        .append(endMonth)
                        .append("-01");
                String edutime = sb.toString();
                if (mOnEdutimeSelectListener != null) {
                    mOnEdutimeSelectListener.onSelect(edutime);
                }
                dismiss();
                break;
        }
    }

    public interface OnEdutimeSelectListener {
        void onSelect(String birth);
    }

    private OnEdutimeSelectListener mOnEdutimeSelectListener;
}
