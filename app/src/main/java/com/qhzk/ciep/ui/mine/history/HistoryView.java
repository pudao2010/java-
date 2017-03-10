package com.qhzk.ciep.ui.mine.history;

import com.qhzk.ciep.entity.EnterpriseEntity;
import com.qhzk.ciep.mvp.MvpView;

import java.util.List;

/**
 * Created by pucheng on 2017/2/23.
 *
 */

public interface HistoryView extends MvpView {

    void onLoadSuccess(List<EnterpriseEntity> mList);
}
