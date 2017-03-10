package com.qhzk.ciep.ui.mine.setting.feedback;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.common.okhttp.cookie.CookieJarImpl;
import com.qhzk.ciep.common.okhttp.cookie.store.CookieStore;
import com.qhzk.ciep.common.okhttp.cookie.store.PersistentCookieStore;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Cookie;

/**
 * 意见反馈 2016年12月20日10:31:14
 */
public class FeedbackActivity extends BaseActivity<FeedbackPresenter> implements FeedbackView {

    @BindView(R.id.et_advice)
    EditText mEtAdvice;
    @BindView(R.id.tv_number)
    TextView mTvNumber;
    @BindView(R.id.et_contact)
    EditText mEtContact;

    @Override
    public int getLayoutId() {
        return R.layout.activity_feedback;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    protected void initdata() {
        super.initdata();
        mEtAdvice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mTvNumber.setText(charSequence.length()+"/100");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @OnClick(R.id.btn_commit)
    public void onClick() {
        String usercode = mEtContact.getText().toString().trim();
        String content = mEtAdvice.getText().toString().trim();
        if (!TextUtils.isEmpty(usercode) && !TextUtils.isEmpty(content)) {
            mActivityPresenter.commitFeedback(getUserId(), usercode, content);
        } else {
            showToast("请完善信息");
        }

    }

    private String getUserId(){
        CookieJarImpl cookieJar = new CookieJarImpl(new PersistentCookieStore(this));
        CookieStore cookieStore = cookieJar.getCookieStore();
        String userid;
        if (cookieStore != null) {
            for (Cookie c : cookieStore.getCookies()){
                if (c.name().contains("userid")){
                    userid = c.value();
                    return userid;
                }
            }
        }
        return null;
    }

    @Override
    public void onError(Exception e) {
        showToast("网络异常:"+e);
    }

    @Override
    public void onCommitSuccess() {
        showToast("已提交成功");
    }

    @Override
    public void onCommitFailed() {
        showToast("提交失败");
    }
}
