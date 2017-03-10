package com.qhzk.ciep.ui.projectdock.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;
import com.qhzk.ciep.entity.ProjectRequireEntity;
import com.qhzk.ciep.ui.projectdetail.ProjectDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/14.
 * 项目引进
 */

public class ProjectPromotionFragment extends BaseFragment<ProjectPromotionPresenter> implements ProjectPromotionView{

    private List<ProjectRequireEntity> mLists = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private SpringView mSpringView;
    private BaseQuickAdapter<ProjectRequireEntity, BaseViewHolder> mAdapter;
    @BindView(R.id.progressbar)
    ProgressBar mProgressBar;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_project_promotion;
    }

    @Override
    protected void initview() {
        super.initview();
        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.recyclerview);
        mSpringView = (SpringView) mRootView.findViewById(R.id.springview);
        mSpringView.setHeader(new DefaultHeader(this.getContext()));
        mSpringView.setFooter(new DefaultFooter(this.getContext()));
        mSpringView.setType(SpringView.Type.FOLLOW);
        mSpringView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                if (mFragmentPresenter != null) {
                    mFragmentPresenter.loadData("0");
                    mFragmentPresenter.page = 1;
                }

            }
            @Override
            public void onLoadmore() {
                if (mFragmentPresenter != null) {
                    mFragmentPresenter.loadMore("0");
                }

            }
        });
    }

    @Override
    protected void initdata() {
        super.initdata();
        mAdapter = new BaseQuickAdapter<ProjectRequireEntity, BaseViewHolder>(R.layout.item_project_dock, mLists) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, ProjectRequireEntity projectRequireEntity) {
                baseViewHolder.setText(R.id.project_name, projectRequireEntity.getName())
                        .setText(R.id.project_date, projectRequireEntity.getReleasetime())
                        .setText(R.id.project_type,projectRequireEntity.getType())
                        .setText(R.id.project_sector, projectRequireEntity.getSector());
            }
        };

        // 点击事件
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Bundle bundle = new Bundle();
                bundle.putString("projectId", mLists.get(i).getId());
                readyGo(ProjectDetailActivity.class, bundle);
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
        mFragmentPresenter.loadData("0");
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {
       mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onLoadSuccess(List<ProjectRequireEntity> list) {
        mSpringView.onFinishFreshAndLoad();
        mLists.clear();
        mLists.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFilterSuccess(List<ProjectRequireEntity> list) {
//        mSpringView.onFinishFreshAndLoad();
        mLists.clear();
        mLists.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFilterFailed(List<ProjectRequireEntity> list) {
        showToast("没有找到符合条件的项目");
    }

    @Override
    public void onLoadMore(List<ProjectRequireEntity> list) {
        mSpringView.onFinishFreshAndLoad();
        mLists.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    public void onFilter(String projectName, String projectType, String sector, String releaseType){
        String searchType = "推广";
        mFragmentPresenter.filter(projectName,projectType,sector,releaseType,searchType);
    }
}
