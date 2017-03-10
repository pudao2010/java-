package com.qhzk.ciep.mvp;

/**
 * Created by Thisdk on 2016/4/11.
 * Presenter的泛型是View的子类
 */
public interface Presenter<T extends MvpView> {

    // 在Activity或者Fragment的生命周期onCreate时进行绑定
    void attachView(T mvpView);
    // 在Activity或者Fragment的生命周期onDestroy时进行解绑
    void detachView();

}
