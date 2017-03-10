package com.qhzk.ciep.ui.mine.resume.edu_exp.reset;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.entity.Resume;
import com.qhzk.ciep.view.CiepDataPicker;
import com.qhzk.ciep.view.EntSizeDialog;
import com.qhzk.ciep.view.IndustryDialog;
import com.qhzk.ciep.view.JobTypeDialog;
import com.qhzk.ciep.view.UnitPropertyDialog;
import com.qhzk.ciep.widget.MineItemEdit;
import com.qhzk.ciep.widget.MineItemView;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 工作经历 2016年12月20日17:29:43
 * 添加工作经历从这里添加 ,修改工作经历也从这里修改
 */
public class WorkExpActivity extends BaseActivity<WorkExpPresenter> implements WorkExpView {


    @BindView(R.id.personal_comment)
    TextView mPersonalComment;
    @BindView(R.id.layout_work)
    CardView mLayoutWork;
    @BindView(R.id.et_description)
    AppCompatEditText mEtDescription;
    @BindView(R.id.toolbar_right_title)
    TextView mToolbarRightTitle;
    @BindView(R.id.entry_time)
    MineItemView mEntryTime;
    @BindView(R.id.deputare_time)
    MineItemView mDeputareTime;
    @BindView(R.id.company)
    MineItemEdit mCompany;
    @BindView(R.id.industry)
    MineItemView mIndustry;
    @BindView(R.id.unit_size)
    MineItemView mUnitSize;
    @BindView(R.id.unit_nature)
    MineItemView mUnitNature;
    @BindView(R.id.job_title)
    MineItemEdit mJobTitle;
    @BindView(R.id.department)
    MineItemEdit mDepartment;
    @BindView(R.id.job_type)
    MineItemView mJobType;
    private String mResumeId;

    private boolean isUpdate = false;
    private String id;
    private Resume.ResumeBean.WorkExperienceListBean workExperienceListBean;

    @Override
    public int getLayoutId() {
        return R.layout.activity_work_exp;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        workExperienceListBean = (Resume.ResumeBean.WorkExperienceListBean) savedInstanceState.getSerializable("serializable");
        if (workExperienceListBean != null) {
            id = workExperienceListBean.getId();
            if (!TextUtils.isEmpty(this.id)) {
                isUpdate = true;
            } else {
                isUpdate = false;
            }
        }

    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());

        mEtDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mPersonalComment.setText(String.valueOf(charSequence.length()) + "/500");
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    @Override
    protected void initdata() {
        super.initdata();
        mActivityPresenter.getResumeByProtocol();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // 如果是修改工作经历
        if (isUpdate) {
            mEntryTime.setItemValue(workExperienceListBean.getStartdate());
            mDeputareTime.setItemValue(workExperienceListBean.getEnddate());
            mCompany.setValue(workExperienceListBean.getCompany());
            mIndustry.setItemValue(workExperienceListBean.getIndustry());
            mUnitSize.setItemValue(workExperienceListBean.getComsize());
            mUnitNature.setItemValue(workExperienceListBean.getComtype());
            mJobTitle.setValue(workExperienceListBean.getPosition());
            mDepartment.setValue(workExperienceListBean.getDepartment());
            mJobType.setItemValue(workExperienceListBean.getJobtype());
        }
    }

    private void commitToServer() {
        Map<String, String> mParmasMap = new HashMap<>();
        if (!TextUtils.isEmpty(id)) {
            mParmasMap.put("workExperience.id", id);
        }
        if (!TextUtils.isEmpty(mResumeId)) {
            mParmasMap.put("workExperience.resumeid", mResumeId);
        }
        String startdate = mEntryTime.getValue();
        if (!TextUtils.isEmpty(startdate)) {
            mParmasMap.put("workExperience.startdate", startdate);
        }
        String enddate = mDeputareTime.getValue();
        if (!TextUtils.isEmpty(enddate)) {
            mParmasMap.put("workExperience.enddate", enddate);
        }
        if (!TextUtils.isEmpty(mCompany.getValue())){
            mParmasMap.put("workExperience.company", mCompany.getValue());
        }
        if (!TextUtils.isEmpty(mJobTitle.getValue())) {
            mParmasMap.put("workExperience.position", mJobTitle.getValue());
        }
        if (!TextUtils.isEmpty(mDepartment.getValue())) {
            mParmasMap.put("workExperience.department", mDepartment.getValue());
        }
        if (!TextUtils.isEmpty(mIndustry.getValue())) {
            mParmasMap.put("workExperience.industry", mIndustry.getValue());
        }
        if (!TextUtils.isEmpty(mUnitSize.getValue())) {
            mParmasMap.put("workExperience.comsize", mUnitSize.getValue());
        }
        if (!TextUtils.isEmpty(mUnitNature.getValue())) {
            mParmasMap.put("workExperience.comtype", mUnitNature.getValue());
        }
        if (!TextUtils.isEmpty(mJobType.getValue())) {
            mParmasMap.put("workExperience.jobtype", mJobType.getValue());
        }
        if (!TextUtils.isEmpty(mEtDescription.getText().toString())) {
            mParmasMap.put("workExperience.description", mEtDescription.getText().toString());
        }
        mActivityPresenter.commitWorkExp(mParmasMap);
    }

