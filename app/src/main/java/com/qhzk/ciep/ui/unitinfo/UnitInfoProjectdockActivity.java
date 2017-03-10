package com.qhzk.ciep.ui.unitinfo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.liaoinstan.springview.widget.SpringView;
import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.entity.ProjectDock;
import com.qhzk.ciep.ui.projectdetail.ProjectDetailActivity;
import com.qhzk.ciep.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 单位信息页面 对应的 项目对接
 */
public class UnitInfoProjectdockActivity extends BaseActivity<UnitInfoProjectdockPresenter> implements UnitInfoProjectdockView {

    @BindView(R.id.springview)
    SpringView mSpringView;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    private List<ProjectDock> mList = new ArrayList<>();
    private BaseQuickAdapter<ProjectDock, BaseViewHolder> mAdapter;
    String userId;

    @Override
    public int getLayoutId() {
        return R.layout.activity_unit_info_projectdock;
    }

    @Override
    protected void initdata() {
        super.initdata();
        mActivityPresenter.loadData(userId);
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());
        mAdapter = new BaseQuickAdapter<ProjectDock, BaseViewHolder>(R.layout.item_unitinfo_projectdock, mList) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, ProjectDock projectDock) {
                baseViewHolder.setText(R.id.project_name, projectDock.getName())
                        .setText(R.id.project_sector, projectDock.getSector())
                        .setText(R.id.project_type, projectDock.getType())
                        .setText(R.id.project_releasetime, projectDock.getReleasetime());
            }
        };

        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Bundle bundle = new Bundle();
                bundle.putString("projectId", mList.get(i).getId());
                readyGo(ProjectDetailActivity.class, bundle);
            }
        });

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        userId = savedInstanceState.getString("userId");
    }

    @Override
    public void onLoadSuccess(List<ProjectDock> projectDocks) {
        mList.clear();
        mList.addAll(projectDocks);
        mAdapter.notifyDataSetChanged();
    }
}
