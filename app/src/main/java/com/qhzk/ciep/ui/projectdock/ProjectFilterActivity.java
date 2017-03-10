package com.qhzk.ciep.ui.projectdock;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.view.IndustryDialog;
import com.qhzk.ciep.view.ProjectTypeDialog;
import com.qhzk.ciep.view.PublishRoleDialog;

import butterknife.BindView;
import butterknife.OnClick;

public class ProjectFilterActivity extends BaseActivity {

    @BindView(R.id.et_projectname)
    EditText mEtProjectname;
    @BindView(R.id.tv_project_category)
    TextView mTvProjectCategory;
    @BindView(R.id.project_category)
    CardView mProjectCategory;
    @BindView(R.id.tv_industry_field)
    TextView mTvIndustryField;
    @BindView(R.id.industry_field)
    CardView mIndustryField;
    @BindView(R.id.tv_publish_role)
    TextView mTvPublishRole;
    @BindView(R.id.publish_role)
    CardView mPublishRole;

    @Override
    public int getLayoutId() {
        return R.layout.activity_project_filter;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());
    }

    @OnClick({R.id.tootbar_right_title, R.id.icon_del_project, R.id.project_category, R.id.industry_field, R.id.publish_role})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tootbar_right_title:
                // 保存
                Intent data = new Intent();
                String projecjName = mEtProjectname.getText().toString();
                if (!projecjName.equals("")) {
                    data.putExtra("projectName", projecjName);
                }
                String projectType = mTvProjectCategory.getText().toString();
                if (!projectType.equals("")) {
                    data.putExtra("projectType", projectType);
                }
                String projectSector = mTvIndustryField.getText().toString();
                if (!projectSector.equals("")) {
                    data.putExtra("projectSector", projectSector);
                }
                String releaseType = mTvPublishRole.getText().toString();
                if (!releaseType.equals("")) {
                    data.putExtra("releaseType", releaseType);
                }
                setResult(RESULT_OK, data);
                finish();
                break;
            case R.id.icon_del_project:
                mEtProjectname.setText("");
                break;
            case R.id.project_category:
                new ProjectTypeDialog(this, new ProjectTypeDialog.OnSelectListener() {
                    @Override
                    public void onCountrySelect(String entsize) {
                        mTvProjectCategory.setText(entsize);
                    }
                }).show();
                break;
            case R.id.industry_field:
                new IndustryDialog(this, new IndustryDialog.OnSelectListener() {
                    @Override
                    public void onCountrySelect(String entsize) {
                        mTvIndustryField.setText(entsize);
                    }
                }).show();
                break;
            case R.id.publish_role:
                new PublishRoleDialog(this, new PublishRoleDialog.OnSelectListener() {
                    @Override
                    public void onCountrySelect(String entsize) {
                        mTvPublishRole.setText(entsize);
                    }
                }).show();
                break;
        }
    }
}
