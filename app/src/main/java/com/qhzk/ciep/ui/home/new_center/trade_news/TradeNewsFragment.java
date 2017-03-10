package com.qhzk.ciep.ui.home.new_center.trade_news;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;
import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.entity.NewEntity;
import com.qhzk.ciep.ui.newsdetail.NewsDetailActivity;
import com.qhzk.ciep.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by QixiongYuan on 2016/12/9.
 * 行业新闻
 */

public class TradeNewsFragment extends BaseFragment<TradeNewsPresenter> implements TradeNewsView {

    @BindView(R.id.springview)
    SpringView mSpringView;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    private BaseQuickAdapter<NewEntity, BaseViewHolder> mAdapter;
    private List<NewEntity> mIndustnews;

    public static TradeNewsFragment newInstance() {
        Bundle args = new Bundle();
        TradeNewsFragment fragment = new TradeNewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_trade_news;
    }

    @Override
    protected void initview() {
        super.initview();
        mSpringView.setHeader(new DefaultHeader(this.getContext()));
        mSpringView.setFooter(new DefaultFooter(this.getContext()));
        mSpringView.setType(SpringView.Type.FOLLOW);
        mSpringView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                if (mFragmentPresenter != null) {
                    mFragmentPresenter.getTradeNewsData();
                    mFragmentPresenter.page = 1;
                }

            }
            @Override
            public void onLoadmore() {
                if (mFragmentPresenter != null) {
                    mFragmentPresenter.loadMore();
                }

            }
        });
        mIndustnews = new ArrayList<>();
        mAdapter = new BaseQuickAdapter<NewEntity, BaseViewHolder>(R.layout.home_rec_item_layout, mIndustnews) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, NewEntity newEntity) {
                // 视图与数据绑定
                baseViewHolder.setText(R.id.title, newEntity.getTitle()).setText(R.id.date, newEntity.getCreatetime());
                ImageView image = baseViewHolder.getView(R.id.image);
                Glide.with(TradeNewsFragment.this).load(ServiceConfig.BASE_URL+newEntity.getPcimg()).dontAnimate().centerCrop().error(R.mipmap.ic_launcher).into(image);
            }
        };
        // 点击事件
        mRecyclerview.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Bundle bundle = new Bundle();
                bundle.putString("id", mIndustnews.get(i).getId());
                bundle.putString("title", mIndustnews.get(i).getTitle());
                bundle.putString("imgUrl", ServiceConfig.BASE_URL + mIndustnews.get(i).getPcimg());
                readyGo(NewsDetailActivity.class, bundle);
            }
        });
        mRecyclerview.addItemDecoration(new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL_LIST));
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerview.setAdapter(mAdapter);
    }

    @Override
    protected void initdata() {
        super.initdata();
        mFragmentPresenter.getTradeNewsData();
    }

    @Override
    public void onTradeNewsResult(List<NewEntity> list) {
        mSpringView.onFinishFreshAndLoad();
        mIndustnews.clear();
        mIndustnews.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadMore(List<NewEntity> list) {
        mSpringView.onFinishFreshAndLoad();
        mIndustnews.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadNoMore(List<NewEntity> list) {
        showToast("没有更多数据了");
        mSpringView.onFinishFreshAndLoad();
        mIndustnews.addAll(list);
        mAdapter.notifyDataSetChanged();
    }
}
