package com.qhzk.ciep.ui.newsdetail;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.entity.NewsDetail;
import com.qhzk.ciep.view.ShareDialog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;
import butterknife.OnClick;

public class NewsDetailActivity extends BaseActivity<NewsDetailPresenter> implements NewsDetailView {

    @BindView(R.id.webview)
    WebView mWebview;
    @BindView(R.id.progressbar)
    ProgressBar mProgressBar;
    String id;
    String title;
    private String  NEWS_DETAIL_URL = ServiceConfig.BASE_URL + "CiepMobile/secondPage/noticeDetail.html?id=";
    private String imgUrl;

    @Override
    public int getLayoutId() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        id = savedInstanceState.getString("id", null);
        title = savedInstanceState.getString("title", "");
        imgUrl = savedInstanceState.getString("imgUrl");
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
//        webSettings.setTextSize(WebSettings.TextSize.LARGER);
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
                mProgressBar.setVisibility(View.GONE);
            }
        });
        if (TextUtils.isEmpty(id)) {
            finish();
        }
    }

    @Override
    protected void initdata() {
        super.initdata();
        mWebview.loadUrl(NEWS_DETAIL_URL + id);
    }

    @Override
    public void loadSuccess(NewsDetail newsDetail) {
//        mWebview.loadDataWithBaseURL("http://120.76.74.105:8085", newsDetail.getContent(), "text/html", "utf-8", null);
    }

    @OnClick(R.id.share)
    public void onClick() {
        ShareDialog shareDialog = new ShareDialog(this);
        shareDialog.setTitle(title);
        shareDialog.setUrl(NEWS_DETAIL_URL + id);
        shareDialog.setImgUrl(imgUrl);
        shareDialog.show();
    }
}
