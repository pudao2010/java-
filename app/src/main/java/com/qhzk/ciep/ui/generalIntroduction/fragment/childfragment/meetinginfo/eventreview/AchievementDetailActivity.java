package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.eventreview;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.config.ServiceConfig;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/28.
 * 取得成果  详情
 */
public class AchievementDetailActivity extends BaseActivity {

    @BindView(R.id.webview)
    WebView mWebview;
    @BindView(R.id.progressbar)
    ProgressBar mProgressBar;
//    private String content;
    private String mId;
    private String ACHIEVEMENT_URL = ServiceConfig.BASE_URL+"CiepMobile/secondPage/achievementDetail.html?historyAchievement.id=";

    @Override
    public int getLayoutId() {
        return R.layout.activity_achievement_detail;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());

        WebSettings webSettings = mWebview.getSettings();
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setUseWideViewPort(true);// 这个很关键
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setBuiltInZoomControls(true);
        mWebview.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                mWebview.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mProgressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
//        content = savedInstanceState.getString("content");
        mId = savedInstanceState.getString("id");
    }

    @Override
    protected void initdata() {
        super.initdata();
//        mWebview.loadDataWithBaseURL("http://120.76.74.105:8085", content, "text/html", "utf-8", null);
        mWebview.loadUrl(ACHIEVEMENT_URL +mId);
    }
}
