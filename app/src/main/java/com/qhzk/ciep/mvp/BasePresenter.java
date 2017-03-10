package com.qhzk.ciep.mvp;


import com.qhzk.ciep.interactor.Api;
import com.qhzk.ciep.repository.remote.ApiImpl;
import com.qhzk.ciep.utils.ReflexUtil;

/**
 * Created by Thisdk on 2016/4/11.
 * 基础的主持类
 */
public class BasePresenter<T extends MvpView> implements Presenter<T> {

    protected Api mApi = new ApiImpl();

    protected String TAG = getClass().getSimpleName();
    // Presenter持有View的引用,在attachView时获得实例,在detachView时置为null
    private T mMvpView;

    @Override
    public void attachView(T mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    public T getMvpView() {
        return mMvpView;
    }
    // 通过反射获取泛型的实体
    public Class<T> getMvpViewClass() {
        return ReflexUtil.getClassGeneric(this, 0);
    }

}
