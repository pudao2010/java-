package com.qhzk.ciep.ui.generalIntroduction.fragment;

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
import com.qhzk.ciep.entity.UnitList;
import com.qhzk.ciep.ui.unitinfo.UnitInfoActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/14.
 * 参展名单
 */

public class UnitListFragment extends BaseFragment<UnitListPresenter> implements UnitListView {

    @BindView(R.id.springview)
    SpringView mSpringView;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    private BaseQuickAdapter<UnitList, BaseViewHolder> mAdapter;
    private List<UnitList> mLists = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_unit_list;
    }

    @Override
    public void onLoadSuccess(List<UnitList> unitLists) {
        mSpringView.onFinishFreshAndLoad();
        mLists.clear();
        mLists.addAll(unitLists);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadMore(List<UnitList> unitLists) {
        mSpringView.onFinishFreshAndLoad();
        mLists.addAll(unitLists);
        mAdapter.notifyDataSetChanged();
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
                mFragmentPresenter.getUnitList(1,20);
            }
            @Override
            public void onLoadmore() {
                mFragmentPresenter.loadMore();
            }
        });
        // 点击事件
        mRecyclerview.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Bundle bundle = new Bundle();
                bundle.putString("id", mLists.get(i).getId());
                readyGo(UnitInfoActivity.class, bundle);
            }
        });
        mAdapter = new BaseQuickAdapter<UnitList, BaseViewHolder>(R.layout.mine_attenttion_item_layout, mLists) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, UnitList unitList) {
                baseViewHolder.setText(R.id.history_company, unitList.getName())
                        .setText(R.id.history_category, unitList.getIndustry());
            }
        };
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this.getContext()));
        mRecyclerview.setAdapter(mAdapter);
    }

    @Override
    protected void initdata() {
        super.initdata();
        mFragmentPresenter.getUnitList(1, 20);
    }
}
