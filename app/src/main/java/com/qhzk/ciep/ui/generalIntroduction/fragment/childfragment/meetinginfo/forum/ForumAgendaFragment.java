package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.forum;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;
import com.qhzk.ciep.entity.ForumAgenda;
import com.qhzk.ciep.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/16.
 * 论坛议程
 */

public class ForumAgendaFragment extends BaseFragment<ForumAgendaPresenter> implements ForumAgendaView {

    @BindView(R.id.springview)
    SpringView mSpringView;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    private BaseQuickAdapter<ForumAgenda, BaseViewHolder> mAdapter;
    private List<ForumAgenda> mList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_forum_agenda;
    }

    @Override
    protected void initdata() {
        super.initdata();
        mFragmentPresenter.loadData(1, 20);
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
                    mFragmentPresenter.loadData(1, 20);
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

        mAdapter = new BaseQuickAdapter<ForumAgenda, BaseViewHolder>(R.layout.item_forum_agenda, mList) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, ForumAgenda forumAgenda) {
                baseViewHolder.setText(R.id.froumagenda_title, forumAgenda.getTitle())
                        .setText(R.id.forumagenda_location, forumAgenda.getLocation())
                        .setText(R.id.forumagenda_time, forumAgenda.getBeginTime());
            }
        };

        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                // 处理点击事件, 进入论坛详情
                Bundle bundle = new Bundle();
                bundle.putString("detail", mList.get(i).getDetail());
                readyGo(ForumDetailActivity.class, bundle);
            }
        });

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onLoadSuccess(List<ForumAgenda> forumAgendas) {
        mSpringView.onFinishFreshAndLoad();
        mList.clear();
        mList.addAll(forumAgendas);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadMore(List<ForumAgenda> forumAgendas) {
        mSpringView.onFinishFreshAndLoad();
        mList.addAll(forumAgendas);
        mAdapter.notifyDataSetChanged();
    }

}
