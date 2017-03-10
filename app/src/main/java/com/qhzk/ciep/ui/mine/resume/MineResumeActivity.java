package com.qhzk.ciep.ui.mine.resume;

import android.view.View;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.ui.mine.resume.edu_exp.ResetWorkExpActivity;
import com.qhzk.ciep.ui.mine.resume.edu_exp.reset.EduExpActivity;
import com.qhzk.ciep.ui.mine.resume.edu_exp.reset.ResetJobIntentActivity;
import com.qhzk.ciep.ui.mine.resume.reset_data.MineResetDataActivity;

import butterknife.OnClick;

/**
 * Created by pudao on 2016/11/23.
 * 2016年12月20日15:10:23
 * 我的简历页面
 */

public class MineResumeActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_resume;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    protected void initdata() {
        super.initdata();
    }


    @OnClick({R.id.layout_reset_data, R.id.layout_reset_edu, R.id.layout_reset_work, R.id.layout_reset_job})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_reset_data: //修改个人信息
                readyGo(MineResetDataActivity.class);
                break;
            case R.id.layout_reset_edu: //修改教育经历
               readyGo(EduExpActivity.class);
                break;
            case R.id.layout_reset_work: // 修改工作经验
                readyGo(ResetWorkExpActivity.class);
                break;
            case R.id.layout_reset_job: // 修改求职意向
                readyGo(ResetJobIntentActivity.class);
                break;
        }
    }
}
