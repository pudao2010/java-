package com.qhzk.ciep.ui.tickets;

import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;
import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;
import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.entity.UserInfo;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Thisdk on 2016/8/31.
 * 我的展票
 */

public class TicketsFragment extends BaseFragment<TicketsPresenter> implements TicketsView {

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.username)
    TextView mUsername;
    @BindView(R.id.country)
    TextView mCountry;
    @BindView(R.id.card_ticket)
    RelativeLayout mCardTicket;
    private ImageView qrCode;
    private MaterialDialog dialog;
    private View qrCodeDialog;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tickets;
    }

    @Override
    protected void initview() {
        super.initview();
        qrCodeDialog = View.inflate(this.getContext(), R.layout.tickets_qrcode_dialog_layout, null);
        mSwipeRefreshLayout.setOnRefreshListener(() -> mFragmentPresenter.getUserInfo());
        mSwipeRefreshLayout.setColorSchemeResources(
                R.color.swiperefresh_color1, R.color.swiperefresh_color2,
                R.color.swiperefresh_color3, R.color.swiperefresh_color4);
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        int stateBarHeight = getResources().getDimensionPixelSize(resourceId);
        AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) mToolbar.getLayoutParams();
        layoutParams.setMargins(0, stateBarHeight, 0, 0);
        mToolbar.setLayoutParams(layoutParams);
    }

    @Override
    protected void initdata() {
        super.initdata();
        mFragmentPresenter.getUserInfo();
    }

    @Override
    public void showErrorInfo(String msg) {
        super.showErrorInfo(msg);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    public void callDialog() {
        if (dialog == null) {
            dialog = new MaterialDialog.Builder(getContext())
                    .customView(qrCodeDialog, false).build();
        }
        dialog.show();
    }

    @Override
    public void onLoadUserInfoSuccess(UserInfo userInfo) {
        mSwipeRefreshLayout.setRefreshing(false);
        if (userInfo != null) {
            String name = userInfo.getName();
            if (!TextUtils.isEmpty(name)) {
                mCardTicket.setVisibility(View.VISIBLE);
                mUsername.setText(name);
            }
            String nationality = userInfo.getNationality();
            if (!TextUtils.isEmpty(nationality)) {
                mCountry.setText(nationality);
            }
            qrCode = (ImageView) qrCodeDialog.findViewById(R.id.img);
            Glide.with(this.getContext())
                    .load(ServiceConfig.BASE_QRCODE + userInfo.getId())
                    .into(qrCode);
        } else {
            showToast("没有您的展票信息");
        }

    }

    @OnClick(R.id.card_ticket)
    public void onClick() {
        callDialog();
    }
}
