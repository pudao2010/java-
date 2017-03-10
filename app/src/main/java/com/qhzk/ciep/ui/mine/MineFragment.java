package com.qhzk.ciep.ui.mine;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;
import com.qhzk.ciep.config.Constant;
import com.qhzk.ciep.ui.login.LoginActivity;
import com.qhzk.ciep.ui.mine.attention.AttentionActivity;
import com.qhzk.ciep.ui.mine.data.MineData1Activity;
import com.qhzk.ciep.ui.mine.history.HistoryActivity;
import com.qhzk.ciep.ui.mine.job.MineJobActivity;
import com.qhzk.ciep.ui.mine.meeting.MeetingActivity;
import com.qhzk.ciep.ui.mine.message.MessageActivity;
import com.qhzk.ciep.ui.mine.project.MineProjectActivity;
import com.qhzk.ciep.ui.mine.setting.SettingActivity;
import com.qhzk.ciep.utils.SharedPrefUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Thisdk on 2016/8/31.
 * 主页的个人中心
 */

public class MineFragment extends BaseFragment {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.collapsingtoolbarlayout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initview() {
        super.initview();

        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        int stateBarHeight = getResources().getDimensionPixelSize(resourceId);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) mToolbar.getLayoutParams();
        layoutParams.setMargins(0, stateBarHeight, 0, 0);
        mToolbar.setLayoutParams(layoutParams);

    }


    @OnClick({R.id.mine_job, R.id.mine_project,R.id.toolbar_title,
            R.id.mine_data, R.id.mine_history, R.id.mine_setting,
            R.id.mine_attenttion, R.id.mine_meeting,R.id.contact_us,R.id.mine_message})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mine_job: //我的求职
                if(isLogin()){
                    readyGo(MineJobActivity.class);
                }else{
                    readyGo(LoginActivity.class);
                }
                break;
            case R.id.mine_project: //项目管理
                if (isLogin()){
                    readyGo(MineProjectActivity.class);
                }else{
                    readyGo(LoginActivity.class);
                }
                break;
            case R.id.mine_data: //个人资料
                if (isLogin()){
                    readyGo(MineData1Activity.class);
                }else{
                    readyGo(LoginActivity.class);
                }
                break;
            case R.id.mine_history://浏览记录
                readyGo(HistoryActivity.class);
                break;
            case R.id.mine_setting://设置
                if (isLogin()){
                    readyGo(SettingActivity.class);
                }else{
                    readyGo(LoginActivity.class);
                }
                break;
            case R.id.mine_attenttion: //我的关注
                if (isLogin()){
                    readyGo(AttentionActivity.class);
                }else{
                    readyGo(LoginActivity.class);
                }
                break;
            case R.id.mine_meeting: //我的会议
                if (isLogin()){
                    readyGo(MeetingActivity.class);
                }else{
                    readyGo(LoginActivity.class);
                }
                break;
            case R.id.toolbar_title:
//                readyGo(LoginActivity.class);
                break;
            case R.id.mine_message://我的消息
                if (isLogin()){
                    readyGo(MessageActivity.class);
                }else{
                    readyGo(LoginActivity.class);
                }
                break;
            case R.id.contact_us://联系我们
                new AlertDialog.Builder(this.getContext())
                        .setTitle("拨号提示")
                        .setMessage("中国国际人才交流大会人工客服24小时在线为您服务,是否拨号")
                        .setNegativeButton("取消", (dialogInterface, i) -> {

                        })
                        .setPositiveButton("确定", (dialogInterface, i) -> {
                            // 申请权限
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                                applyPermissions(Manifest.permission.CALL_PHONE, 110);
                            } else {
                              callService();
                            }

                        })
                        .show();
                break;
        }
    }

    @Override
    protected void onApplyPermissionsResult(int requestCode, boolean isSuccess) {
        super.onApplyPermissionsResult(requestCode, isSuccess);
        if (requestCode == 110 && isSuccess) {
            callService();
        } else {
            showToast("申请拨打电话失败");
        }
    }

    // 电话号码暂时固定死
    private void callService() {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+ "0755-22673275"));
        startActivity(intent);
    }

    private boolean isLogin() {
        String loginUser = SharedPrefUtil.getPrefString(this.getContext(), Constant.LOGIN_USER, "");
        if (! TextUtils.isEmpty(loginUser)){
            return true;
        }
        return false;
    }
}
