package com.qhzk.ciep.ui.notice;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
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
 * 通知详情
 * 2017年1月5日09:47:03
 */
public class NoticeDetailActivity extends BaseActivity {

    @BindView(R.id.webview)
    WebView mWebview;
    @BindView(R.id.progressbar)
    ProgressBar mProgressbar;
    String  NEWS_DETAIL_URL = ServiceConfig.BASE_URL + "CiepMobile/secondPage/noticeDetail.html?id=";
    String id;
    @Override
    public int getLayoutId() {
        return R.layout.activity_notice_detail;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        id = savedInstanceState.getString("id", null);
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
        mWebview.setWebViewClient(new WebViewClient() {

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
                mProgressbar.setVisibility(View.GONE);
            }
        });
        if (TextUtils.isEmpty(id)) {
            finish();
            return;
        }
    }

    @Override
    protected void initdata() {
        super.initdata();
        mWebview.loadUrl(NEWS_DETAIL_URL + id);
    }

}
