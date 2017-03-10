package com.qhzk.ciep.ui.mine.attention;

import com.qhzk.ciep.entity.MyFocus;
import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Administrator on 2016/12/26.
 */

public interface AttentionView extends MvpView{

    void onLoadSuccess(MyFocus myFocus);

    void onLoadNodata();
}
