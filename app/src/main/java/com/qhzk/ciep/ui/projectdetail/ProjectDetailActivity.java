package com.qhzk.ciep.ui.projectdetail;

import android.os.Bundle;
import android.widget.TextView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.entity.TempEn;
import com.qhzk.ciep.protocol.BaseProtocol;
import com.qhzk.ciep.protocol.ProjectDetailProtocol;

import butterknife.BindView;
import okhttp3.Call;

/**
 * 项目详情 2016年12月21日11:46:55 //TODO 待调整
 */
public class ProjectDetailActivity extends BaseActivity{

    @BindView(R.id.org_name)
    TextView mOrgName;
    @BindView(R.id.org_location)
    TextView mOrgLocation;
    @BindView(R.id.org_enttype)
    TextView mOrgEnttype;
    @BindView(R.id.org_entsize)
    TextView mOrgEntsize;
    @BindView(R.id.sector)
    TextView mSector;
    @BindView(R.id.project_name)
    TextView mProjectName;
    @BindView(R.id.project_type)
    TextView mProjectType;
    @BindView(R.id.industry_field)
    TextView mIndustryField;
    @BindView(R.id.project_contact)
    TextView mProjectContact;
    @BindView(R.id.job_title)
    TextView mJobTitle;
    @BindView(R.id.mobile)
    TextView mMobile;
    @BindView(R.id.phone)
    TextView mPhone;
    @BindView(R.id.email)
    TextView mEmail;
    @BindView(R.id.fax)
    TextView mFax;
    @BindView(R.id.profile)
    TextView mProfile;
    @BindView(R.id.intro_label)
    TextView mIntroLabel;
    private String projectId;

    @Override
    public int getLayoutId() {
        return R.layout.activity_project_detail;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        projectId = savedInstanceState.getString("projectId");
    }

    @Override
    protected void initdata() {
        super.initdata();
//        mActivityPresenter.loadData(projectId);
        System.out.println("发起网络请求");
        ProjectDetailProtocol protocol = new ProjectDetailProtocol(projectId);
        protocol.loadDataByGet(new BaseProtocol.Callback<TempEn>(){

            @Override
            public void onError(Call call, Exception e, int id) {
                System.out.println(e.toString());
            }

            @Override
            public void onResponse(TempEn tempEn, int id) {
                onLoadSuccess(tempEn);
            }
        });
//        mActivityPresenter.loadData(projectId);
        System.out.println("网络请求结束");
    }

