package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.eventreview;

import com.qhzk.ciep.entity.NewVideoEntity;
import com.qhzk.ciep.mvp.MvpView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/24.
 */

public interface RelateVideoView extends MvpView {

    void onLoadSuccess(List<NewVideoEntity> list);

    void onLoadMore(List<NewVideoEntity> list);
}
