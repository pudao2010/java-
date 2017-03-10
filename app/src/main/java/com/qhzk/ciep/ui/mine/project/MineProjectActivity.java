package com.qhzk.ciep.ui.mine.project;

import android.content.Intent;
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
import com.qhzk.ciep.entity.ProjectManage;
import com.qhzk.ciep.view.DeleteDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by QixiongYuan on 2016/11/9.
 * 项目管理
 */

public class MineProjectActivity extends BaseActivity<MineProjectPresenter> implements MineProjectView {

    private static final int REQUEST_ADD    = 1;   // 请求添加项目
    private static final int REQUEST_UPDATE = 2;   // 请求修改项目
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.springview)
    SpringView mSpringview;
    private List<ProjectManage> mList = new ArrayList<>();
    private BaseQuickAdapter<ProjectManage, BaseViewHolder> mAdapter;
    private DeleteDialog deleteDialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_project;
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
                mActivityPresenter.loadData(1, 20);
            }
            @Override
            public void onLoadmore() {
                mActivityPresenter.loadMore();
            }
        });
        mAdapter = new BaseQuickAdapter<ProjectManage, BaseViewHolder>(R.layout.mine_project_item_layout, mList) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, ProjectManage projectManage) {

                baseViewHolder.setText(R.id.project_name, projectManage.getName())
                        .setText(R.id.project_category, projectManage.getType()+"   |   "+projectManage.getSector())
                        .setText(R.id.project_date, projectManage.getReleasetime());
            }
        };
        mAdapter.setEmptyView(View.inflate(this, R.layout.empty_view, null));
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        mRecyclerview.setAdapter(mAdapter);
    }

    @Override
    protected void initdata() {
        super.initdata();
        mActivityPresenter.loadData(1, 20);
        // 点击事件
        mRecyclerview.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ProjectManage projectManage = mList.get(i);
                Bundle bundle = new Bundle();
                bundle.putSerializable("serializable", projectManage);
                readyGoForResult(EditProjectActivity.class, bundle, REQUEST_UPDATE);
            }

            @Override
            public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                if (deleteDialog == null) {
                    deleteDialog = new DeleteDialog(MineProjectActivity.this, () -> {
                        String id = mList.get(position).getId();
                        mActivityPresenter.deleteProject(id);
                    });
                }
                deleteDialog.show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == REQUEST_ADD){
                mActivityPresenter.loadData(1, 20);
            } else if (requestCode == REQUEST_UPDATE){
                mActivityPresenter.loadData(1, 20);
            }
        }
    }

    @OnClick(R.id.toolbar_right_title)
    public void onClick() {
        //发布项目
        readyGoForResult(EditProjectActivity.class, REQUEST_ADD);
    }

    @Override
    public void onLoadSuccess(List<ProjectManage> projectManages) {
        mSpringview.onFinishFreshAndLoad();
        mList.clear();
        mList.addAll(projectManages);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadNoMore(List<ProjectManage> projectManages) {
        mSpringview.onFinishFreshAndLoad();
        mList.addAll(projectManages);
        mAdapter.notifyDataSetChanged();
        showToast("没有更多数据了");
    }

    @Override
    public void onLoadMore(List<ProjectManage> projectManages) {
        mSpringview.onFinishFreshAndLoad();
        mList.addAll(projectManages);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDeleteSuccess() {
        mActivityPresenter.loadData(1, 20);
    }
}
