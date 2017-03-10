package com.qhzk.ciep.ui.tickets;

import com.qhzk.ciep.entity.UserInfo;
import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Administrator on 2016/12/24.
 */

public interface TicketsView extends MvpView{

    void onLoadUserInfoSuccess(UserInfo userInfo);

}
