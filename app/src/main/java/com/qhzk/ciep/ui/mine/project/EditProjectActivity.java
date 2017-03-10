package com.qhzk.ciep.ui.mine.project;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.entity.ProjectManage;
import com.qhzk.ciep.protocol.CiepProtocol;
import com.qhzk.ciep.protocol.PublishProjectProtocol;
import com.qhzk.ciep.protocol.UpdateProjectProtocol;
import com.qhzk.ciep.view.IndustryDialog;
import com.qhzk.ciep.view.ProjectTypeDialog;
import com.qhzk.ciep.widget.MineItemEdit;
import com.qhzk.ciep.widget.MineItemView;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 编辑项目 2016年12月30日11:18:12
 */
public class EditProjectActivity extends BaseActivity {

    @BindView(R.id.project_name)
    MineItemEdit mProjectname;
    @BindView(R.id.project_category)
    MineItemView mProjectCategory;
    @BindView(R.id.industry_field)
    MineItemView mIndustryField;
    @BindView(R.id.project_contact)
    MineItemEdit mProjectContact;
    @BindView(R.id.contact_title)
    MineItemEdit mContactTitle;
    @BindView(R.id.contact_mobile)
    MineItemEdit mMobile;
    @BindView(R.id.contact_phone)
    MineItemEdit mPhone;
    @BindView(R.id.contact_email)
    MineItemEdit mEmail;
    @BindView(R.id.contact_fax)
    MineItemEdit mFax;
    @BindView(R.id.number)
    TextView mNumber;
    @BindView(R.id.desc)
    EditText mDesc;


    private boolean isUpdate = false;   //是否是修改项目,默认为false
    private ProjectManage projectManage;
    private String id;                  // 需要修改项目时用的id

    @Override
    public int getLayoutId() {
        return R.layout.activity_edit_project;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        projectManage = (ProjectManage) savedInstanceState.getSerializable("serializable");
        if (projectManage != null) {
            isUpdate = true;
        }else{
            isUpdate = false;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (isUpdate){
            id = projectManage.getId();
            String name = projectManage.getName();
            if (name != null) {
                mProjectname.setValue(name);
            }
            String type = projectManage.getType();
            if (type != null) {
                mProjectCategory.setItemValue(type);
            }
            String sector = projectManage.getSector();
            if (sector != null) {
                mIndustryField.setItemValue(sector);
            }
            String contacts = projectManage.getContacts();
            if (contacts != null) {
                mProjectContact.setValue(contacts);
            }
            String contactstitle = projectManage.getContactstitle();
            if (contactstitle != null) {
                mContactTitle.setValue(contactstitle);
            }
            String mobile = projectManage.getMobile();
            if (mobile != null) {
                mMobile.setValue(mobile);
            }
            String phone = projectManage.getPhone();
            if (phone != null) {
                mPhone.setValue(phone);
            }
            String email = projectManage.getEmail();
            if (email != null) {
                mEmail.setValue(email);
            }
            String fax = projectManage.getFax();
            if (fax != null) {
                mFax.setValue(fax);
            }
            String introduction = projectManage.getIntroduction();
            if (introduction != null) {
                mDesc.setText(introduction);
            }

        }
    }

    @Override
    protected void initview() {
        super.initview();

        mToolbar.setNavigationOnClickListener(v -> finish());

        mDesc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mNumber.setText(new StringBuilder().append(charSequence.length()).append("/500").toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @OnClick({R.id.tootbar_right_title, R.id.project_category, R.id.industry_field})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tootbar_right_title:
                // 保存
                String name = mProjectname.getValue();
                System.out.println("测试项目名================"+name);
                String type = mProjectCategory.getValue();
                System.out.println("测试行业领域================"+type);
                String sector = mIndustryField.getValue();
                System.out.println("测试项目类别================"+sector);
                String contacts = mProjectContact.getValue();
                System.out.println("测试项目联系人================"+contacts);
                String contactstitle = mContactTitle.getValue();
                System.out.println("测试项目联系人职务================"+contactstitle);
                String mobile = mMobile.getValue();
                System.out.println("测试手机号================"+mobile);
                String phone = mPhone.getValue();
                System.out.println("测试电话================"+phone);
                String email = mEmail.getValue();
                System.out.println("测试邮箱================"+email);
                String fax = mFax.getValue();
                System.out.println("测试传真================"+fax);
                String introduction = mDesc.getText().toString();
                System.out.println("测试项目介绍================"+introduction);
                if (TextUtils.isEmpty(name) ||
                        TextUtils.isEmpty(type) ||
                        TextUtils.isEmpty(sector) ||
                        TextUtils.isEmpty(contacts) ||
                        TextUtils.isEmpty(contactstitle) ||
                        TextUtils.isEmpty(mobile) ||
                        TextUtils.isEmpty(phone) ||
                        TextUtils.isEmpty(email) ||
                        TextUtils.isEmpty(fax) ||
                        TextUtils.isEmpty(introduction)){
                    showToast("请完善项目信息");
                    return;
                }
                if (isUpdate){
                    UpdateProjectProtocol protocol = new UpdateProjectProtocol(new CiepProtocol.Callback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            showToast("错误发生了:"+e);
                        }

                        @Override
                        public void onSuccess() {
                            showToast("操作成功");
                            setResult(RESULT_OK);
                            finish();
                        }

                        @Override
                        public void onFailed() {
                            showToast("操作失败");
                        }
                    });
                    protocol.setId(id);
                    protocol.setName(name);
                    protocol.setType(type);
                    protocol.setSector(sector);
                    protocol.setContacts(contacts);
                    protocol.setContactstitle(contactstitle);
                    protocol.setEmail(email);
                    protocol.setFax(fax);
                    protocol.setMobile(mobile);
                    protocol.setPhone(phone);
                    protocol.setIntroduction(introduction);
                    protocol.uploadDataByPost();
                }
                if (!isUpdate){
                    PublishProjectProtocol protocol = new PublishProjectProtocol(new CiepProtocol.Callback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            showToast("错误发生了:"+e);
                        }

                        @Override
                        public void onSuccess() {
                            showToast("操作成功");
                            setResult(RESULT_OK);
                            finish();
                        }

                        @Override
                        public void onFailed() {
                            showToast("操作失败");
                        }
                    });

                    protocol.setName(name);
                    protocol.setType(type);
                    protocol.setSector(sector);
                    protocol.setContacts(contacts);
                    protocol.setContactstitle(contactstitle);
                    protocol.setEmail(email);
                    protocol.setFax(fax);
                    protocol.setMobile(mobile);
                    protocol.setPhone(phone);
                    protocol.setIntroduction(introduction);
                    protocol.uploadDataByPost();
                }

                break;
            case R.id.project_category:
                // 弹出项目类别对话框
                new ProjectTypeDialog(this, entsize -> mProjectCategory.setItemValue(entsize)).show();
                break;
            case R.id.industry_field:
                // 弹出行业领域对话框
                new IndustryDialog(this, entsize -> mIndustryField.setItemValue(entsize)).show();
                break;
        }
    }
}
