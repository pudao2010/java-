package com.qhzk.ciep.ui.mine.resume;

import com.qhzk.ciep.entity.UserInfo;
import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Administrator on 2016/12/28.
 */

public interface ResumePreviewView extends MvpView{

    void onLoadUserInfoSuccess(UserInfo userInfo);
}
