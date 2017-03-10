package com.qhzk.ciep.ui.mine.resume.reset_data;

import android.app.Dialog;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lljjcoder.citypickerview.widget.CityPicker;
import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.config.Constant;
import com.qhzk.ciep.entity.Resume;
import com.qhzk.ciep.entity.ResumeEntity;
import com.qhzk.ciep.utils.SharedPrefUtil;
import com.qhzk.ciep.view.CiepDataPicker;
import com.qhzk.ciep.view.CountrySelectDialog;
import com.qhzk.ciep.view.SalaryDialog;
import com.qhzk.ciep.view.WorkyearDialog;
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
 * 修改个人信息页面
 */

public class MineResetDataActivity extends BaseActivity<MineResetDataPresenter> implements MineResetDataView {

    @BindView(R.id.toolbar_right_title)
    TextView mToolbarRightTitle;
    @BindView(R.id.chinese_name)
    MineItemEdit mChineseName;
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
    @BindView(R.id.work_year)
    MineItemView mWorkYear;
    @BindView(R.id.current_salary)
    MineItemView mCurrentSalary;
    @BindView(R.id.current_city)
    MineItemView mCurrentCity;
    @BindView(R.id.height)
    MineItemEdit mHeight;
    @BindView(R.id.unmarried)
    RadioButton mUnmarried;
    @BindView(R.id.married)
    RadioButton mMarried;
    @BindView(R.id.layout_radio_m)
    RadioGroup mLayoutRadioM;
    @BindView(R.id.country)
    MineItemView mCountry;
    @BindView(R.id.wechat)
    MineItemEdit mWechat;

