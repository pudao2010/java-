package com.qhzk.ciep.ui.talentdock;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.view.DegreeDialog;
import com.qhzk.ciep.view.ExpectSalaryDialog;
import com.qhzk.ciep.view.IndustryDialog;
import com.qhzk.ciep.view.JobTypeDialog;
import com.qhzk.ciep.view.MajorDialog;
import com.qhzk.ciep.view.WorkExpDialog;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 人才对接里面的岗位搜索
 */
public class UnitInfoFilterActivity extends BaseActivity {

    @BindView(R.id.et_companyname)
    EditText mEtCompanyname;
    @BindView(R.id.icon_del_company)
    ImageView mIconDelCompany;
    @BindView(R.id.et_job_title)
    EditText mEtJobTitle;
    @BindView(R.id.icon_del_title)
    ImageView mIconDelTitle;
    @BindView(R.id.tv_salary)
    TextView mTvSalary;
    @BindView(R.id.expect_salary)
    CardView mExpectSalary;
    @BindView(R.id.tv_experience)
    TextView mTvExperience;
    @BindView(R.id.work_experience)
    CardView mWorkExperience;
    @BindView(R.id.tv_degree)
    TextView mTvDegree;
    @BindView(R.id.degree)
    CardView mDegree;
    @BindView(R.id.tv_workproperty)
    TextView mTvWorkproperty;
    @BindView(R.id.work_property)
    CardView mWorkProperty;
    @BindView(R.id.major)
    CardView mMajor;
    @BindView(R.id.tv_major)
    TextView mTvMajor;
    @BindView(R.id.icon_del_major)
    ImageView mIconDelMajor;
    @BindView(R.id.tv_industry)
    TextView mTvIndustry;
    @BindView(R.id.industry)
    CardView mIndustry;

    @Override
    public int getLayoutId() {
        return R.layout.activity_unit_info_filter;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());
    }

    @OnClick({R.id.tootbar_right_title, R.id.icon_del_company, R.id.icon_del_title, R.id.expect_salary, R.id.work_experience, R.id.degree, R.id.work_property, R.id.industry, R.id.major})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tootbar_right_title:
                Intent data = new Intent();
                if (!mEtCompanyname.getText().toString().equals("")){
                    data.putExtra("entName", mEtCompanyname.getText().toString());
                }
                if (!mEtJobTitle.getText().toString().equals("")){
                    data.putExtra("title", mEtJobTitle.getText().toString());
                }
                if (!mTvSalary.getText().toString().equals("")){
                    data.putExtra("salRange", mTvSalary.getText().toString());
                }
                if (!mTvExperience.getText().toString().equals("")){
                    data.putExtra("experience", mTvExperience.getText().toString());
                }
                if (!mTvDegree.getText().toString().equals("")){
                    data.putExtra("education", mTvDegree.getText().toString());
                }
                if (!mTvMajor.getText().toString().equals("")){
                    data.putExtra("major", mTvMajor.getText().toString());
                }
                if (!mTvIndustry.getText().toString().equals("")){
                    data.putExtra("industry", mTvIndustry.getText().toString());
                }
                if (!mTvWorkproperty.getText().toString().equals("")){
                    data.putExtra("jobType", mTvWorkproperty.getText().toString());
                }
                setResult(RESULT_OK, data);
                finish();
                break;
            case R.id.major:
                new MajorDialog(this, entsize -> mTvMajor.setText(entsize)).show();
                break;
            case R.id.icon_del_company:
                mEtCompanyname.setText("");
                break;
            case R.id.icon_del_title:
                mEtJobTitle.setText("");
                break;
            case R.id.expect_salary:
                //期望薪水
                new ExpectSalaryDialog(this, entsize -> mTvSalary.setText(entsize)).show();
                break;
            case R.id.work_experience:
                //工作经验
                new WorkExpDialog(this, entsize -> mTvExperience.setText(entsize)).show();
                break;
            case R.id.degree:
                //专业
                new DegreeDialog(this, entsize -> mTvDegree.setText(entsize)).show();
                break;
            case R.id.work_property:
                //工作性质
                new JobTypeDialog(this, entsize -> mTvWorkproperty.setText(entsize)).show();
                break;
            case R.id.industry:
                //行业
                new IndustryDialog(this, entsize -> mTvIndustry.setText(entsize)).show();
                break;
        }
    }
}
