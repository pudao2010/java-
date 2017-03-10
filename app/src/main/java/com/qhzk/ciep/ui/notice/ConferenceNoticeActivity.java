package com.qhzk.ciep.ui.notice;

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
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.entity.Notice;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 *  大会通知
 *  2017年1月4日18:27:52
 */
public class ConferenceNoticeActivity extends BaseActivity<ConferenceNoticePresenter> implements ConferenceNoticeView {

    String mid = "confnotice";

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.springview)
    SpringView mSpringview;

    private List<Notice.RowsBean> mList = new ArrayList<>();
    private BaseQuickAdapter<Notice.RowsBean, BaseViewHolder> mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_conference_notice;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());

        mSpringview.setHeader(new DefaultHeader(this));
        mSpringview.setFooter(new DefaultFooter(this));
        mSpringview.setType(SpringView.Type.FOLLOW);
        mSpringview.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                mActivityPresenter.loadData(1, 20, mid);
            }
            @Override
            public void onLoadmore() {
                mActivityPresenter.loadMore(mid);
            }
        });

        mAdapter = new BaseQuickAdapter<Notice.RowsBean, BaseViewHolder>(R.layout.item_achievement, mList) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, Notice.RowsBean rowsBean) {
                baseViewHolder.setText(R.id.title, rowsBean.getTitle())
                        .setText(R.id.desc, rowsBean.getIntroduction())
                        .setText(R.id.date, rowsBean.getCreatetime());
                ImageView image = baseViewHolder.getView(R.id.image);
                Glide.with(ConferenceNoticeActivity.this)
                        .load(ServiceConfig.BASE_URL+rowsBean.getId()) //目前没有预览图
                        .placeholder(R.mipmap.ic_launcher)
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
                String id = mList.get(i).getId();
                Bundle bundle = new Bundle();
                bundle.putString("id", id);
                readyGo(NoticeDetailActivity.class, bundle);
            }
        });

        mRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerview.setAdapter(mAdapter);
    }

    @Override
    protected void initdata() {
        super.initdata();
        mActivityPresenter.loadData(1, 20, mid);
    }

    @Override
    public void onLoadSuccess(List<Notice.RowsBean> list) {
        mSpringview.onFinishFreshAndLoad();
        mList.clear();
        mList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadNoMore(List<Notice.RowsBean> list) {
        mSpringview.onFinishFreshAndLoad();
        mList.addAll(list);
        mAdapter.notifyDataSetChanged();
        showToast("没有更多数据了");
    }

    @Override
    public void onLoadHasMore(List<Notice.RowsBean> list) {
        mSpringview.onFinishFreshAndLoad();
        mList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }
}
