package com.qhzk.ciep.ui.mine.data;

import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Administrator on 2016/12/27.
 */

public interface MineDataView extends MvpView{
    void onUploadSuccess();

    void onUploadFailed();
}
