package com.qhzk.ciep.ui.unitinfo;

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
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.entity.UnitInfoTalent;
import com.qhzk.ciep.ui.jobdetail.JobDetailActivity;
import com.qhzk.ciep.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 单位信息页面 对应的 人才对接
 * 2016年12月26日12:37:18
 */
public class UnitInfoTalentDockActivity extends BaseActivity<UnitInfoTalentDockPresenter> implements UnitInfoTalentDockView {

    @BindView(R.id.springview)
    SpringView mSpringView;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private BaseQuickAdapter<UnitInfoTalent.DataBean.PositionsBean.ResultBean, BaseViewHolder> mAdapter;

    String entId;
    private List<UnitInfoTalent.DataBean.PositionsBean.ResultBean> mList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_unit_info_talent_dock;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());
        mSpringView.setHeader(new DefaultHeader(this));
        mSpringView.setFooter(new DefaultFooter(this));
        mSpringView.setType(SpringView.Type.FOLLOW);
        mSpringView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                mActivityPresenter.page = 1;
                mActivityPresenter.loadData(entId);
            }

            @Override
            public void onLoadmore() {
                mActivityPresenter.loadMore(entId);
            }
        });
        mAdapter = new BaseQuickAdapter<UnitInfoTalent.DataBean.PositionsBean.ResultBean, BaseViewHolder>(R.layout.item_unitinfo_talentdock, mList) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, UnitInfoTalent.DataBean.PositionsBean.ResultBean resultBean) {
                baseViewHolder.setText(R.id.job_name, resultBean.getTitle() == null ? "" : resultBean.getTitle())
                        .setText(R.id.job_degree, resultBean.getEducation() == null ? "" : resultBean.getEducation())
                        .setText(R.id.job_number, resultBean.getNum() + "人")
                        .setText(R.id.job_salary, resultBean.getSalRange() == null ? "" : resultBean.getSalRange())
                        .setText(R.id.job_date, resultBean.getPublishDate() == null ? "" : resultBean.getPublishDate());
            }
        };

        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Bundle bundle = new Bundle();
                bundle.putString("id", mList.get(i).getId());
                // 此处进入职位信息页面,隐藏掉 [查看] TextView
                bundle.putBoolean("hideKey", true);
                readyGo(JobDetailActivity.class, bundle);
            }
        });

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        entId = savedInstanceState.getString("entId");
    }

    @Override
    protected void initdata() {
        super.initdata();
        mActivityPresenter.loadData(entId);
    }

    @Override
    public void onLoadSuccess(List<UnitInfoTalent.DataBean.PositionsBean.ResultBean> list) {
        mSpringView.onFinishFreshAndLoad();
        mList.clear();
        mList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadMore(List<UnitInfoTalent.DataBean.PositionsBean.ResultBean> list) {
        mSpringView.onFinishFreshAndLoad();
        mList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(Exception e) {
        showToast("网络错误:" + e);
    }
}
