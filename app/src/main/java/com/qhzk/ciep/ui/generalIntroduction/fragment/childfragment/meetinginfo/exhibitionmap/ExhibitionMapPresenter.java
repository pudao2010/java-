package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.exhibitionmap;

import com.qhzk.ciep.mvp.BasePresenter;

/**
 * Created by Administrator on 2016/12/16.
 */

public class ExhibitionMapPresenter extends BasePresenter<ExhibitionMapView> {

    public void loadData(){
        getMvpView().onLoadSuccess();
    }
}
