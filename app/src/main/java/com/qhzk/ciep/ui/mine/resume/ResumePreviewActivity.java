package com.qhzk.ciep.ui.mine.resume;

import android.widget.LinearLayout;
import android.widget.TextView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.entity.Resume;
import com.qhzk.ciep.entity.UserInfo;
import com.qhzk.ciep.protocol.BaseProtocol;
import com.qhzk.ciep.protocol.ResumeProtocol;
import com.qhzk.ciep.view.EduExpView;
import com.qhzk.ciep.view.JobIntentionView;
import com.qhzk.ciep.view.WorkExpView;

import java.util.List;

import butterknife.BindView;
import okhttp3.Call;

/**
 * 简历预览页面
 */
public class ResumePreviewActivity extends BaseActivity<ResumePreviewPresenter> implements ResumePreviewView {

    @BindView(R.id.real_name)
    TextView mRealName;
    @BindView(R.id.gender)
    TextView mGender;
    @BindView(R.id.phone)
    TextView mPhone;
    @BindView(R.id.email)
    TextView mEmail;
    @BindView(R.id.edu_expview)
    EduExpView mEduExpview;
    @BindView(R.id.container_education)
    LinearLayout mContainerEducation;
    @BindView(R.id.work_expview)
    WorkExpView mWorkExpview;
    @BindView(R.id.container_workexp)
    LinearLayout mContainerWorkexp;
    @BindView(R.id.job_intention)
    JobIntentionView mJobIntention;

    @Override
    public int getLayoutId() {
        return R.layout.activity_resume_preview;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    protected void initdata() {
        super.initdata();
        getResumeByProtocol();
        mActivityPresenter.getUserInfo();
    }

    private void getResumeByProtocol() {
        ResumeProtocol protocol = new ResumeProtocol();
        protocol.loadDataByGet(new BaseProtocol.Callback<Resume>() {
            @Override
            public void onError(Call call, Exception e, int id) {
                showToast("网络加载异常 :" + e);
            }

            @Override
            public void onResponse(Resume resume, int id) {

                if (resume != null && resume.getResume() != null && resume.getResume().getEducationList() != null) {
                    List<Resume.ResumeBean.EducationListBean> educationList = resume.getResume().getEducationList();
                    if (educationList.size() >= 1) {
                        mEduExpview.setAttribute(educationList.get(0).getSchool(), educationList.get(0).getDegree(), educationList.get(0).getStartdate() + "至" + educationList.get(0).getEnddate());
                        for (int i = 1; i < educationList.size(); i++) {
                            EduExpView eduExpView = new EduExpView(ResumePreviewActivity.this);
                            eduExpView.setAttribute(educationList.get(i).getSchool(), educationList.get(i).getDegree(), educationList.get(i).getStartdate() + "至" + educationList.get(i).getEnddate());
                            mContainerEducation.addView(eduExpView);
                        }
                    }

                    List<Resume.ResumeBean.WorkExperienceListBean> workExperienceList = resume.getResume().getWorkExperienceList();
                    if (workExperienceList.size() >= 1) {
                        mWorkExpview.setAttribute(workExperienceList.get(0).getCompany(), workExperienceList.get(0).getStartdate() + "至" + workExperienceList.get(0).getEnddate());
                        if (workExperienceList.size() > 1) {
                            for (int i = 1; i < workExperienceList.size(); i++) {
                                WorkExpView workExpView = new WorkExpView(ResumePreviewActivity.this);
                                workExpView.setAttribute(workExperienceList.get(i).getCompany(), workExperienceList.get(i).getStartdate() + "至" + workExperienceList.get(i).getEnddate());
                                mContainerWorkexp.addView(workExpView);
                            }
                        }
                    }

                    List<Resume.ResumeBean.JobPreferencesBean> jobPreferences = resume.getResume().getJobPreferences();
                    if (jobPreferences.size()>=1){
                        if (jobPreferences.get(0).getPosition() != null &&
                                jobPreferences.get(0).getTargetsalary() != null) {
                            mJobIntention.setAttribute(jobPreferences.get(0).getPosition(), jobPreferences.get(0).getTargetsalary());
                        }
                    }

                }

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onLoadUserInfoSuccess(UserInfo userInfo) {
        if (userInfo.getName() != null) {
            mRealName.setText(userInfo.getName());
        }
        if (userInfo.getGender() != null) {
            mGender.setText(userInfo.getGender());
        }
        if (userInfo.getPhoneNum() != null) {
            mPhone.setText(userInfo.getPhoneNum());
        }
        if (userInfo.getEmail() != null) {
            mEmail.setText(userInfo.getEmail());
        }
    }
}
