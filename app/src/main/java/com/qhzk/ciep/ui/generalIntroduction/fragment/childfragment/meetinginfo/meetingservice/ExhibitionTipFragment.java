package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.meetingservice;


import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;
import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.entity.NewsDetail;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/**
 * Created by Administrator on 2016/12/18.
 * 参展手册
 */

public class ExhibitionTipFragment extends BaseFragment<ExhibitionTipPresenter> implements ExhibitionTipView{

    private WebView mWebView;
    private ProgressBar mProgressBar;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_exhibition_tip;
    }

    @Override
    protected void initview() {
        super.initview();
        mWebView = (WebView) mRootView.findViewById(R.id.webview);
        mProgressBar = (ProgressBar) mRootView.findViewById(R.id.progressbar);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
//        webSettings.setSupportZoom(false);
//        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
//        webSettings.setUseWideViewPort(true);// 这个很关键
//        webSettings.setLoadWithOverviewMode(true);
//        webSettings.setBuiltInZoomControls(false);

        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
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
        mFragmentPresenter.loadData("canzhanshouce");
    }

    @Override
    public void onLoadSuccess(NewsDetail newsDetail) {
        mWebView.loadDataWithBaseURL(ServiceConfig.BASE_URL, newsDetail.getContent(), "text/html", "utf-8", null);
    }

    /**
     *  设置WebView可以回退
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack(); // goBack()表示返回WebView的上一页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}


