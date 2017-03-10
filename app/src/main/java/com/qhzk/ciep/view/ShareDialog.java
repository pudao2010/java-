package com.qhzk.ciep.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.qhzk.ciep.R;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;

/**
 * Created by Administrator on 2016/12/18.
 * 分享对话框
 */

public class ShareDialog extends Dialog implements View.OnClickListener {

    private String title;   // 分享的标题
    private String url;     // 分享的URL
    private String imgUrl;
    private ShareDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public ShareDialog(Context context) {
        this(context, R.style.Theme_Light_Dialog);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.view_share, null);
        dialogView.findViewById(R.id.share_friends).setOnClickListener(this);
        dialogView.findViewById(R.id.share_qq).setOnClickListener(this);
        dialogView.findViewById(R.id.share_wechat).setOnClickListener(this);
        dialogView.findViewById(R.id.share_weibo).setOnClickListener(this);
        initWindow();
        setContentView(dialogView);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    private void initWindow() {
        //设置dialog在屏幕底部
        Window window = getWindow();
        if (window != null) {
            window.setGravity(Gravity.BOTTOM);
            //设置dialog弹出时的动画效果，从屏幕底部向上弹出
            window.setWindowAnimations(R.style.dialogStyle);
            window.getDecorView().setPadding(0, 0, 0, 0);
        }
        //获得window窗口的属性
        WindowManager.LayoutParams lp = window.getAttributes();
        //设置窗口宽度为充满全屏
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        //设置窗口高度为包裹内容
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //将设置好的属性set回去
        window.setAttributes(lp);
    }

    @Override
    public void onClick(View view) {
        Platform plat;
        switch (view.getId()) {
            case R.id.share_wechat:
                plat = ShareSDK.getPlatform(Wechat.NAME);
                showShare(plat.getName(), title, url, imgUrl);
                dismiss();
                break;
            case R.id.share_friends:
                plat = ShareSDK.getPlatform(WechatMoments.NAME);
                showShare(plat.getName(), title, url, imgUrl);
                dismiss();
                break;
            case R.id.share_weibo:
                plat = ShareSDK.getPlatform(SinaWeibo.NAME);
                showShare(plat.getName(), title, url, imgUrl);
                dismiss();
                break;
            case R.id.share_qq:
                //比如分享到QQ，其他平台则只需要更换平台类名，例如Wechat.NAME则是微信
                plat = ShareSDK.getPlatform(QQ.NAME);
                showShare(plat.getName(), title, url, imgUrl);
                dismiss();
                break;
        }
    }

    private void showShare(String platform, String title, String url, String imgUrl) {
        final OnekeyShare oks = new OnekeyShare();
        //指定分享的平台，如果为空，还是会调用九宫格的平台列表界面
        if (platform != null) {
            oks.setPlatform(platform);
        }
        // 关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        if (title != null) {
            oks.setTitle(title);
        }

        // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
        if (url != null) {
            oks.setTitleUrl(url);
        }

        // text是分享文本，所有平台都需要这个字段
        oks.setText("来自中国国际人才交流大会");
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        if (imgUrl != null) {
            oks.setImageUrl(imgUrl);
        }
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//        oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(url);
        //启动分享
        oks.show(this.getContext());
    }
}
