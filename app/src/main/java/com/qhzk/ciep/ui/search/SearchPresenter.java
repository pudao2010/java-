package com.qhzk.ciep.ui.search;

import com.qhzk.ciep.entity.SearchNewEntity;
import com.qhzk.ciep.entity.SearchUnitEntity;
import com.qhzk.ciep.mvp.BasePresenter;
import com.qhzk.ciep.protocol.BaseProtocol;
import com.qhzk.ciep.protocol.SearchNewProtocol;
import com.qhzk.ciep.protocol.SearchUnitProtocol;

import java.util.List;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/12/30.
 */

public class SearchPresenter extends BasePresenter<SearchView> {

    public void searchUnit(String keyword){
        SearchUnitProtocol protocol = new SearchUnitProtocol();
        protocol.setKeyword(keyword);
        protocol.loadDataByGet(new BaseProtocol.Callback<SearchUnitEntity>() {
            @Override
            public void onError(Call call, Exception e, int id) {
                getMvpView().onError(e);
            }

            @Override
            public void onResponse(SearchUnitEntity searchUnitEntity, int id) {
                List<SearchUnitEntity.EnterpriseBean.RowsBean> rows = searchUnitEntity.getEnterprise().getRows();
                if (rows.size()>=1){
                    getMvpView().onSearchUnitSuccess(rows);
                }else{
                    getMvpView().onSearchUnitFailed(rows);
                }
            }

        });
    }

    public void searchNew(String keyword){
        SearchNewProtocol protocol = new SearchNewProtocol();
        protocol.setKeyword(keyword);
        protocol.loadDataByGet(new BaseProtocol.Callback<SearchNewEntity>() {
            @Override
            public void onError(Call call, Exception e, int id) {
                getMvpView().onError(e);
            }

            @Override
            public void onResponse(SearchNewEntity searchNewEntity, int id) {
                List<SearchNewEntity.NewsBean.RowsBean> rows = searchNewEntity.getNews().getRows();
                if (rows.size()>=1){
                    getMvpView().onSearchNewSuccess(rows);
                }else{
                    getMvpView().onSearchNewFailed(rows);
                }

            }
        });
    }
}
