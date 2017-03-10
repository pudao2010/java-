package com.qhzk.ciep.ui.home.attend;

import android.view.View;
import android.widget.Button;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 报名成功页面 2016年12月21日20:43:10
 */
public class AttendSuccessActivity extends BaseActivity {

    @BindView(R.id.attend_finish)
    Button mAttendFinish;

    @Override
    public int getLayoutId() {
        return R.layout.activity_attend_success;
    }

    @Override
    protected void initview() {
        super.initview();
        //  ToolBar的返回键
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @OnClick(R.id.attend_finish)
    public void onClick() {
        finish();
    }
}
