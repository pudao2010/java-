package com.qhzk.ciep.ui.notice;

import com.qhzk.ciep.entity.Notice;
import com.qhzk.ciep.mvp.MvpView;

import java.util.List;

/**
 * Created by pucheng on 2017/1/4.
 */

public interface ConferenceNoticeView extends MvpView{

    void onLoadSuccess(List<Notice.RowsBean> list);

    void onLoadNoMore(List<Notice.RowsBean> list);

    void onLoadHasMore(List<Notice.RowsBean> list);
}
