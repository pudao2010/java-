package com.qhzk.ciep.widget;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.ui.login.LoginActivity;

/**
 * Created by pucheng on 2017/2/9.
 * 底部评论条 , 单例设计
 */

public class CommentBar {
    private Context mContext;
    private View mRootView;
    private ViewGroup mParent;
    private ImageButton mShareView;
    private TextView mCommentText;
    private BottomSheetBar mDelegation;
    private LinearLayout mCommentLayout;


    private CommentBar(Context context) {
        this.mContext = context;
    }

    public static CommentBar delegation(Context context, ViewGroup parent) {
        CommentBar bar = new CommentBar(context);
        bar.mRootView = LayoutInflater.from(context).inflate(R.layout.layout_comment_bar, parent, false);
        bar.mParent = parent;
        bar.mDelegation = BottomSheetBar.delegation(context);
        bar.mParent.addView(bar.mRootView);
        bar.initView();
        return bar;
    }

    public void hideCommentBar(){
        mRootView.setVisibility(View.GONE);
    }

    public void showCommentBar(){
        mRootView.setVisibility(View.VISIBLE);
    }

    private void initView() {
        mShareView = (ImageButton) mRootView.findViewById(R.id.ib_share);
        mCommentText = (TextView) mRootView.findViewById(R.id.tv_comment);
        mCommentLayout = (LinearLayout) mRootView.findViewById(R.id.ll_comment);
        mCommentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLogin()) {
                    mDelegation.show(mCommentText.getHint().toString());
                } else {
                    Intent intent = new Intent(mContext, LoginActivity.class);
                    mContext.startActivity(intent);
                }
            }
        });
    }
    //TODO
    private boolean isLogin() {
//        String user = SharedPrefUtil.getPrefString(mContext, Constant.LOGIN_USER, "");
//        String password = SharedPrefUtil.getPrefString(mContext, Constant.LOGIN_PASSWORD, "");
//        return !TextUtils.isEmpty(user) && !TextUtils.isEmpty(password);
        return true;
    }

    /**
     * share 2 three sdk
     *
     * @param listener
     */
    public void setShareListener(View.OnClickListener listener) {
        mShareView.setOnClickListener(listener);
    }

    public void setCommentListener(View.OnClickListener listener) {
        mCommentText.setOnClickListener(listener);
    }

    public void setCommentHint(String text) {
        mCommentText.setHint(text);
    }


    public BottomSheetBar getBottomSheet() {
        return mDelegation;
    }

    public void setCommitButtonEnable(boolean enable) {
        mDelegation.getBtnCommit().setEnabled(enable);
    }

    public void hideShare() {
        mShareView.setVisibility(View.GONE);
    }

    public TextView getCommentText() {
        return mCommentText;
    }


    public void performClick() {
        mCommentLayout.performClick();
    }
}
