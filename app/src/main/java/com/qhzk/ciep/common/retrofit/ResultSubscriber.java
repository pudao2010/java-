package com.qhzk.ciep.common.retrofit;


import com.qhzk.ciep.mvp.BasePresenter;

import rx.Subscriber;

/**
 * 接口数据统一返回类,观察者,持有Presenter层引用
 */
public abstract class ResultSubscriber<T> extends Subscriber<T> {

    private BasePresenter mPresenter;

    public ResultSubscriber(BasePresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (mPresenter != null) {
            if (mPresenter.getMvpView() != null) {
                onError(e.getMessage());
            }
        } else {
            onError(e.getMessage());
        }
    }

    /**
     * 如果有特别错误处理需求.可以重写改方法
     *
     * @param error
     */
    protected void onError(String error) {
        if (mPresenter != null) {
            mPresenter.getMvpView().showErrorInfo(error);
        }
    }

    @Override
    public void onNext(T t) {
        if (mPresenter != null) {
            if (mPresenter.getMvpView() != null) {
                onSuccess(t);
            }
        } else {
            onSuccess(t);
        }
        onCompleted();
    }

    public abstract void onSuccess(T t);

}