    @Override
    public void onCommitSuccess() {
        showToast("保存成功");
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void onLoadResume(Resume resume) {
        if (resume.getResume() != null) {
            mResumeId = resume.getResume().getId();
        }
    }

    @Override
    public void onError(Exception e) {
        showToast("发生错误 :"+e);
    }

    @OnClick({R.id.toolbar_right_title, R.id.entry_time, R.id.deputare_time, R.id.industry, R.id.unit_size, R.id.unit_nature, R.id.job_type})
    public void onClick(View view) {
        Dialog dialog;
        switch (view.getId()) {
            case R.id.toolbar_right_title:
                commitToServer();
                break;
            case R.id.entry_time:
//                dialog = new BirthdayDialog(this, birth -> mEntryTime.setItemValue(birth));
//                dialog.show();
                Calendar d = Calendar.getInstance(Locale.CHINA);
                // 创建一个日历引用d，通过静态方法getInstance() 从指定时区 Locale.CHINA 获得一个日期实例
                Date date = new Date();
                // 创建一个Date实例
                d.setTime(date);
                // 设置日历的时间，把一个新建Date实例date传入
                int year = d.get(Calendar.YEAR);
                int month = d.get(Calendar.MONTH);
                int day = d.get(Calendar.DAY_OF_MONTH);
                //初始化默认日期year, month, day
                CiepDataPicker ciepdialog = new CiepDataPicker(this, (view1, year1, month1, dayOfMonth) ->
                        mEntryTime.setItemValue(year1 + "-" + (month1+1) + "-" + dayOfMonth), year, month, day);
                ciepdialog.getDatePicker().setMaxDate(date.getTime());
                ciepdialog.show();
                break;
            case R.id.deputare_time:
//                dialog = new BirthdayDialog(this, birth -> mDeputareTime.setItemValue(birth));
//                dialog.show();
                Calendar calendar = Calendar.getInstance(Locale.CHINA);
                // 创建一个日历引用d，通过静态方法getInstance() 从指定时区 Locale.CHINA 获得一个日期实例
                Date date1 = new Date();
                // 创建一个Date实例
                calendar.setTime(date1);
                // 设置日历的时间，把一个新建Date实例date传入
                int yearNew = calendar.get(Calendar.YEAR);
                int monthNew = calendar.get(Calendar.MONTH);
                int dayNew = calendar.get(Calendar.DAY_OF_MONTH);
                //初始化默认日期year, month, day
                CiepDataPicker ciepdialog1 = new CiepDataPicker(this, (view1, year1, month1, dayOfMonth) ->
                        mDeputareTime.setItemValue(year1 + "-" + (month1+1) + "-" + dayOfMonth), yearNew, monthNew, dayNew);
                ciepdialog1.getDatePicker().setMaxDate(date1.getTime());
                ciepdialog1.show();
                break;
            case R.id.industry:
                dialog = new IndustryDialog(this, entsize -> mIndustry.setItemValue(entsize));
                dialog.show();
                break;
            case R.id.unit_size:
                dialog = new EntSizeDialog(this, entsize -> mUnitSize.setItemValue(entsize));
                dialog.show();
                break;
            case R.id.unit_nature:
                dialog = new UnitPropertyDialog(this, entsize -> mUnitNature.setItemValue(entsize));
                dialog.show();
                break;
            case R.id.job_type:
                dialog = new JobTypeDialog(this, entsize -> mJobType.setItemValue(entsize));
                dialog.show();
                break;
        }
    }
}
