package com.qhzk.ciep.ui.home.attend.unit_edu;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.qhzk.ciep.R;
import com.qhzk.ciep.config.Constant;
import com.qhzk.ciep.protocol.CiepProtocol;
import com.qhzk.ciep.protocol.ParticipantProtocol;
import com.qhzk.ciep.ui.home.attend.AttendActivity;
import com.qhzk.ciep.utils.SharedPrefUtil;
import com.qhzk.ciep.view.DegreeDialog;
import com.qhzk.ciep.view.EntSizeDialog;
import com.qhzk.ciep.view.IndustryDialog;
import com.qhzk.ciep.view.MajorDialog;
import com.qhzk.ciep.view.UnitPropertyDialog;
import com.qhzk.ciep.widget.MineItemEdit;
import com.qhzk.ciep.widget.MineItemView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * Created by pucheng on 2017年1月10日14:37:17.
 * 单位及学历
 */

public class UnitEduFragment extends Fragment {

    protected String TAG = getClass().getSimpleName();

    protected View mRootView;

    @BindView(R.id.find_job)
    CheckBox mFindJob;                      //寻找工作
    @BindView(R.id.find_talent)
    CheckBox mFindTalent;                   //寻找人才
    @BindView(R.id.project_dock)
    CheckBox mProjectDock;                  //项目对接
    @BindView(R.id.technical_exchange)
    CheckBox mTechnicalExchange;            //技术交流
    @BindView(R.id.find_business)
    CheckBox mFindBusiness;                 //寻找商机
    @BindView(R.id.other)
    CheckBox mOther;                        //其他

    @BindView(R.id.next)                    //下一步
    Button mNext;

    @BindView(R.id.work_unit)               // 工作单位
    MineItemEdit mWorkUnit;
    @BindView(R.id.position)                // 职位
    MineItemEdit mPosition;
    @BindView(R.id.industry)                //行业领域
    MineItemView mIndustry;
    @BindView(R.id.unit_nature)             //单位性质
    MineItemView mUnitNature;
    @BindView(R.id.unit_size)               //单位规模
    MineItemView mUnitSize;
    @BindView(R.id.college)                 //毕业学院
    MineItemEdit mCollege;
    @BindView(R.id.degree)                  //学历学位
    MineItemView mDegree;
    @BindView(R.id.major)                   //所学专业
    MineItemView mMajor;

    public static UnitEduFragment newInstance() {
        Bundle args = new Bundle();
        UnitEduFragment fragment = new UnitEduFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private AttendActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (AttendActivity) context;
    }

