package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.forum;

import com.qhzk.ciep.entity.AreaDetailBean;
import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by pucheng on 2017/2/16.
 *
 */

public interface ForumDetailView extends MvpView {

    void onLoadSuccess(AreaDetailBean areaDetailBean);

    void onError(Exception e);
}
