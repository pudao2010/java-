package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.forum;

import android.os.Bundle;
import android.widget.TextView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.entity.AreaDetailBean;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

import butterknife.BindView;

public class ForumDetailActivity extends BaseActivity<ForumDetailPresenter> implements ForumDetailView {

    @BindView(R.id.forum_detail)
    WebView mDetail;
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    private String detail;
    private String id;

    @Override
    public int getLayoutId() {
        return R.layout.activity_forum_detail;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        detail = savedInstanceState.getString("detail");
        id = savedInstanceState.getString("id");
    }

    @Override
    protected void initview() {
        super.initview();
        mDetail.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mToolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    protected void initdata() {
        super.initdata();
        if (detail != null) {
            String replace = detail.replace("<img", "<img style='max-width:90%;height:auto;'");
            mDetail.loadDataWithBaseURL(ServiceConfig.BASEURL, replace, "text/html", "utf-8", null);
        }

        if (id != null){
            mToolbarTitle.setText("展区详情");
            System.out.println("id========="+id);
            mActivityPresenter.loadData(id);
        }
    }

    @Override
    public void onLoadSuccess(AreaDetailBean areaDetailBean) {
        String detail = areaDetailBean.getArea().getDetail();
        String replace = detail.replace("<img", "<img style='max-width:90%;height:auto;'");
        mDetail.loadDataWithBaseURL(ServiceConfig.BASEURL, replace, "text/html", "utf-8", null);
    }

    @Override
    public void onError(Exception e) {
        showToast("网络异常");
    }

}