    private void onLoadSuccess(TempEn tempEn) {

        //公司名
        if (tempEn.getProject() != null && tempEn.getProject().getOrg() != null) {  //空指针
            mOrgName.setText(tempEn.getProject().getOrg().getName());
            // 地址
            if (tempEn.getProject().getOrg().getRegionCity() != null && tempEn.getProject().getOrg().getRegionProv() != null) {
                mOrgLocation.setText("地址:" + tempEn.getProject().getOrg().getRegionProv() + tempEn.getProject().getOrg().getRegionCity());
            } else {
                mOrgLocation.setText("");
            }
            // 公司类型
            if (tempEn.getProject().getOrg().getEnttype() != null) {
                mOrgEnttype.setText(tempEn.getProject().getOrg().getEnttype());
            } else {
                mOrgEnttype.setText("");
            }
            // 公司规模
            if (tempEn.getProject().getOrg().getEntsize() != null) {
                mOrgEntsize.setText(tempEn.getProject().getOrg().getEntsize());
            } else {
                mOrgEntsize.setText("");
            }
            //
            if (tempEn.getProject().getSector() != null) {
                mSector.setText(tempEn.getProject().getSector());
            } else {
                mSector.setText("");
            }
            // 项目名称
            if (tempEn.getProject().getName() != null) {
                mProjectName.setText(tempEn.getProject().getName());
            } else {
                mProjectName.setText("");
            }
            // 项目类别
            if (tempEn.getProject().getType() != null) {
                mProjectType.setText(tempEn.getProject().getType());
            } else {
                mProjectType.setText("");
            }
            // 行业领域
            if (tempEn.getProject().getOrg().getIndustry() != null) {
                mIndustryField.setText(tempEn.getProject().getOrg().getIndustry());
            } else {
                mIndustryField.setText("");
            }
            // 联系人
            if (tempEn.getProject().getOrg().getContrct() != null) {
                mProjectContact.setText(tempEn.getProject().getOrg().getContrct());
            } else {
                mProjectContact.setText("");
            }
            // 职务
            if (tempEn.getProject().getContactstitle() != null) {
                mJobTitle.setText(tempEn.getProject().getContactstitle());
            } else {
                mJobTitle.setText("");
            }
            // 手机
            if (tempEn.getProject().getMobile() != null) {
                mMobile.setText(tempEn.getProject().getMobile());
            } else {
                mMobile.setText("");
            }
            // 座机
            if (tempEn.getProject().getPhone() != null) {
                mPhone.setText(tempEn.getProject().getPhone());
            } else {
                mPhone.setText("");
            }
            // 邮箱
            if (tempEn.getProject().getEmail() != null) {
                mEmail.setText(tempEn.getProject().getEmail());
            } else {
                mEmail.setText("");
            }
            // 传真
            if (tempEn.getProject().getFax() != null) {
                mFax.setText(tempEn.getProject().getFax());
            } else {
                mFax.setText("");
            }
            // 单位介绍
            if (tempEn.getProject().getOrg().getProfile() != null) {
                mProfile.setText(tempEn.getProject().getOrg().getProfile());
            } else {
                mProfile.setText("");
            }
        } else {
            if (tempEn.getProject() != null) {
                if (tempEn.getProject().getPerson() != null && tempEn.getProject().getPerson().company != null) {
                     mOrgName.setText(tempEn.getProject().getPerson().company);
                }
                if (tempEn.getProject().getType() != null) {
                    mOrgEnttype.setText(tempEn.getProject().getType());             //项目类型
                }
                if (tempEn.getProject().getPerson() != null && tempEn.getProject().getPerson().comSize != null) {
                    mOrgEntsize.setText(tempEn.getProject().getPerson().comSize);   //公司规模
                }
                if (tempEn.getProject().getSector() != null) {
                    mSector.setText(tempEn.getProject().getSector());
                }
                if (tempEn.getProject().getName() != null) {
                    mProjectName.setText(tempEn.getProject().getName());
                }
                if (tempEn.getProject().getType() != null) {
                    mProjectType.setText(tempEn.getProject().getType());
                }
                if (tempEn.getProject().getPerson() != null && tempEn.getProject().getPerson().comIndustry != null) {
                    mIndustryField.setText(tempEn.getProject().getPerson().comIndustry); // 行业领域
                }
                if (tempEn.getProject().getPerson() != null && tempEn.getProject().getPerson().name != null) {
                    mProjectContact.setText(tempEn.getProject().getPerson().name); // 联系人
                }
                if (tempEn.getProject().getPerson() != null && tempEn.getProject().getPerson().position != null) {
                    mJobTitle.setText(tempEn.getProject().getPerson().position); // 职务
                }
                if (tempEn.getProject().getPerson() != null && tempEn.getProject().getPerson().phoneNum != null) {
                    mMobile.setText(tempEn.getProject().getPerson().phoneNum); // 手机
                }
                if (tempEn.getProject().getPhone() != null) {
                    mPhone.setText(tempEn.getProject().getPhone()); // 座机
                }
                if (tempEn.getProject().getPerson() != null && tempEn.getProject().getPerson().email != null) {
                    mEmail.setText(tempEn.getProject().getPerson().email); // 邮箱
                }
                if (tempEn.getProject().getFax() != null) {
                    mFax.setText(tempEn.getProject().getFax()); // 传真
                }
                if (tempEn.getProject().getIntroduction() != null) {
                    mIntroLabel.setText("项目介绍");
                    mProfile.setText(tempEn.getProject().getIntroduction());  // 介绍
                }
            }

        }


    }

}
