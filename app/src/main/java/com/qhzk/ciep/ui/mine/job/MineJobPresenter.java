package com.qhzk.ciep.ui.mine.job;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.Deliver;
import com.qhzk.ciep.mvp.BasePresenter;
import com.qhzk.ciep.protocol.CancelDeliverProtocol;
import com.qhzk.ciep.protocol.CiepProtocol;

import java.util.List;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/12/28.
 */

public class MineJobPresenter extends BasePresenter<MineJobView> {
    private int page = 1;
    public void loadData(){

        mApi.getDeliverlist(1, 20, new ResultSubscriber<List<Deliver>>(this) {
            @Override
            public void onSuccess(List<Deliver> delivers) {
                getMvpView().onLoadSuccess(delivers);
            }

        });
    }

    public void loadMore(){
        mApi.getDeliverlist(++page, 20, new ResultSubscriber<List<Deliver>>(this) {
            @Override
            public void onSuccess(List<Deliver> delivers) {
                getMvpView().onLoadMore(delivers);
            }
        });
    }

    public void cancelDeliver(String id) {
        CancelDeliverProtocol protocol = new CancelDeliverProtocol(new CiepProtocol.Callback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                getMvpView().onError(e);
            }

            @Override
            public void onSuccess() {
                getMvpView().onCancelSuccess();
            }

            @Override
            public void onFailed() {
                getMvpView().onCancelFailed();
            }
        });
        protocol.setId(id);
        protocol.uploadDataByPost();
    }
}
