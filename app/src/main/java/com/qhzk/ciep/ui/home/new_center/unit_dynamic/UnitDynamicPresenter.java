package com.qhzk.ciep.ui.home.new_center.unit_dynamic;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.NewEntity;
import com.qhzk.ciep.mvp.BasePresenter;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Administrator on 2016/12/15.
 */

public class UnitDynamicPresenter extends BasePresenter<UnitDynamicView> {
    public int page = 1;
    public void getUnitDynamicData(){
        mApi.getNews(1, 20, "exhibitdynamic", new ResultSubscriber<List<NewEntity>>(this) {
            @Override
            public void onSuccess(List<NewEntity> list) {
                if (list == null){
                    return;
                }
                Collections.sort(list, (o1, o2) -> {
                    String time1 = o1.getCreatetime().trim();
                    String time2 = o2.getCreatetime().trim();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
                    try {
                        Date data1 = sdf.parse(time1);
                        Date data2 = sdf.parse(time2);
                        return data2.compareTo(data1);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return 0;
                    }
                });
                getMvpView().onUnitDynamicResult(list);
            }
        });
    }

    public void loadMore() {
        mApi.getNews(++page, 20, "exhibitdynamic", new ResultSubscriber<List<NewEntity>>(this) {
            @Override
            public void onSuccess(List<NewEntity> list) {
                if (list == null){
                    return;
                }
                if (list.size()<20){
                    getMvpView().onLoadNoMore(list);
                }else{
                    getMvpView().onLoadMore(list);
                }
            }
        });
    }
}
