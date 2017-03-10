package com.qhzk.ciep.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.qhzk.ciep.R;
import com.qhzk.ciep.utils.TDevice;

/**
 * Created by pucheng on 2017/2/9.
 *
 */

public class BottomSheetBar {
    public static final String TAG = "BottomSheetBar";
    private View mRootView;
    private EditText mEditText;
    private AlertDialog mDialog;
    private Context mContext;
    private Button mBtnCommit;
    private FrameLayout mFrameLayout;


    private BottomSheetBar(Context context) {
        this.mContext = context;
    }


    public static BottomSheetBar delegation(Context context) {
        BottomSheetBar bar = new BottomSheetBar(context);
//        bar.mRootView = View.inflate(context, R.layout.layout_bottom_sheet_comment_bar, null);
        bar.mRootView = LayoutInflater.from(context).inflate(R.layout.layout_bottom_sheet_comment_bar, null, false);
        bar.initView();
        return bar;
    }

    @SuppressWarnings("deprecation")
    private void initView() {
        mFrameLayout = (FrameLayout) mRootView.findViewById(R.id.fl_face);
        mEditText = (EditText) mRootView.findViewById(R.id.et_comment);
        mBtnCommit = (Button) mRootView.findViewById(R.id.btn_comment);
        mBtnCommit.setEnabled(false);

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext, R.style.comment_dialog);
        builder.setView(mRootView);
        mDialog = builder.create();
        Window window = mDialog.getWindow();

        if (window != null) {
            window.setGravity(Gravity.BOTTOM);
            WindowManager m = window.getWindowManager();
            Display d = m.getDefaultDisplay();
            WindowManager.LayoutParams p = window.getAttributes();
            p.width = d.getWidth();
            window.setAttributes(p);
        }

        mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {

                mRootView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        TDevice.hideSoftKeyboard(mEditText);
                    }
                }, 10);
                mFrameLayout.setVisibility(View.GONE);
            }
        });

        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mBtnCommit.setEnabled(s.length() > 0);
            }
        });
    }

    public void show(String hint) {
        mDialog.show();
        if (!"添加评论".equals(hint)) {
            mEditText.setHint(hint + " ");
        }
        mRootView.postDelayed(new Runnable() {
            @Override
            public void run() {
                TDevice.showSoftKeyboard(mEditText);
            }
        }, 50);
    }

    /**
     * 默认显示的
     */
    public void setCommitListener(View.OnClickListener listener) {
        mBtnCommit.setOnClickListener(listener);
    }

    public EditText getEditText() {
        return mEditText;
    }

    public String getCommentText() {
        return mEditText.getText().toString().trim();
    }

    public Button getBtnCommit() {
        return mBtnCommit;
    }

}