    @Override
    public void onStart() {
        super.onStart();
        getFromSharedPref();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        if (mRootView == null) {
            mRootView = inflater.inflate(getLayoutId(), container, false);
        }
        ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    protected int getLayoutId() {
        return R.layout.fragment_unit_edu;
    }

    //校验用户信息是否输入完成,如果完成进入下一步
    public boolean checkUserInfo() {
        return !TextUtils.isEmpty(mWorkUnit.getValue()) && !TextUtils.isEmpty(mPosition.getValue()) &&
                !TextUtils.isEmpty(mIndustry.getValue()) && !TextUtils.isEmpty(mUnitNature.getValue()) &&
                !TextUtils.isEmpty(mUnitSize.getValue()) && !TextUtils.isEmpty(mCollege.getValue()) &&
                !TextUtils.isEmpty(mDegree.getValue()) && !TextUtils.isEmpty(mMajor.getValue());
    }

    public void getFromSharedPref() {
        mWorkUnit.setValue(SharedPrefUtil.getPrefString(this.getContext(), Constant.COMPANY, ""));
        mPosition.setValue(SharedPrefUtil.getPrefString(this.getContext(), Constant.JOB, ""));
        mIndustry.setItemValue(SharedPrefUtil.getPrefString(this.getContext(), Constant.INDUSTRY_FIELD, ""));
        mUnitNature.setItemValue(SharedPrefUtil.getPrefString(this.getContext(), Constant.INDUSTRY, ""));
        mUnitSize.setItemValue(SharedPrefUtil.getPrefString(this.getContext(), Constant.UNIT_SIZE, ""));
        mCollege.setValue(SharedPrefUtil.getPrefString(this.getContext(), Constant.UNIVERSITY, ""));
        mDegree.setItemValue(SharedPrefUtil.getPrefString(this.getContext(), Constant.DEGREE, ""));
        mMajor.setItemValue(SharedPrefUtil.getPrefString(this.getContext(), Constant.MAJOR, ""));
    }

    private void saveToSharedPref() {
        SharedPrefUtil.savePrefString(this.getContext(), Constant.COMPANY, mWorkUnit.getValue());
        SharedPrefUtil.savePrefString(this.getContext(), Constant.JOB, mPosition.getValue());
        SharedPrefUtil.savePrefString(this.getContext(), Constant.INDUSTRY_FIELD, mIndustry.getValue());
        SharedPrefUtil.savePrefString(this.getContext(), Constant.INDUSTRY, mUnitNature.getValue());
        SharedPrefUtil.savePrefString(this.getContext(), Constant.UNIT_SIZE, mUnitSize.getValue());
        SharedPrefUtil.savePrefString(this.getContext(), Constant.UNIVERSITY, mCollege.getValue());
        SharedPrefUtil.savePrefString(this.getContext(), Constant.DEGREE, mDegree.getValue());
        SharedPrefUtil.savePrefString(this.getContext(), Constant.MAJOR, mMajor.getValue());
    }

    @OnClick({R.id.industry, R.id.unit_nature, R.id.unit_size, R.id.degree, R.id.major, R.id.next})
    public void onClick(View view) {
        Dialog dialog;
        switch (view.getId()) {
            case R.id.industry:
                dialog = new IndustryDialog(this.getContext(), entsize -> mIndustry.setItemValue(entsize));
                dialog.show();
                break;
            case R.id.unit_nature:
                dialog = new UnitPropertyDialog(this.getContext(), entsize -> mUnitNature.setItemValue(entsize));
                dialog.show();
                break;
            case R.id.unit_size:
                dialog = new EntSizeDialog(this.getContext(), entsize -> mUnitSize.setItemValue(entsize));
                dialog.show();
                break;
            case R.id.degree:
                dialog = new DegreeDialog(this.getContext(), entsize -> mDegree.setItemValue(entsize));
                dialog.show();
                break;
            case R.id.major:
                dialog = new MajorDialog(this.getContext(), entsize -> mMajor.setItemValue(entsize));
                dialog.show();
                break;
            case R.id.next:
                saveToSharedPref();
                commitToServer();
                break;
        }
    }

    private void commitToServer() {
        if (checkUserInfo()) {
            saveToSharedPref();
            // 保存数据
            ParticipantProtocol protocol = new ParticipantProtocol(new CiepProtocol.Callback() {
                @Override
                public void onError(Call call, Exception e, int id) {
                    Toast.makeText(UnitEduFragment.this.getContext(), "发生错误:" + e, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onSuccess() {
                    mActivity.toStep3();
                }

                @Override
                public void onFailed() {
                    Toast.makeText(UnitEduFragment.this.getContext(), "发生错误", Toast.LENGTH_SHORT).show();
                }
            });
            AttendActivity activity = (AttendActivity) getActivity();
            String name = activity.mParmas.get("name");
            protocol.setName(name);
            String gender = activity.mParmas.get("gender");
            protocol.setGender(gender);
            String nationality = activity.mParmas.get("nationality");
            protocol.setNationality(nationality);
            String phoneNum = activity.mParmas.get("phoneNum");
            protocol.setPhoneNum(phoneNum);
            String email = activity.mParmas.get("email");
            protocol.setEmail(email);
            String company = mWorkUnit.getValue();
            protocol.setCompany(company);
            String position = mPosition.getValue();
            protocol.setPosition(position);
            String comIndustry = mIndustry.getValue();
            protocol.setComIndustry(comIndustry);
            String comType = mUnitNature.getValue();
            protocol.setComType(comType);
            String comSize = mUnitSize.getValue();
            protocol.setComSize(comSize);
            String graduated = mCollege.getValue();
            protocol.setGraduated(graduated);
            String educationlevel = mDegree.getValue();
            protocol.setEducationlevel(educationlevel);
            String major = mMajor.getValue();
            protocol.setMajor(major);
            StringBuilder purpose = new StringBuilder("");
            if (mFindJob.isChecked()) {
                purpose.append("寻找工作,");
            }
            if (mFindTalent.isChecked()) {
                purpose.append(" 寻找人才,");
            }
            if (mProjectDock.isChecked()) {
                purpose.append(" 项目对接,");
            }
            if (mTechnicalExchange.isChecked()) {
                purpose.append(" 技术交流,");
            }
            if (mFindBusiness.isChecked()) {
                purpose.append(" 寻找商机,");
            }
            if (mOther.isChecked()) {
                purpose.append(" 其他,");
            }
            if (purpose.length() > 1){
                purpose.setLength(purpose.length()-1);
            }
            String purposeStr = purpose.toString();
            protocol.setPurpose(purposeStr);
            protocol.uploadDataByPost();
        } else {
            Toast.makeText(this.getContext(), "请完善个人信息", Toast.LENGTH_SHORT).show();
        }
    }
}
