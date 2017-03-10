package com.qhzk.ciep.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.qhzk.ciep.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/12/26.
 * 删除项目
 */

public class DeleteDialog extends Dialog {


    public DeleteDialog(Context context, OnDeleteListener l) {
        this(context, R.style.Theme_Light_Dialog);
        listener = l;
    }

    public DeleteDialog(Context context, int themeResId) {
        super(context, R.style.Theme_Light_Dialog);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_delete, null);
        ButterKnife.bind(this, view);
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

    @OnClick({R.id.cancel, R.id.delete})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel:
                dismiss();
                break;
            case R.id.delete:
                if (listener != null) {
                    listener.onDelete();
                }
                dismiss();
                break;
        }
    }

    public interface OnDeleteListener{

        void onDelete();
    }

    private OnDeleteListener listener;



}
