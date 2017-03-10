package com.qhzk.ciep.ui.mine.job;

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
import com.qhzk.ciep.entity.Deliver;
import com.qhzk.ciep.ui.jobdetail.JobDetailActivity;
import com.qhzk.ciep.ui.mine.resume.MineResumeActivity;
import com.qhzk.ciep.ui.mine.resume.ResumePreviewActivity;
import com.qhzk.ciep.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by pucheng on 2016/12/19.
 * 我的求职(需判断用户是否登录,如果没有登录跳转登录页面)
 * 展示投递简历的列表
 */

public class MineJobActivity extends BaseActivity<MineJobPresenter> implements MineJobView {

    @BindView(R.id.springview)
    SpringView mSpringView;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private BaseQuickAdapter<Deliver, BaseViewHolder> mAdapter;
    private List<Deliver> mList = new ArrayList<>();
//    private DeleteDialog deleteDialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_job;
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
                mActivityPresenter.loadData();
            }
            @Override
            public void onLoadmore() {
                mActivityPresenter.loadMore();
            }
        });
    }

    @Override
    protected void initdata() {
        super.initdata();
        mAdapter = new BaseQuickAdapter<Deliver, BaseViewHolder>(R.layout.mine_job_item_layout, mList) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, Deliver deliver) {
                boolean contains = deliver.getCreateTime().contains(" ");
                if (contains){
                    baseViewHolder.setText(R.id.job_name, deliver.getPositionInfo().getTitle())
                            .setText(R.id.job_date, deliver.getCreateTime().split(" ")[0])
                            .setText(R.id.job_company, deliver.getEnterpriseInfo().getName())
                            .setText(R.id.job_category, deliver.getEnterpriseInfo().getIndustry());
                }else {
                    baseViewHolder.setText(R.id.job_name, deliver.getPositionInfo().getTitle())
                            .setText(R.id.job_date, deliver.getCreateTime())
                            .setText(R.id.job_company, deliver.getEnterpriseInfo().getName())
                            .setText(R.id.job_category, deliver.getEnterpriseInfo().getIndustry());
                }

            }
        };
        mAdapter.setEmptyView(View.inflate(this, R.layout.empty_view, null));
        // 点击事件
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Bundle bundle = new Bundle();
                bundle.putString("id", mList.get(i).getPositionId());
                readyGo(JobDetailActivity.class, bundle);
            }
        });
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
        mActivityPresenter.loadData();
    }


    @OnClick({R.id.edit_resume, R.id.preview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit_resume:
                readyGo(MineResumeActivity.class);
                break;
            case R.id.preview:
                readyGo(ResumePreviewActivity.class);
                break;
        }
    }

    @Override
    public void onLoadSuccess(List<Deliver> list) {
        mSpringView.onFinishFreshAndLoad();
        mList.clear();
        mList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadMore(List<Deliver> list) {
        mSpringView.onFinishFreshAndLoad();
        mList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(Exception e) {
        showToast("网络异常:"+e);
    }

    @Override
    public void onCancelSuccess() {
        //TODO 更新列表
    }

    @Override
    public void onCancelFailed() {
        showToast("操作失败");
    }
}
