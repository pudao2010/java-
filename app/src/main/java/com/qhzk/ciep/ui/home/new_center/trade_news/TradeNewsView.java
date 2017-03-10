package com.qhzk.ciep.ui.home.new_center.trade_news;

import com.qhzk.ciep.entity.NewEntity;
import com.qhzk.ciep.mvp.MvpView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 */

public interface TradeNewsView extends MvpView {

    void onTradeNewsResult(List<NewEntity> list);

    void onLoadMore(List<NewEntity> list);

    void onLoadNoMore(List<NewEntity> list);
}
