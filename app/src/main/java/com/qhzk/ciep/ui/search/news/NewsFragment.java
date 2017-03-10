package com.qhzk.ciep.ui.search.news;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;
import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.entity.SearchNewEntity;
import com.qhzk.ciep.ui.newsdetail.NewsDetailActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;

/**
 * 搜索页面的新闻
 */

public class NewsFragment extends BaseFragment<NewsPresenter> implements NewsView {

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    private BaseQuickAdapter<SearchNewEntity.NewsBean.RowsBean, BaseViewHolder> mAdapter;

    private List<SearchNewEntity.NewsBean.RowsBean> mNewItemLists;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search_news;
    }


    @Override
    protected void initview() {
        super.initview();

        mNewItemLists = new ArrayList<>();

        mAdapter = new BaseQuickAdapter<SearchNewEntity.NewsBean.RowsBean, BaseViewHolder>(R.layout.home_rec_item_layout, mNewItemLists) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, SearchNewEntity.NewsBean.RowsBean rowsBean) {
                long createtime = rowsBean.getCreatetime();
                Date date = new Date(createtime);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dateFormat = sdf.format(date);
                baseViewHolder.setText(R.id.title, rowsBean.getTitle()).setText(R.id.date, dateFormat);
                ImageView image = baseViewHolder.getView(R.id.image);
                Glide.with(NewsFragment.this)
                        .load(ServiceConfig.BASE_URL + rowsBean.getPcimg())
                        .dontAnimate()
                        .centerCrop()
                        .error(R.mipmap.ic_launcher)
                        .into(image);
            }

        };

        // 点击事件
        mRecyclerview.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Bundle bundle = new Bundle();
                bundle.putString("id", mNewItemLists.get(i).getId());
                bundle.putString("title", mNewItemLists.get(i).getTitle());
                bundle.putString("imgUrl", ServiceConfig.BASE_URL + mNewItemLists.get(i).getPcimg());
                readyGo(NewsDetailActivity.class, bundle);
            }
        });

        mRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerview.setAdapter(mAdapter);
    }

    @Override
    protected void initdata() {
        super.initdata();
//        mFragmentPresenter.getNewItemData();
    }

    @Override
    public void onNewItemResult(List<SearchNewEntity.NewsBean.RowsBean> list) {
        mNewItemLists.clear();
        mNewItemLists.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    public void onSearchSuccess(List<SearchNewEntity.NewsBean.RowsBean> rows) {
        mNewItemLists.clear();
        mNewItemLists.addAll(rows);
        mAdapter.notifyDataSetChanged();
    }
}
