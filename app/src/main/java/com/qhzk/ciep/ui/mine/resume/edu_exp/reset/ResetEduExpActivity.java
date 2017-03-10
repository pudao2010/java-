package com.qhzk.ciep.ui.mine.resume.edu_exp.reset;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.config.Constant;
import com.qhzk.ciep.entity.Resume;
import com.qhzk.ciep.entity.ResumeEntity;
import com.qhzk.ciep.utils.SharedPrefUtil;
import com.qhzk.ciep.view.DegreeDialog;
import com.qhzk.ciep.view.EdutimeDialog;
import com.qhzk.ciep.view.MajorDialog;
import com.qhzk.ciep.widget.MineItemEdit;
import com.qhzk.ciep.widget.MineItemView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by pucheng on 2017/1/7.
 * 修改教育经历页面
 */

public class ResetEduExpActivity extends BaseActivity<ResetEduExpPresenter> implements ResetEduExpView {

    @BindView(R.id.toolbar_right_title)
    TextView mToolbarRightTitle;
    @BindView(R.id.word)
    AppCompatEditText mWord;
    @BindView(R.id.personal_comment)
    TextView mPersonalComment; //计算编辑框的字数
    @BindView(R.id.study_time)
    MineItemView mStudyTime;
    @BindView(R.id.college)
    MineItemEdit mCollege;
    @BindView(R.id.degree)
    MineItemView mDegree;
    @BindView(R.id.major)
    MineItemView mMajor;
    @BindView(R.id.email)
    MineItemEdit mEmail;
    private String mResumeId;
    private String mId;

    private Resume.ResumeBean.EducationListBean educationListBean;
    private boolean isUpdate = false;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_reset_edu;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        educationListBean = (Resume.ResumeBean.EducationListBean) savedInstanceState.getSerializable("serializable");
        if (educationListBean != null) {
            mId = educationListBean.getId();
            if (!TextUtils.isEmpty(mId)){
                isUpdate = true;
            } else {
                isUpdate = false;
            }
        }
    }

    @Override
    protected void initdata() {
        super.initdata();
        mWord.addTextChangedListener(new TextWatcher() {
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
        mActivityPresenter.getMyResumeId();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (isUpdate){
            if (educationListBean.getStartdate() != null) {
                mStudyTime.setItemValue(educationListBean.getStartdate());
            }
            if (educationListBean.getSchool() != null) {
                mCollege.setValue(educationListBean.getSchool());
            }
            if (educationListBean.getDegree() != null) {
                mDegree.setItemValue(educationListBean.getDegree());
            }
            if (educationListBean.getMajor() != null) {
                mMajor.setItemValue(educationListBean.getMajor());
            }
            getFromSharedPref();
        }
    }

    private void getFromSharedPref() {
        String email = SharedPrefUtil.getPrefString(this, Constant.EMAIL, "");
        mEmail.setValue(email);
    }

    private void saveToSharedPref() {
        if (!TextUtils.isEmpty(mStudyTime.getValue()) &&
                !TextUtils.isEmpty(mCollege.getValue()) &&
                !TextUtils.isEmpty(mDegree.getValue()) &&
                !TextUtils.isEmpty(mMajor.getValue()) &&
                !TextUtils.isEmpty(mEmail.getValue())) {
            SharedPrefUtil.savePrefString(this, Constant.EDU_TIME, mStudyTime.getValue());
            SharedPrefUtil.savePrefString(this, Constant.UNIVERSITY, mCollege.getValue().trim());
            SharedPrefUtil.savePrefString(this, Constant.DEGREE, mDegree.getValue());
            SharedPrefUtil.savePrefString(this, Constant.MAJOR, mMajor.getValue());
            SharedPrefUtil.savePrefString(this, Constant.EMAIL, mEmail.getValue().trim());
            commitToServer();
        } else {
            showToast("请完善个人信息");
        }
    }

    private void commitToServer() {
        Map<String, String> mParmasMap = new HashMap<>();
        if (!TextUtils.isEmpty(mId)) {
            mParmasMap.put("education.id", mId);
        }
        if (!TextUtils.isEmpty(mResumeId)) {
            mParmasMap.put("education.resumeid", mResumeId);
        }
        String value = mStudyTime.getValue();
        if (!TextUtils.isEmpty(value)) {
            String[] split = value.split("至");
            if (!TextUtils.isEmpty(split[0])) {
                mParmasMap.put("education.startdate", split[0]);
            }
            if (!TextUtils.isEmpty(split[1])) {
                mParmasMap.put("education.enddate", split[1]);
            }
        }
        if (!TextUtils.isEmpty(mCollege.getValue())) {
            mParmasMap.put("education.school", mCollege.getValue());
        }
        if (!TextUtils.isEmpty(mDegree.getValue())) {
            mParmasMap.put("education.degree", mDegree.getValue());
        }
        if (!TextUtils.isEmpty(mMajor.getValue())) {
            mParmasMap.put("education.major", mMajor.getValue());
        }
        if (!TextUtils.isEmpty(mWord.getText().toString().trim())) {
            mParmasMap.put("education.description", mWord.getText().toString().trim());
        }
        mActivityPresenter.commitEduExp(mParmasMap);
    }

    @Override
    public void onCommitSuccess() {
        showToast("保存成功");
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void onLoadSuccess(ResumeEntity resumeEntity) {
        if (resumeEntity != null) {

        }
    }

    @Override
    public void onLoadResume(Resume resume) {
        if (resume.getResume() != null) {
            if (resume.getResume().getId() != null) {
                mResumeId = resume.getResume().getId();
//                if (resume.getResume().getEducationList() != null) {
//                    if (resume.getResume().getEducationList().size() > 0){
//                        if (resume.getResume().getEducationList().get(0) != null) {
//                            mId = resume.getResume().getEducationList().get(0).getId();
//                        }
//                    }
//
//                }
            }

        }
    }

    @OnClick({R.id.toolbar_right_title, R.id.study_time, R.id.degree, R.id.major})
    public void onClick(View view) {
        Dialog dialog;
        switch (view.getId()) {
            case R.id.toolbar_right_title:
                saveToSharedPref();
                break;
            case R.id.study_time:
                dialog = new EdutimeDialog(this, birth -> mStudyTime.setItemValue(birth));
                dialog.show();
                break;
            case R.id.degree:
                dialog = new DegreeDialog(this, entsize -> mDegree.setItemValue(entsize));
                dialog.show();
                break;
            case R.id.major:
                dialog = new MajorDialog(this, entsize -> mMajor.setItemValue(entsize));
                dialog.show();
                break;
        }
    }
}
