package com.qhzk.ciep.ui.talentdock.fragment;

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
import com.qhzk.ciep.entity.UnitInfoEntity;
import com.qhzk.ciep.ui.jobdetail.JobDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/19.
 * 职位搜索
 */

public class UnitInfoFragment extends BaseFragment<UnitInfoPresenter> implements UnitInfoView {

    @BindView(R.id.springview)
    SpringView mSpringView;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    private BaseQuickAdapter<UnitInfoEntity.ResultBean, BaseViewHolder> mAdapter;
    private List<UnitInfoEntity.ResultBean> mList;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_unitinfo;
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
                mFragmentPresenter.loadData(1,20);
            }
            @Override
            public void onLoadmore() {
                mFragmentPresenter.loadMore();
            }
        });
        mList = new ArrayList<>();
        mAdapter = new BaseQuickAdapter<UnitInfoEntity.ResultBean, BaseViewHolder>(R.layout.item_unit_info, mList) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, UnitInfoEntity.ResultBean resultBean) {
                baseViewHolder.setText(R.id.title, resultBean.getTitle()).setText(R.id.name, resultBean.getEnterprise().getName())
                        .setText(R.id.date, resultBean.getPublishDate())
                        .setText(R.id.industry, resultBean.getEnterprise().getIndustry());
            }
        };
        // 点击事件
        mRecyclerview.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Bundle bundle = new Bundle();
                bundle.putString("id", mList.get(i).getId());
                readyGo(JobDetailActivity.class, bundle);
            }
        });
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerview.setAdapter(mAdapter);
    }

    @Override
    protected void initdata() {
        super.initdata();
        mFragmentPresenter.loadData(1, 20);
    }

    @Override
    public void onLoadSuccess(UnitInfoEntity unitInfoEntity) {
        mSpringView.onFinishFreshAndLoad();
        List<UnitInfoEntity.ResultBean> result = unitInfoEntity.getResult();
        mList.clear();
        mList.addAll(result);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadMore(UnitInfoEntity unitInfoEntity) {
        mSpringView.onFinishFreshAndLoad();
        mList.addAll(unitInfoEntity.getResult());
        mAdapter.notifyDataSetChanged();
    }
}
