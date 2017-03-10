package com.qhzk.ciep.ui.jobdetail;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.entity.JobDetail;
import com.qhzk.ciep.protocol.CheckDeliverProtocol;
import com.qhzk.ciep.protocol.CiepProtocol;
import com.qhzk.ciep.ui.unitinfo.UnitInfoActivity;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 职位信息, 即岗位详情 2016年12月23日14:40:31
 */
public class JobDetailActivity extends BaseActivity<JobDetailPresenter> implements JobDetailView {

    @BindView(R.id.job_title)
    TextView mJobTitle;
    @BindView(R.id.publish_date)
    TextView mPublishDate;
    @BindView(R.id.name)
    TextView mName;
    @BindView(R.id.company_detail)
    TextView mCompanyDetail;
    @BindView(R.id.enttype)
    TextView mEnttype;
    @BindView(R.id.entsize)
    TextView mEntsize;
    @BindView(R.id.industry)
    TextView mIndustry;
    @BindView(R.id.num)
    TextView mNum;
    @BindView(R.id.experience)
    TextView mExperience;
    @BindView(R.id.education)
    TextView mEducation;
    @BindView(R.id.job_desc)
    TextView mJobDesc;
    @BindView(R.id.other_require)
    TextView mOtherRequire;
    @BindView(R.id.apply_job)
    Button mApplyJob;

    private String id;
    private String enterpriseId;
    private String positionId;

    private boolean hideKey; // 是否隐藏掉 [查看]

    @Override
    public int getLayoutId() {
        return R.layout.activity_job_detail;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        hideKey = savedInstanceState.getBoolean("hideKey", false);
        id = savedInstanceState.getString("id");
    }

    @Override
    protected void initdata() {
        super.initdata();
        if (hideKey){
            mCompanyDetail.setVisibility(View.GONE);
        }
        mActivityPresenter.loadData(id);
    }

    @Override
    public void onLoadSuccess(JobDetail jobDetail) {
        positionId = jobDetail.getId();
        CheckDeliverProtocol protocol = new CheckDeliverProtocol(new CiepProtocol.Callback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                showToast("问题发生了 :"+e);
            }

            @Override
            public void onSuccess() {
                mApplyJob.setText("已经投递");
            }

            @Override
            public void onFailed() {
                mApplyJob.setText("点击投递");
            }
        });
        protocol.setPositionId(positionId);
        protocol.uploadDataByPost();
        enterpriseId = jobDetail.getEnterprise().getId();
        if (jobDetail.getTitle() != null) {
            mJobTitle.setText(jobDetail.getTitle());
        }
        if (jobDetail.getPublishDate() != null) {
            mPublishDate.setText(jobDetail.getPublishDate().split(" ")[0]);
        }
        if (jobDetail.getEnterprise().getName() != null) {
            mName.setText(jobDetail.getEnterprise().getName());
        }
        if (jobDetail.getEnterprise().getEnttype() != null) {
            mEnttype.setText("单位性质:"+jobDetail.getEnterprise().getEnttype());
        }
        if (jobDetail.getEnterprise().getEntsize() != null) {
            mEntsize.setText("规模:"+jobDetail.getEnterprise().getEntsize());
        }
        if (jobDetail.getEnterprise().getIndustry() != null) {
            mIndustry.setText("单位类别:"+jobDetail.getEnterprise().getIndustry());
        }
        mNum.setText("人数:" + jobDetail.getNum() + "人");
        if (jobDetail.getExperience() != null) {
            mExperience.setText(String.format("经验:%s", jobDetail.getExperience()));
        }
        if (jobDetail.getEducation() != null) {
            mEducation.setText(String.format("学历:%s", jobDetail.getEducation()));
        }
        if (jobDetail.getJobDesc() != null) {
            mJobDesc.setText(jobDetail.getJobDesc());
        }
        if (jobDetail.getOtherRequirement() != null) {
            mOtherRequire.setText(jobDetail.getOtherRequirement());
        }
    }

    @Override
    public void onDeliverSuccess() {
        showToast("投递成功");
        mApplyJob.setText("已经投递");
    }

    @OnClick({R.id.company_detail, R.id.apply_job})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.company_detail:
                Bundle bundle = new Bundle();
                bundle.putString("id", enterpriseId);
                readyGo(UnitInfoActivity.class, bundle);
                break;
            case R.id.apply_job:

                if (mApplyJob.getText().toString().equals("已经投递")){
                    showToast("已经投递过啦,请等候消息吧");
                }else {
                    mActivityPresenter.deliver(positionId);
                }
                break;
        }
    }
}
