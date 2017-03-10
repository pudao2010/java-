package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.boothbuild;


import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;
import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.entity.NewsDetail;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/14.
 * 展位搭建
 */

public class BoothbuildFragment extends BaseFragment<BoothbuildPresenter> implements BoothbuildView {

    @BindView(R.id.webview)
    WebView mWebView;
    @BindView(R.id.progressbar)
    ProgressBar mProgressBar;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_booth_build;
    }

    @Override
    protected void initview() {
        super.initview();
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setSupportZoom(true);
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                mWebView.loadUrl(url);
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
    protected void initdata() {
        super.initdata();
        mFragmentPresenter.loadData("zhanweidajian");
    }

    @Override
    public void onLoadSuccess(NewsDetail newsDetail) {
        mWebView.loadDataWithBaseURL(ServiceConfig.BASE_URL, newsDetail.getContent(), "text/html","utf-8", null);
    }

}
