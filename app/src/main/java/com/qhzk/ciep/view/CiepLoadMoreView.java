package com.qhzk.ciep.view;

import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.qhzk.ciep.R;

/**
 * Created by Administrator on 2016/12/15.
 * RecyclerView的加载更多的视图
 */

public class CiepLoadMoreView extends LoadMoreView {

    @Override
    public int getLayoutId() {
        return R.layout.view_ciepload_more;
    }
    /**
     * 如果返回true，数据全部加载完毕后会隐藏加载更多
     * 如果返回false，数据全部加载完毕后会显示getLoadEndViewId()布局
     */
    @Override
    public boolean isLoadEndGone() {
        return true;
    }

    /**
     * 正在加载中的布局
     */
    @Override
    protected int getLoadingViewId() {
        return 0;
    }

    /**
     * 加载失败的布局
     */
    @Override
    protected int getLoadFailViewId() {
        return 0;
    }
    /**
     * isLoadEndGone()为true，可以返回0
     * isLoadEndGone()为false，不能返回0
     * 加载成功后的布局
     */
    @Override
    protected int getLoadEndViewId() {
        return 0;
    }
}
