package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;
import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.entity.NewsDetail;

/**
 * Created by Administrator on 2016/12/15.
 * 会议介绍
 */

public class MeetingInfoFragment extends BaseFragment<MeetingInfoPresenter> implements MeetingInfoView {

    private WebView mWebView;
    private ProgressBar mProgressBar;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_meeting_info;
    }

    @Override
    protected void initview() {
        super.initview();
        mWebView = (WebView) mRootView.findViewById(R.id.webview);
        mProgressBar = (ProgressBar) mRootView.findViewById(R.id.progressbar);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setUseWideViewPort(true);// 这个很关键
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDefaultFontSize(50);
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
        mFragmentPresenter.loadData("huiyijieshao");
    }

    @Override
    public void onLoadSuccess(NewsDetail newsDetail) {
        mWebView.loadDataWithBaseURL(ServiceConfig.BASE_URL, newsDetail.getContent(), "text/html", "utf-8", null);
    }
}
