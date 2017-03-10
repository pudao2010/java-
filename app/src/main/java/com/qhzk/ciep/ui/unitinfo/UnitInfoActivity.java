package com.qhzk.ciep.ui.unitinfo;

import android.os.Bundle;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.entity.EnterpriseBean;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 单位信息页面
 * 2016年12月26日10:11:16
 */
public class UnitInfoActivity extends BaseActivity<UnitInfoPresenter> implements UnitInfoView {

    String id;

    @BindView(R.id.org_name)
    TextView mOrgName;
    @BindView(R.id.org_location)
    TextView mOrgLocation;
    @BindView(R.id.collect)
    ImageView mCollect;
    @BindView(R.id.enttype)
    TextView mEnttype;
    @BindView(R.id.entsize)
    TextView mEntsize;
    @BindView(R.id.industry)
    TextView mIndustry;
    @BindView(R.id.project_dock)
    RelativeLayout mProjectDock;
    @BindView(R.id.talent_dock)
    RelativeLayout mTalentDock;
    @BindView(R.id.org_profile)
    TextView mOrgProfile;

    private boolean isFocus = false;
    private String entId;
    private String userId;

    @Override
    public int getLayoutId() {
        return R.layout.activity_unit_info;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        id = savedInstanceState.getString("id");
    }

    @Override
    protected void initdata() {
        super.initdata();
        mActivityPresenter.loadData(id);
        mActivityPresenter.checkFocus(id);
    }

    @OnClick({R.id.collect, R.id.project_dock, R.id.talent_dock})
    public void onClick(View view) {
        Bundle bundle;
        switch (view.getId()) {
            case R.id.collect:
                if (isFocus){
                    mActivityPresenter.cancelFocus(id);
                }else{
                    mActivityPresenter.addFocus(id);
                }
                break;
            case R.id.project_dock:
                bundle = new Bundle();
                bundle.putString("userId", userId);
                readyGo(UnitInfoProjectdockActivity.class, bundle);
                break;
            case R.id.talent_dock:
                bundle = new Bundle();
                bundle.putString("entId", entId);
                readyGo(UnitInfoTalentDockActivity.class, bundle);
                break;
        }
    }

    @Override
    public void onLoadSuccess(EnterpriseBean enterpriseBean) {
        userId = enterpriseBean.getUserId();
        entId = enterpriseBean.getId();

        if (enterpriseBean.getName() != null) {
            mOrgName.setText(enterpriseBean.getName());
        }
        String location = enterpriseBean.getRegionProv() + enterpriseBean.getRegionCity() + enterpriseBean.getRegionDistrict();
        mOrgLocation.setText(location);
        if (enterpriseBean.getEnttype() != null) {
            mEnttype.setText("性质 : "+enterpriseBean.getEnttype());
        }
        if (enterpriseBean.getEntsize() != null) {
            mEntsize.setText("规模 : "+enterpriseBean.getEntsize());
        }
        if (enterpriseBean.getIndustry() != null) {
            mIndustry.setText("单位类别 : "+enterpriseBean.getIndustry());
        }
        if (enterpriseBean.getProfile() != null) {
            mOrgProfile.setText(enterpriseBean.getProfile());
        }
    }

    @Override
    public void onAddFocusSuccess() {
        isFocus = true;
        mCollect.setImageResource(R.drawable.icon_collect_selected);
        ScaleAnimation animation = new ScaleAnimation(0.8f, 1.4f, 0.8f, 1.4f, 0.5f, 0.5f);
        animation.setDuration(700);
        mCollect.startAnimation(animation);
        showToast("关注成功");
    }

    @Override
    public void onAddFocusFailed(String error) {
        isFocus = false;
        mCollect.setImageResource(R.drawable.icon_collect_normal);
        showToast("关注失败 :"+error);
    }

    @Override
    public void onCancelFocusSuccess() {
        isFocus = false;
        mCollect.setImageResource(R.drawable.icon_collect_normal);
    }

    @Override
    public void onCancelFocusFailed(String error) {
        isFocus = true;
        mCollect.setImageResource(R.drawable.icon_collect_selected);
    }

    @Override
    public void onCheckFocusResult(boolean b) {
        isFocus = b;
        if (b){
            mCollect.setImageResource(R.drawable.icon_collect_selected);
        }else{
            mCollect.setImageResource(R.drawable.icon_collect_normal);
        }
    }
}
