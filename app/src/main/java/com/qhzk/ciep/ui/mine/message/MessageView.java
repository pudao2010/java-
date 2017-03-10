package com.qhzk.ciep.ui.mine.message;

import com.qhzk.ciep.entity.Message;
import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by pucheng on 2017/2/8.
 *
 */

public interface MessageView extends MvpView{

    void onLoadSuccess(Message message);

    void onError(Exception e);
}
