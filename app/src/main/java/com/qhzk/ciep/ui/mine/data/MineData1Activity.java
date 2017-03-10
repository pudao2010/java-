package com.qhzk.ciep.ui.mine.data;

import android.app.Dialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.view.CiepDataPicker;
import com.qhzk.ciep.view.CountrySelectDialog;
import com.qhzk.ciep.view.DegreeDialog;
import com.qhzk.ciep.view.EntSizeDialog;
import com.qhzk.ciep.view.IndustryDialog;
import com.qhzk.ciep.view.MajorDialog;
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
 * Created by pucheng on 2017/1/7.
 * 个人资料
 */

public class MineData1Activity extends BaseActivity<MineData1Presenter> implements MineData1View{
    @BindView(R.id.chinese_name)
    MineItemEdit mChineseName;
    @BindView(R.id.english_name)
    MineItemEdit mEnglishName;
    @BindView(R.id.country)
    MineItemView mCountry;
    @BindView(R.id.woman)
    RadioButton mWoman;
    @BindView(R.id.man)
    RadioButton mMan;
    @BindView(R.id.layout_radio)
    RadioGroup mLayoutRadio;
    @BindView(R.id.birthday)
    MineItemView mBirthday;
    @BindView(R.id.mobile)
    MineItemEdit mMobile;
    @BindView(R.id.email)
    MineItemEdit mEmail;
    @BindView(R.id.work_unit)
    MineItemEdit mWorkUnit;
    @BindView(R.id.work_position)
    MineItemEdit mWorkPosition;
    @BindView(R.id.unit_nature)
    MineItemView mUnitNature;
    @BindView(R.id.unit_size)
    MineItemView mUnitSize;
    @BindView(R.id.college)
    MineItemEdit mCollege;
    @BindView(R.id.degree)
    MineItemView mDegree;
    @BindView(R.id.major)
    MineItemView mMajor;
    @BindView(R.id.industry)
    MineItemView mIndustry;
    @BindView(R.id.language)
    MineItemEdit mLanguage;
    @BindView(R.id.word)
    EditText mWord;
    @BindView(R.id.find_job)
    CheckBox mFindJob;
    @BindView(R.id.find_talent)
    CheckBox mFindTalent;
    @BindView(R.id.project_dock)
    CheckBox mProjectDock;
    @BindView(R.id.technical_exchange)
    CheckBox mTechnicalExchange;
    @BindView(R.id.find_business)
    CheckBox mFindBusiness;
    @BindView(R.id.other)
    CheckBox mOther;
    @BindView(R.id.info_1)
    TextView mDescNumber;
    private String chineseName;
    private String englishName;
    private String country;
    private String gender;
    private String birth;
    private String mobile;
    private String email;
    private String workUnit;
    private String position;
    private String unitNature;
    private String unitSize;
    private String college;
    private String degree;
    private String major;
    private String industry;
    private String language;
    private String desc;
    private String purpose;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_data1;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());
        mWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mDescNumber.setText(String.format("%d/500", charSequence.length()));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @OnClick({R.id.toolbar_right_title, R.id.country, R.id.birthday, R.id.unit_nature, R.id.unit_size, R.id.degree, R.id.major,R.id.industry})
    public void onClick(View view) {
        Dialog dialog;
        switch (view.getId()) {
            case R.id.toolbar_right_title:
                getValue();
                commitToServer();
                break;
            case R.id.country:
                dialog = new CountrySelectDialog(this, country -> mCountry.setItemValue(country));
                dialog.show();
                break;
            case R.id.birthday:
//                dialog = new BirthdayDialog(this, birth -> mBirthday.setItemValue(birth));
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
                        mBirthday.setItemValue(year1 + "-" + (month1+1) + "-" + dayOfMonth), year, month, day);
                ciepdialog.getDatePicker().setMaxDate(date.getTime());
                ciepdialog.show();
                break;
            case R.id.unit_nature:
                dialog = new UnitPropertyDialog(this, entsize -> mUnitNature.setItemValue(entsize));
                dialog.show();
                break;
            case R.id.unit_size:
                dialog = new EntSizeDialog(this, entsize -> mUnitSize.setItemValue(entsize));
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
            case R.id.industry:
                dialog = new IndustryDialog(this, entsize -> mIndustry.setItemValue(entsize));
                dialog.show();
                break;
        }
    }
    // 提交到服务器
    private void commitToServer() {
        Map<String,String> mParmasMap = new HashMap<>();
        if (!TextUtils.isEmpty(chineseName)){
            mParmasMap.put("participant.name", chineseName);        //姓名
        }
        if (!TextUtils.isEmpty(country)){
            mParmasMap.put("participant.nationality", country);     //国籍
        }
        if (!TextUtils.isEmpty(gender)){
            mParmasMap.put("participant.gender", gender);           //性别
        }
        if (!TextUtils.isEmpty(mobile)){
            mParmasMap.put("participant.phoneNum", mobile);         // 手机
        }
        if (!TextUtils.isEmpty(email)){
            mParmasMap.put("participant.email", email);             // 邮箱
        }
        if (!TextUtils.isEmpty(workUnit)){
            mParmasMap.put("participant.company", workUnit);        //工作单位
        }
        if (!TextUtils.isEmpty(position)){
            mParmasMap.put("participant.position", position);       // 职位
        }
        if (!TextUtils.isEmpty(industry)){
            mParmasMap.put("participant.comIndustry", industry);    //行业领域
        }
        if (!TextUtils.isEmpty(unitNature)){
            mParmasMap.put("participant.comType", unitNature);      // 单位性质
        }
        if (!TextUtils.isEmpty(unitSize)){
            mParmasMap.put("participant.comSize", unitSize);        //单位规模
        }
        if (!TextUtils.isEmpty(college)){
            mParmasMap.put("participant.graduated", college);       //毕业学校
        }
        if (!TextUtils.isEmpty(degree)){
            mParmasMap.put("participant.educationlevel", degree);   //学历学位
        }
        if (!TextUtils.isEmpty(major)){
            mParmasMap.put("participant.major", major);             // 所学专业
        }
        if (!TextUtils.isEmpty(purpose)){
            mParmasMap.put("participant.purpose", purpose);         // 来访目的
        }

        mActivityPresenter.commitMineData(mParmasMap);
    }

    private void getValue() {
        chineseName = mChineseName.getValue();
        englishName = mEnglishName.getValue();
        country = mCountry.getValue();
        // 性别
        gender = mWoman.isChecked() ? "女" : "男";
        birth = mBirthday.getValue();
        mobile = mMobile.getValue();
        email = mEmail.getValue();
        workUnit = mWorkUnit.getValue();
        position = mWorkPosition.getValue();
        unitNature = mUnitNature.getValue();
        unitSize = mUnitSize.getValue();
        college = mCollege.getValue();
        degree = mDegree.getValue();
        major = mMajor.getValue();
        industry = mIndustry.getValue();
        language = mLanguage.getValue();
        desc = mWord.getText().toString().trim();
        // 来访目的, 用逗号拼接字符串
        StringBuilder sb = new StringBuilder();
        if (mFindJob.isChecked()){
            sb.append("寻找工作,");
        }
        if (mFindTalent.isChecked()){
            sb.append("寻找人才,");
        }
        if (mProjectDock.isChecked()){
            sb.append("项目对接,");
        }
        if (mTechnicalExchange.isChecked()){
            sb.append("技术交流,");
        }
        if (mFindBusiness.isChecked()){
            sb.append("寻找商机,");
        }
        if (mOther.isChecked()){
            sb.append("其他,");
        }
        if (sb.length() > 1){
            sb.setLength(sb.length()-1);
        }
        purpose = sb.toString();
    }

    @Override
    public void onCommitSuccess() {
        showToast("保存成功");
        finish();
    }
}
