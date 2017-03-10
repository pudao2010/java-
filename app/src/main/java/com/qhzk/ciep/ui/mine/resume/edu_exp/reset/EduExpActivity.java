package com.qhzk.ciep.ui.mine.resume.edu_exp.reset;

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
import com.qhzk.ciep.view.DeleteDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class EduExpActivity extends BaseActivity<EduExpPresenter> implements EduExpView {

    private static final int REQUEST_ADD = 1;    //请求添加教育经历
    private static final int REQUEST_UPDATE = 2;    //请求修改教育经历
    private List<Resume.ResumeBean.EducationListBean> mList = new ArrayList<>();
    private BaseQuickAdapter<Resume.ResumeBean.EducationListBean, BaseViewHolder> mAdapter;
    private DeleteDialog deleteDialog;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @Override
    public int getLayoutId() {
        return R.layout.activity_edu_exp;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());

        mAdapter = new BaseQuickAdapter<Resume.ResumeBean.EducationListBean, BaseViewHolder>(R.layout.mine_resume_item_layout, mList) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, Resume.ResumeBean.EducationListBean educationListBean) {
                baseViewHolder.setText(R.id.work_company, educationListBean.getSchool())
                        .setText(R.id.work_time, educationListBean.getStartdate() + "至" + educationListBean.getEnddate());
            }
        };

        mRecyclerview.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Resume.ResumeBean.EducationListBean educationListBean = mList.get(i);
                Bundle bundle = new Bundle();
                bundle.putSerializable("serializable", educationListBean);
                readyGoForResult(ResetEduExpActivity.class, bundle, REQUEST_UPDATE);
            }

            @Override
            public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                String id = mList.get(position).getId();
                if (deleteDialog == null) {
                    deleteDialog = new DeleteDialog(EduExpActivity.this, () -> mActivityPresenter.deleteEduExp(id));
                }
                deleteDialog.show();
            }
        });

        mRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerview.setAdapter(mAdapter);
    }

    @Override
    protected void initdata() {
        super.initdata();
        mActivityPresenter.loadResume();
    }

    @OnClick(R.id.add_edu_layout)
    public void onClick() {
        // 添加教育经历
        readyGoForResult(ResetEduExpActivity.class, REQUEST_ADD);
    }

    @Override
    public void onLoadEduSuccess(List<Resume.ResumeBean.EducationListBean> educationList) {
        mList.clear();
        mList.addAll(educationList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadFailed(Exception e) {
        showToast("网络异常:" + e);
    }

    @Override
    public void onDeleteSuccess() {
       initdata();
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
}
