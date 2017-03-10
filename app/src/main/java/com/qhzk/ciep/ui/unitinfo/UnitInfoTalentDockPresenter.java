package com.qhzk.ciep.ui.unitinfo;

import com.qhzk.ciep.entity.UnitInfoTalent;
import com.qhzk.ciep.mvp.BasePresenter;
import com.qhzk.ciep.protocol.BaseProtocol;
import com.qhzk.ciep.protocol.UnitInfoTalentProtocol;

import java.util.List;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/12/26.
 * 单位信息里的 人才对接
 */

public class UnitInfoTalentDockPresenter extends BasePresenter<UnitInfoTalentDockView> {
    public int page = 1;
    private UnitInfoTalentProtocol protocol;

    public void loadData(String entId){
        protocol = new UnitInfoTalentProtocol();
        protocol.setPage(1);
        protocol.setEntId(entId);
        protocol.loadDataByPost(new BaseProtocol.Callback<UnitInfoTalent>() {
            @Override
            public void onError(Call call, Exception e, int id) {
                getMvpView().onError(e);
            }

            @Override
            public void onResponse(UnitInfoTalent unitInfoTalent, int id) {
                if (unitInfoTalent != null && unitInfoTalent.getData() != null &&
                        unitInfoTalent.getData().getPositions() != null &&
                        unitInfoTalent.getData().getPositions().getResult() != null) {
                    UnitInfoTalent.DataBean.PositionsBean positions = unitInfoTalent.getData().getPositions();
                    List<UnitInfoTalent.DataBean.PositionsBean.ResultBean> result = positions.getResult();
                    getMvpView().onLoadSuccess(result);
                }

            }

        });
    }

    public void loadMore(String entId){
        if (protocol == null) {
            protocol = new UnitInfoTalentProtocol();
        }
        protocol.setPage(++page);
        protocol.setEntId(entId);
        protocol.loadDataByPost(new BaseProtocol.Callback<UnitInfoTalent>() {
            @Override
            public void onError(Call call, Exception e, int id) {
                getMvpView().onError(e);
            }

            @Override
            public void onResponse(UnitInfoTalent unitInfoTalent, int id) {
                if (unitInfoTalent != null && unitInfoTalent.getData() != null &&
                        unitInfoTalent.getData().getPositions() != null &&
                        unitInfoTalent.getData().getPositions().getResult() != null) {
                    UnitInfoTalent.DataBean.PositionsBean positions = unitInfoTalent.getData().getPositions();
                    List<UnitInfoTalent.DataBean.PositionsBean.ResultBean> result = positions.getResult();
                    getMvpView().onLoadSuccess(result);
                }
            }

        });
    }

}
