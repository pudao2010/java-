package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.agenda;


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

/**
 * Created by Administrator on 2016/12/16.
 * 主要日程
 */

public class AgendaFragment extends BaseFragment<AgendaPresenter> implements AgendaView{

    private WebView mWebView;
    private ProgressBar mProgressBar;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_agenda;
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
        webSettings.setBuiltInZoomControls(true);
//        webSettings.setTextSize(WebSettings.TextSize.LARGEST);

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
        mFragmentPresenter.loadData("zhuyaoricheng");
    }

    @Override
    public void onLoadSuccess(NewsDetail newsDetail) {
        mWebView.loadDataWithBaseURL(ServiceConfig.BASE_URL, newsDetail.getContent(), "text/html","utf-8", null);
    }
}
