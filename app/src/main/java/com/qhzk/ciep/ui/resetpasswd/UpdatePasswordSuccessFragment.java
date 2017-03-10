package com.qhzk.ciep.ui.resetpasswd;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/12/14.
 * 修改密码成功页面
 */

public class UpdatePasswordSuccessFragment extends BaseFragment {

    @BindView(R.id.icon)
    ImageView mIcon;
    @BindView(R.id.tv_update_password)
    TextView mTvUpdatePassword;
    @BindView(R.id.btn_update_finish)
    Button mBtnUpdateFinish;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_updatepassword_success;
    }

    @OnClick(R.id.btn_update_finish)
    public void onClick() {
        this.getActivity().finish();
    }
}
