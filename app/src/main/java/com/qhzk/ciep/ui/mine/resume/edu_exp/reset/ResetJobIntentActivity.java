package com.qhzk.ciep.ui.mine.resume.edu_exp.reset;

import android.app.Dialog;
import android.graphics.Color;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.lljjcoder.citypickerview.widget.CityPicker;
import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.entity.Resume;
import com.qhzk.ciep.view.ArrivalTimeDialog;
import com.qhzk.ciep.view.IndustryDialog;
import com.qhzk.ciep.view.JobTypeDialog;
import com.qhzk.ciep.view.SalaryDialog;
import com.qhzk.ciep.widget.MineItemEdit;
import com.qhzk.ciep.widget.MineItemView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 修改求职意向 2016年12月20日15:15:40
 */
public class ResetJobIntentActivity extends BaseActivity<ResetJobIntentPresenter> implements ResetJobIntentView {

    @BindView(R.id.personal_comment)
    TextView mPersonalComment;
    @BindView(R.id.layout_work)
    CardView mLayoutWork;
    @BindView(R.id.et_comment)
    AppCompatEditText mEtComment;
    @BindView(R.id.toolbar_right_title)
    TextView mToolbarRightTitle;
    @BindView(R.id.keyword)
    MineItemEdit mKeyword;
    @BindView(R.id.location)
    MineItemView mLocation;
    @BindView(R.id.industry)
    MineItemView mIndustry;
    @BindView(R.id.position)
    MineItemEdit mPosition;
    @BindView(R.id.jobtype)
    MineItemView mJobtype;
    @BindView(R.id.salary)
    MineItemView mSalary;
    @BindView(R.id.arrival_time)
    MineItemView mArrivalTime;
    private String mResumeId;

    @Override
    public int getLayoutId() {
        return R.layout.activity_reset_job_intent;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    protected void initdata() {
        super.initdata();
        mEtComment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mPersonalComment.setText(String.format("%d/500", charSequence.length()));
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        mActivityPresenter.getResumeByProtocol();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void commitToServer() {
        Map<String, String> mParmasMap = new HashMap<>();
        if (!TextUtils.isEmpty(mResumeId)) {
            mParmasMap.put("jobPreferences.resumeid", mResumeId);
        }
        if (!TextUtils.isEmpty(mPosition.getValue())) {
            mParmasMap.put("jobPreferences.position", mPosition.getValue());
        }
        if (!TextUtils.isEmpty(mLocation.getValue())) {
            mParmasMap.put("jobPreferences.location", mLocation.getValue());
        }
        if (!TextUtils.isEmpty(mJobtype.getValue())) {
            mParmasMap.put("jobPreferences.jobtype", mJobtype.getValue());
        }
        if (!TextUtils.isEmpty(mSalary.getValue())) {
            mParmasMap.put("jobPreferences.targetsalary", mSalary.getValue());
        }
        if (!TextUtils.isEmpty(mArrivalTime.getValue())) {
            mParmasMap.put("jobPreferences.dutytime", mArrivalTime.getValue());
        }
        if (!TextUtils.isEmpty(mEtComment.getText().toString())) {
            mParmasMap.put("jobPreferences.selfdesc", mEtComment.getText().toString());
        }
        if (!TextUtils.isEmpty(mIndustry.getValue())) {
            mParmasMap.put("jobPreferences.industry", mIndustry.getValue());
        }
        mActivityPresenter.commitJobPrefer(mParmasMap);
    }

    private void showCityPicker() {
        CityPicker cityPicker = new CityPicker.Builder(this)
                .textSize(20)
                .title("")
                .backgroundPop(0xa0000000)
                .titleBackgroundColor("#F9F9F9")
                .backgroundPop(0xa0000000)
                .confirTextColor("#6BA8E5")
                .cancelTextColor("#9c9c9c")
                .province("广东省")
                .city("深圳市")
                .textColor(Color.parseColor("#000000"))
                .provinceCyclic(true)
                .cityCyclic(false)
                .districtCyclic(false)
                .visibleItemsCount(7)
                .itemPadding(10)
                .onlyShowProvinceAndCity(true)
                .build();
        cityPicker.show();

        //监听方法，获取选择结果
        cityPicker.setOnCityItemClickListener(citySelected -> {
            //省份
            String province = citySelected[0];
            //城市
            String city = citySelected[1];
            mLocation.setItemValue(String.format("%s%s", province, city));
        });
    }

    @Override
    public void onCommitSuccess() {
        showToast("保存成功");
        finish();
    }

    @Override
    public void onLoadResume(Resume resume) {
        if (resume.getResume() != null) {
            mResumeId = resume.getResume().getId();
            if (resume.getResume().getJobPreferences() != null) {
                if (resume.getResume().getJobPreferences().size()>0){
                    if (resume.getResume().getJobPreferences().get(0) != null) {
                        if (resume.getResume().getJobPreferences().get(0).getDutytime() != null) {
                            mArrivalTime.setItemValue(resume.getResume().getJobPreferences().get(0).getDutytime());
                        }
                        if (resume.getResume().getJobPreferences().get(0).getIndustry() != null) {
                            mIndustry.setItemValue(resume.getResume().getJobPreferences().get(0).getIndustry());
                        }
                        if (resume.getResume().getJobPreferences().get(0).getJobtype() != null) {
                            mJobtype.setItemValue(resume.getResume().getJobPreferences().get(0).getJobtype());
                        }
                        if (resume.getResume().getJobPreferences().get(0).getLocation() != null) {
                            mLocation.setItemValue(resume.getResume().getJobPreferences().get(0).getLocation());
                        }
                        if (resume.getResume().getJobPreferences().get(0).getSelfdesc() != null) {
                            mPersonalComment.setText(resume.getResume().getJobPreferences().get(0).getSelfdesc());
                        }
                        if (resume.getResume().getJobPreferences().get(0).getTargetsalary() != null) {
                            mSalary.setItemValue(resume.getResume().getJobPreferences().get(0).getTargetsalary());
                        }
                        if (resume.getResume().getJobPreferences().get(0).getPosition() != null) {
                            mPosition.setValue(resume.getResume().getJobPreferences().get(0).getPosition());
                        }
                    }
                }
            }
        }

    }

    @Override
    public void onError(Exception e) {
        showToast("保存失败:"+e);
    }

    @OnClick({R.id.toolbar_right_title, R.id.location, R.id.industry, R.id.jobtype, R.id.salary, R.id.arrival_time})
    public void onClick(View view) {
        Dialog dialog;
        switch (view.getId()) {
            case R.id.toolbar_right_title:
                commitToServer();
                break;
            case R.id.location:
                showCityPicker();
                break;
            case R.id.industry:
                dialog = new IndustryDialog(this, entsize -> mIndustry.setItemValue(entsize));
                dialog.show();
                break;
            case R.id.jobtype:
                dialog = new JobTypeDialog(this, entsize -> mJobtype.setItemValue(entsize));
                dialog.show();
                break;
            case R.id.salary:
                dialog = new SalaryDialog(this, entsize -> mSalary.setItemValue(entsize));
                dialog.show();
                break;
            case R.id.arrival_time:
                dialog = new ArrivalTimeDialog(this, entsize -> mArrivalTime.setItemValue(entsize));
                dialog.show();
                break;
        }
    }
}
