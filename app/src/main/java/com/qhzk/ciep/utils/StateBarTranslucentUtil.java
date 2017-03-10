package com.qhzk.ciep.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Ziv on 2016/7/31.
 */
public class StateBarTranslucentUtil {


    public static void setStateBarTranslucent(Activity activity) {
        setStateBarSupportColor(activity, Color.TRANSPARENT);
    }

    public static void setStateBarSupportColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    }

    public static void setStateBarColor(Activity activity, int color) {
        ViewGroup contentLayout = (ViewGroup) activity.findViewById(android.R.id.content);
        setupStatusBarView(activity, contentLayout, color);
        View contentChild = contentLayout.getChildAt(0);
        contentChild.setFitsSystemWindows(true);
    }

    public static View setStateBarColorNotFit(Activity activity, int color) {
        ViewGroup contentLayout = (ViewGroup) activity.findViewById(android.R.id.content);
        return setupStatusBarView(activity, contentLayout, color);
    }

    public static View setupStatusBarView(Activity activity, ViewGroup contentLayout) {
        View statusBarView = new View(activity);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(activity));
        contentLayout.addView(statusBarView, lp);
        return statusBarView;
    }

    public static View setupStatusBarView(Activity activity, ViewGroup contentLayout, int color) {
        View mStatusBarView = null;
        View statusBarView = new View(activity);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(activity));
        contentLayout.addView(statusBarView, lp);
        mStatusBarView = statusBarView;
        mStatusBarView.setBackgroundColor(color);
        return mStatusBarView;
    }

    private static int getStatusBarHeight(Context context) {
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }

}
