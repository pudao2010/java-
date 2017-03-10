package com.qhzk.ciep.ui.mine.data;

import com.qhzk.ciep.base.BaseActivity;

/**
 * Created by pudao on 2016/11/9.
 * 个人资料页面
 */

public class MineDataActivity extends BaseActivity<MineDataPresenter> implements MineDataView {
    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void onUploadSuccess() {

    }

    @Override
    public void onUploadFailed() {

    }

//    @BindView(R.id.chinese_name)
//    TextView mChineseName; //中文姓名
//    @BindView(R.id.english_name)
//    TextView mEnglishName; //英文姓名
////    @BindView(R.id.country)
////    TextView mCountry; // 国籍
//    @BindView(R.id.birthday)
//    TextView mBirthday; // 出生年月
//    @BindView(R.id.mobilephone)
//    TextView mMobilephone; // 联系电话
//    @BindView(R.id.email)
//    TextView mEmail; // 电子邮箱
//    @BindView(R.id.company)
//    TextView mCompany; // 工作单位
//    @BindView(R.id.job)
//    TextView mJob; // 职位
//    @BindView(R.id.industry)
//    TextView mIndustry; // 单位性质
//    @BindView(R.id.unit_size)
//    TextView mUnitSize; // 单位规模
//    @BindView(R.id.university)
//    TextView mUniversity; // 毕业学院
//    @BindView(R.id.education)
//    TextView mEducation; // 学历学位
//    @BindView(R.id.major)
//    TextView mMajor; // 所学专业
//    @BindView(R.id.industry_field)
//    TextView mIndustryField; // 行业领域
//    @BindView(R.id.master_language)
//    TextView mMasterLanguage; // 掌握语言
//    @BindView(R.id.word)
//    EditText mWord; // 工作描述
//    @BindView(R.id.find_job)
//    CheckBox mFindJob; //寻找工作
//    @BindView(R.id.find_talent)
//    CheckBox mFindTalent; // 寻找人才
//    @BindView(R.id.project_dock)
//    CheckBox mProjectDock; // 项目对接
//    @BindView(R.id.technical_exchange)
//    CheckBox mTechnicalExchange; // 技术交流
//    @BindView(R.id.find_business)
//    CheckBox mFindBusiness; // 寻找商机
//    @BindView(R.id.other)
//    CheckBox mOther; //其他
//    @BindView(R.id.layout_radio)
//    RadioGroup mGenderContainer;
//    @BindView(R.id.info_1)
//    TextView mDescNumber;
//    private BirthdayDialog birthdayDialog;
//    private EntSizeDialog entSizeDialog;
//
//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_mine_data;
//    }
//
//    @Override
//    protected void initview() {
//        super.initview();
//        mToolbar.setNavigationOnClickListener(v -> finish());
//        mWord.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                mDescNumber.setText(String.format("%d/500", charSequence.length()));
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//
//    }
//
//    @Override
//    protected void initdata() {
//        super.initdata();
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        getFromSharedPref();
//    }
//
//    @OnClick({R.id.layout_ch_name, R.id.layout_en_name,
//            /*R.id.layout_nationality,*/ R.id.layout_gender,
//            R.id.layout_date, R.id.layout_phone, R.id.layout_email,
//            R.id.layout_work, R.id.layout_job, R.id.layout_unit_nature,
//            R.id.layout_unit_scale, R.id.layout_college, R.id.layout_degree,
//            R.id.layout_major, R.id.layout_territory, R.id.layout_language,
//            R.id.toolbar_right_title})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.toolbar_right_title:
//                //TODO 提交保存, 保存在本地sharedpreference文件中
//                saveToSharePref();
////                mActivityPresenter.uploadData();
//                ParticipantProtocol protocol = new ParticipantProtocol(new CiepProtocol.Callback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//                        showToast("错误发生:"+e);
//                    }
//
//                    @Override
//                    public void onSuccess() {
//                        showToast("保存成功");
//                        finish();
//                    }
//
//                    @Override
//                    public void onFailed() {
//                        showToast("保存失败");
//                    }
//                });
//                protocol.setName(mChineseName.getText().toString());
//                int checkedRadioButtonId = mGenderContainer.getCheckedRadioButtonId();
//                if (checkedRadioButtonId==R.id.woman){
//                    protocol.setGender("女");
//                }else{
//                    protocol.setGender("男");
//                }
//                //TODO
//
//                protocol.uploadDataByPost();
//                break;
//            case R.id.layout_ch_name:
//                createInputDialog("中文姓名", InputType.TYPE_CLASS_TEXT |
//                                InputType.TYPE_TEXT_VARIATION_PERSON_NAME |
//                                InputType.TYPE_TEXT_FLAG_CAP_WORDS, 1, 16
//                        , "请输入中文姓名", null, true, (dialog, input) -> mChineseName.setText(input.toString()));
//                break;
//            case R.id.layout_en_name:
//                createInputDialog("英文姓名", InputType.TYPE_CLASS_TEXT |
//                                InputType.TYPE_TEXT_VARIATION_PERSON_NAME |
//                                InputType.TYPE_TEXT_FLAG_CAP_WORDS, 1, 32
//                        , "请输入英文姓名", null, true, (dialog, input) -> mEnglishName.setText(input.toString()));
//                break;
//            case R.id.layout_gender:
//                // 性别
//                break;
//            case R.id.layout_date:
//                if (birthdayDialog == null){
//                    birthdayDialog = new BirthdayDialog(this, birth -> mBirthday.setText(birth));
//                }
//                birthdayDialog.show();
//                break;
//            case R.id.layout_phone:
//                createInputDialog("联系电话", InputType.TYPE_CLASS_PHONE, 1, 11
//                        , "请输入联系电话", null, true, (dialog, input) -> mMobilephone.setText(input.toString()));
//                break;
//            case R.id.layout_email:
//                createInputDialog("电子邮箱", InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS, 1, 64
//                        , "请输入电子邮箱", null, true, (dialog, input) -> mEmail.setText(input.toString()));
//                break;
//            case R.id.layout_work:
//                createInputDialog("工作单位", InputType.TYPE_CLASS_TEXT, 1, 32
//                        , "请输入工作单位", null, true, (dialog, input) -> mCompany.setText(input.toString().trim()));
//                break;
//            case R.id.layout_job:
//                createInputDialog("职位", InputType.TYPE_CLASS_TEXT, 1, 32
//                        , "请输入职位", null, true, (dialog, input) -> mJob.setText(input.toString()));
//                break;
//            case R.id.layout_unit_nature:
//               new UnitPropertyDialog(this, entsize -> mIndustry.setText(entsize)).show();
//                break;
//            case R.id.layout_unit_scale:
//                if (entSizeDialog == null){
//                    entSizeDialog = new EntSizeDialog(this, entsize -> mUnitSize.setText(entsize));
//                }
//                entSizeDialog.show();
//                break;
//            case R.id.layout_college:
//                createInputDialog("毕业学院", InputType.TYPE_CLASS_TEXT, 1, 32
//                        , "请输入毕业学院", null, true, (dialog, input) -> mUniversity.setText(input.toString().trim()));
//                break;
//            case R.id.layout_degree:
//                new DegreeDialog(this, entsize -> mEducation.setText(entsize)).show();
//                break;
//            case R.id.layout_major:
//                new MajorDialog(this, entsize -> mMajor.setText(entsize)).show();
//                break;
//            case R.id.layout_territory:
//                new IndustryDialog(this, entsize -> mIndustryField.setText(entsize)).show();
//                break;
//            case R.id.layout_language:
//                createInputDialog("掌握语言", InputType.TYPE_CLASS_TEXT, 1, 32
//                        , "请输入掌握语言", null, true, (dialog, input) -> mMasterLanguage.setText(input.toString().trim()));
//                break;
//        }
//    }
//
//    private void saveToSharePref() {
//        SharedPrefUtil.savePrefString(this, Constant.CHINESE_NAME, mChineseName.getText().toString());
//        SharedPrefUtil.savePrefString(this, Constant.ENGLISH_NAME, mEnglishName.getText().toString());
////        SharedPrefUtil.savePrefString(this, Constant.COUNTRY, mCountry.toString());
//
//        int checkedRadioButtonId = mGenderContainer.getCheckedRadioButtonId();
//        if (checkedRadioButtonId == R.id.woman) {
//            SharedPrefUtil.savePrefString(this, Constant.GENDER, "woman");
//        } else {
//            SharedPrefUtil.savePrefString(this, Constant.GENDER, "man");
//        }
//
//        SharedPrefUtil.savePrefString(this, Constant.BIRTHDAY, mBirthday.getText().toString());
//        SharedPrefUtil.savePrefString(this, Constant.MOBILEPHONE, mMobilephone.getText().toString());
//        SharedPrefUtil.savePrefString(this, Constant.EMAIL, mEmail.getText().toString());
//        SharedPrefUtil.savePrefString(this, Constant.COMPANY, mCompany.getText().toString());
//        SharedPrefUtil.savePrefString(this, Constant.JOB, mJob.getText().toString());
//        SharedPrefUtil.savePrefString(this, Constant.INDUSTRY, mIndustry.getText().toString());
//        SharedPrefUtil.savePrefString(this, Constant.UNIT_SIZE, mUnitSize.getText().toString());
//        SharedPrefUtil.savePrefString(this, Constant.UNIVERSITY, mUniversity.getText().toString());
//        SharedPrefUtil.savePrefString(this, Constant.DEGREE, mEducation.getText().toString());
//        SharedPrefUtil.savePrefString(this, Constant.MAJOR, mMajor.getText().toString());
//        SharedPrefUtil.savePrefString(this, Constant.INDUSTRY_FIELD, mIndustryField.getText().toString());
//        SharedPrefUtil.savePrefString(this, Constant.MASTER_LANGUAGE, mMasterLanguage.getText().toString());
//        SharedPrefUtil.savePrefString(this, Constant.JOB_DESC, "爱工作,爱生活"); // 工作描述
//    }
//
//    private void createInputDialog(String content, int type, int minLength, int maxLength, String hint, String prefill,
//                                   boolean allowEmptyInput, MaterialDialog.InputCallback callback) {
//        new MaterialDialog.Builder(this)
//                .title("个人资料")
//                .content(content)
//                .inputType(type)
//                .inputRange(minLength, maxLength)
//                .positiveText("保存")
//                .negativeText("取消")
//                .input(hint, prefill, allowEmptyInput, callback).show();
//    }
//
//    public void getFromSharedPref() {
//        mChineseName.setText(SharedPrefUtil.getPrefString(this, Constant.CHINESE_NAME, ""));
//        mEnglishName.setText(SharedPrefUtil.getPrefString(this, Constant.ENGLISH_NAME, ""));
////        mCountry.setText(SharedPrefUtil.getPrefString(this, Constant.COUNTRY, ""));
//        String gender = SharedPrefUtil.getPrefString(this, Constant.GENDER, "");
//        if (gender.equals("woman")) {
//            mGenderContainer.check(R.id.woman);
//        } else {
//            mGenderContainer.check(R.id.man);
//        }
//        mBirthday.setText(SharedPrefUtil.getPrefString(this, Constant.BIRTHDAY, ""));
//        mMobilephone.setText(SharedPrefUtil.getPrefString(this, Constant.MOBILEPHONE, ""));
//        mEmail.setText(SharedPrefUtil.getPrefString(this, Constant.EMAIL, ""));
//        mCompany.setText(SharedPrefUtil.getPrefString(this, Constant.COMPANY, ""));
//        mJob.setText(SharedPrefUtil.getPrefString(this, Constant.JOB, ""));
//        mIndustry.setText(SharedPrefUtil.getPrefString(this, Constant.INDUSTRY, ""));
//        mUnitSize.setText(SharedPrefUtil.getPrefString(this, Constant.UNIT_SIZE, ""));
//        mUniversity.setText(SharedPrefUtil.getPrefString(this, Constant.UNIVERSITY, ""));
//        mEducation.setText(SharedPrefUtil.getPrefString(this, Constant.DEGREE, ""));
//        mMajor.setText(SharedPrefUtil.getPrefString(this, Constant.MAJOR, ""));
//        mIndustryField.setText(SharedPrefUtil.getPrefString(this, Constant.INDUSTRY_FIELD, ""));
//        mMasterLanguage.setText(SharedPrefUtil.getPrefString(this, Constant.MASTER_LANGUAGE, ""));
//    }
//
//    @Override
//    public void onUploadSuccess() {
//        showToast("成功");
//    }
//
//    @Override
//    public void onUploadFailed() {
//        showToast("失败");
//    }
}
