package com.qhzk.ciep.ui.home.new_center.conference_video;

import com.qhzk.ciep.entity.ConfVideoEntity;
import com.qhzk.ciep.mvp.MvpView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/16.
 */

public interface ConferenceVideoView extends MvpView{

    void onLoadSuccess(List<ConfVideoEntity> list);

    void onLoadMore(List<ConfVideoEntity> list);

    void onLoadNoMore(List<ConfVideoEntity> list);

    void onError(Exception e);
}
