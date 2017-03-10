package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.forum;

import com.qhzk.ciep.entity.AreaDetailBean;
import com.qhzk.ciep.mvp.BasePresenter;
import com.qhzk.ciep.protocol.AreaDetailProtocol;
import com.qhzk.ciep.protocol.BaseProtocol;

import okhttp3.Call;

/**
 * Created by pucheng on 2017/2/16.
 * 这里只是加载展区详情
 */

public class ForumDetailPresenter extends BasePresenter<ForumDetailView> {

    public void loadData(String id){
//        mApi.getAreaDetail(id, new ResultSubscriber<AreaDetail>(this) {
//            @Override
//            public void onSuccess(AreaDetail areaDetail) {
//                System.out.println(areaDetail);
//                if (areaDetail != null) {
//                    getMvpView().onLoadSuccess(areaDetail);
//                }
//            }
//        });
        AreaDetailProtocol protocol = new AreaDetailProtocol();
        protocol.setId(id);
        protocol.loadDataByGet(new BaseProtocol.Callback<AreaDetailBean>() {
            @Override
            public void onError(Call call, Exception e, int id) {
                getMvpView().onError(e);
            }

            @Override
            public void onResponse(AreaDetailBean areaDetailBean, int id) {
                getMvpView().onLoadSuccess(areaDetailBean);
            }

        });
    }
}
