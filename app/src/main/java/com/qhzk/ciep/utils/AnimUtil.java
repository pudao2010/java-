package com.qhzk.ciep.utils;

import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

/**
 * Created by Thisdk on 2016/9/7.
 */

public class AnimUtil {

    private static final int ANIM_DURATION = 250;

    public static TranslateAnimation getVideoViewDownTranslateAnim() {
        TranslateAnimation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1.00f);
        animation.setDuration(ANIM_DURATION);
        animation.setFillAfter(true);
        animation.setInterpolator(new DecelerateInterpolator());
        return animation;
    }

    public static TranslateAnimation getVideoViewDownRecTranslateAnim() {
        TranslateAnimation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 1.00f, Animation.RELATIVE_TO_SELF, 0.00f);
        animation.setDuration(ANIM_DURATION);
        animation.setFillAfter(true);
        animation.setInterpolator(new DecelerateInterpolator());
        return animation;
    }

    public static TranslateAnimation getVideoViewUpTranslateAnim15f() {
        TranslateAnimation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -1.50f);
        animation.setDuration(ANIM_DURATION);
        animation.setFillAfter(true);
        animation.setInterpolator(new DecelerateInterpolator());
        return animation;
    }

    public static TranslateAnimation getVideoViewUpRecTranslateAnim15f() {
        TranslateAnimation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, -1.50f, Animation.RELATIVE_TO_SELF, 0.00f);
        animation.setDuration(ANIM_DURATION);
        animation.setFillAfter(true);
        animation.setInterpolator(new DecelerateInterpolator());
        return animation;
    }

    public static TranslateAnimation getVideoViewDownTranslateAnim15f() {
        TranslateAnimation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1.50f);
        animation.setDuration(ANIM_DURATION);
        animation.setFillAfter(true);
        animation.setInterpolator(new DecelerateInterpolator());
        return animation;
    }

    public static TranslateAnimation getVideoViewDownRecTranslateAnim15f() {
        TranslateAnimation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 1.50f, Animation.RELATIVE_TO_SELF, 0.00f);
        animation.setDuration(ANIM_DURATION);
        animation.setFillAfter(true);
        animation.setInterpolator(new DecelerateInterpolator());
        return animation;
    }

    public static TranslateAnimation getVideoViewUpTranslateAnim() {
        TranslateAnimation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -1.00f);
        animation.setDuration(ANIM_DURATION);
        animation.setFillAfter(true);
        animation.setInterpolator(new DecelerateInterpolator());
        return animation;
    }

    public static TranslateAnimation getVideoViewUpRecTranslateAnim() {
        TranslateAnimation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, -1.00f, Animation.RELATIVE_TO_SELF, 0.00f);
        animation.setDuration(ANIM_DURATION);
        animation.setFillAfter(true);
        animation.setInterpolator(new DecelerateInterpolator());
        return animation;
    }

}
