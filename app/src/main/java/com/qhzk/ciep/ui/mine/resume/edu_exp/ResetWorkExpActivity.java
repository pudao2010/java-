package com.qhzk.ciep.ui.mine.resume.edu_exp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.entity.Resume;
import com.qhzk.ciep.ui.mine.resume.edu_exp.reset.WorkExpActivity;
import com.qhzk.ciep.view.DeleteDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 蒲导 on 2016/11/23.
 * 2016年12月20日15:03:44
 * 修改工作经历
 */

public class ResetWorkExpActivity extends BaseActivity<ResetWorkExpPresenter> implements ResetWorkExpView {

    private static final int REQUEST_ADD = 1;       //请求添加
    private static final int REQUEST_UPDATE = 2;    //请求修改
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private List<Resume.ResumeBean.WorkExperienceListBean> mList = new ArrayList<>();
    private BaseQuickAdapter<Resume.ResumeBean.WorkExperienceListBean, BaseViewHolder> mAdapter;
    private DeleteDialog deleteDialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_edu_exp;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());

        mAdapter = new BaseQuickAdapter<Resume.ResumeBean.WorkExperienceListBean, BaseViewHolder>(R.layout.mine_resume_item_layout, mList) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, Resume.ResumeBean.WorkExperienceListBean workExperienceListBean) {
                baseViewHolder.setText(R.id.work_company, workExperienceListBean.getCompany())
                        .setText(R.id.work_time, workExperienceListBean.getStartdate() + "至" + workExperienceListBean.getEnddate());
            }
        };

        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                // 工作经历对应id
                Resume.ResumeBean.WorkExperienceListBean workExperienceListBean = mList.get(i);
                Bundle bundle = new Bundle();
                bundle.putSerializable("serializable", workExperienceListBean);
                readyGoForResult(WorkExpActivity.class, bundle, REQUEST_UPDATE);
            }

            @Override
            public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                String id = mList.get(position).getId();
                if (deleteDialog == null) {
                    deleteDialog = new DeleteDialog(ResetWorkExpActivity.this, () ->
                            mActivityPresenter.deleteWorkExp(id));
                }
                deleteDialog.show();
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initdata() {
        super.initdata();
        mActivityPresenter.loadData();
    }

    @OnClick({R.id.reset_add_edu_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.reset_add_edu_layout:
                readyGoForResult(WorkExpActivity.class, REQUEST_ADD);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_ADD) {
                initdata();
            }
            if (requestCode == REQUEST_UPDATE) {
                initdata();
            }
        }
    }

    @Override
    public void onLoadSuccess(List<Resume.ResumeBean.WorkExperienceListBean> workExperienceList) {
        mList.clear();
        mList.addAll(workExperienceList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadFailed(Exception e) {
        showToast("获取信息失败 :" + e);
    }

    @Override
    public void onCommitSuccess() {
        showToast("保存成功");
        finish();
    }

    @Override
    public void onDeleteSuccess() {
       initdata();
    }

}