    String userid;
    String mId;
    private String realName;
    private String gender;
    private String birthday;
    private String mobile;
    private String email;
    private String workYear;
    private String salary;
    private String city;
    private String height;
    private String marry;
    private String country;
    private String wechat;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_reset_data;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    protected void initdata() {
        super.initdata();
        mActivityPresenter.getResumeId();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getFromSharePref();
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
            mCurrentCity.setItemValue(String.format("%s%s", province, city));
        });
    }

    @Override
    public void onLoadSuccess(ResumeEntity resumeEntity) {
        mId = resumeEntity.getId();
        System.out.println("resume的id===========" + mId);
//        getResumeId();
    }

    @Override
    public void onCommitResumeInfoSuccess() {
        showToast("保存成功");
        finish();
    }

    @Override
    public void onLoadResume(Resume resume) {
        if (resume.getResume() != null) {
            userid = resume.getResume().getUserid();
            mId = resume.getResume().getId();
            if (resume.getResume().getName() != null) {
                mChineseName.setValue(resume.getResume().getName());
            }
        }


    }

    @OnClick({R.id.toolbar_right_title, R.id.birthday, R.id.work_year, R.id.current_salary, R.id.current_city, R.id.country})
    public void onClick(View view) {
        Dialog dialog;
        switch (view.getId()) {
            case R.id.toolbar_right_title:
                getValue();
                saveToSharePref();
                commitToServer();
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
            case R.id.work_year:
                dialog = new WorkyearDialog(this, entsize -> mWorkYear.setItemValue(entsize));
                dialog.show();
                break;
            case R.id.current_salary:
                dialog = new SalaryDialog(this, entsize -> mCurrentSalary.setItemValue(entsize));
                dialog.show();
                break;
            case R.id.current_city:
                showCityPicker();
                break;
            case R.id.country:
                dialog = new CountrySelectDialog(this, country1 -> mCountry.setItemValue(country1));
                dialog.show();
                break;

        }
    }

    private void saveToSharePref() {
//        SharedPrefUtil.savePrefString(this, Constant.CHINESE_NAME, realName);
        SharedPrefUtil.savePrefString(this, Constant.GENDER, gender);
        SharedPrefUtil.savePrefString(this, Constant.BIRTHDAY, birthday);
        SharedPrefUtil.savePrefString(this, Constant.MOBILEPHONE, mobile);
        SharedPrefUtil.savePrefString(this, Constant.EMAIL, email);
        SharedPrefUtil.savePrefString(this, Constant.WORKYEAR, workYear);
        SharedPrefUtil.savePrefString(this, Constant.CURRENT_SALARY, salary);
        SharedPrefUtil.savePrefString(this, Constant.CURRENT_CITY, city);
        SharedPrefUtil.savePrefString(this, Constant.HEIGHT, height);
        SharedPrefUtil.savePrefString(this, Constant.MARRY, marry);
        SharedPrefUtil.savePrefString(this, Constant.COUNTRY, country);
        SharedPrefUtil.savePrefString(this, Constant.WECHAT, wechat);
    }

    public void getFromSharePref() {
        mChineseName.setValue(SharedPrefUtil.getPrefString(this, Constant.CHINESE_NAME, ""));
        String gender = SharedPrefUtil.getPrefString(this, Constant.GENDER, "");
        if ("女".equals(gender)){
            mWoman.setChecked(true);
        }else {
            mMan.setChecked(true);
        }
        mBirthday.setItemValue(SharedPrefUtil.getPrefString(this, Constant.BIRTHDAY, ""));
        mMobile.setValue(SharedPrefUtil.getPrefString(this, Constant.MOBILEPHONE, ""));
        mEmail.setValue(SharedPrefUtil.getPrefString(this, Constant.EMAIL, ""));
        mWorkYear.setItemValue(SharedPrefUtil.getPrefString(this, Constant.WORKYEAR, ""));
        mCurrentSalary.setItemValue(SharedPrefUtil.getPrefString(this, Constant.CURRENT_SALARY, ""));
        mCurrentCity.setItemValue(SharedPrefUtil.getPrefString(this, Constant.CURRENT_CITY, ""));
        mHeight.setValue(SharedPrefUtil.getPrefString(this, Constant.HEIGHT, ""));
        String marry = SharedPrefUtil.getPrefString(this, Constant.MARRY, "");
        if ("已婚".equals(marry)){
            mMarried.setChecked(true);
        }else {
            mUnmarried.setChecked(true);
        }
        mCountry.setItemValue(SharedPrefUtil.getPrefString(this, Constant.COUNTRY, ""));
        mWechat.setValue(SharedPrefUtil.getPrefString(this, Constant.WECHAT, ""));
    }

    // 获取属性值
    private void getValue() {
        realName = mChineseName.getValue();
        gender = mWoman.isChecked() ? "女" : "男";
        birthday = mBirthday.getValue();
        mobile = mMobile.getValue();
        email = mEmail.getValue();
        workYear = mWorkYear.getValue();
        salary = mCurrentSalary.getValue();
        city = mCurrentCity.getValue();
        height = mHeight.getValue();
        if (mUnmarried.isChecked()) {
            marry = "未婚";
        } else {
            marry = "已婚";
        }
        country = mCountry.getValue();
        wechat = mWechat.getValue();
        System.out.println(realName + gender +birthday +mobile+email+workYear+salary+city+height+marry+country+wechat);
    }

    private void commitToServer() {
        Map<String,String> mParmasMap = new HashMap<>();
        mParmasMap.put("updateType", "0");
        if (!TextUtils.isEmpty(mId)) {                          // 简历ID
            mParmasMap.put("resumeInfo.id", mId);
        }
        if (!TextUtils.isEmpty(userid)) {                       // 简历对应用户id
            mParmasMap.put("userid", userid);
        }
        if (!TextUtils.isEmpty(realName)) {
            mParmasMap.put("resumeInfo.name", realName);        //姓名 :
        }
        if (!TextUtils.isEmpty(gender)) {
            mParmasMap.put("resumeInfo.gender", gender);        // 性别: 男 / 女
        }
        if (!TextUtils.isEmpty(birthday)) {
            mParmasMap.put("resumeInfo.birthday", birthday);    //生日: 2016-11-01
        }
        if (!TextUtils.isEmpty(mobile)) {
            mParmasMap.put("resumeInfo.mobile", mobile);        // 手机
        }
        if (!TextUtils.isEmpty(email)) {
            mParmasMap.put("resumeInfo.email", email);          // 邮箱
        }

        if (!TextUtils.isEmpty(workYear)) {
            mParmasMap.put("resumeInfo.yearsofwork", workYear); //工作年限
        }

        if (!TextUtils.isEmpty(city)) {
            mParmasMap.put("resumeInfo.residency", city);       // 居住地 格式:
        }

        if (!TextUtils.isEmpty(salary)) {
            mParmasMap.put("resumeInfo.salary", salary);        // 薪水: 20000元
        }

        if (!TextUtils.isEmpty(height)) {
            mParmasMap.put("resumeInfo.height", height);        // 身高: 180
        }

        if (!TextUtils.isEmpty(marry)) {
            mParmasMap.put("resumeInfo.maritalstatus", marry);  // 婚姻状态: 未婚 / 已婚
        }

        if (!TextUtils.isEmpty(country)) {
            mParmasMap.put("resumeInfo.country", country);         // 国籍
        }

        if (!TextUtils.isEmpty(wechat)) {
            mParmasMap.put("resumeInfo.wechat", wechat);        // 微信
        }
        mActivityPresenter.commitResumeInfo(mParmasMap);
    }
}
