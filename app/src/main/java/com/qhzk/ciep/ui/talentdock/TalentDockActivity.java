package com.qhzk.ciep.ui.talentdock;

import android.app.ProgressDialog;
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
import com.qhzk.ciep.entity.UnitInfoEntity;
import com.qhzk.ciep.ui.jobdetail.JobDetailActivity;
import com.qhzk.ciep.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 人才对接
 */
public class TalentDockActivity extends BaseActivity<TalentDockPresenter> implements TalentDockView {

    public static final int REQUEST_FILTER = 100; //请求过滤职位
    @BindView(R.id.springview)
    SpringView mSpringView;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    private BaseQuickAdapter<UnitInfoEntity.ResultBean, BaseViewHolder> mAdapter;
    private List<UnitInfoEntity.ResultBean> mList;
    private ProgressDialog mProgressDialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_talent_dock;
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
                mActivityPresenter.loadData(1,20);
            }
            @Override
            public void onLoadmore() {
                mActivityPresenter.loadMore();
            }
        });
        mList = new ArrayList<>();
        mAdapter = new BaseQuickAdapter<UnitInfoEntity.ResultBean, BaseViewHolder>(R.layout.item_unit_info, mList) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, UnitInfoEntity.ResultBean resultBean) {
                baseViewHolder.setText(R.id.title, resultBean.getTitle())
                        .setText(R.id.name, resultBean.getEnterprise().getName())
                        .setText(R.id.date, resultBean.getPublishDate().split(" ")[0])
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
        mRecyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerview.setAdapter(mAdapter);
    }

    @Override
    public void showProgress(){
        if (mProgressDialog == null){
            mProgressDialog = new ProgressDialog(this);
        }
        mProgressDialog.setMessage("正在加载中");
    }

    @Override
    public void hideProgress(){
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    protected void initdata() {
        super.initdata();
        mActivityPresenter.loadData(1,20);
    }

    @OnClick(R.id.filter)
    public void onClick() {
        Intent intent = new Intent(this, UnitInfoFilterActivity.class);
        startActivityForResult(intent, REQUEST_FILTER);
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

    @Override
    public void onFilterSuccess(UnitInfoEntity unitInfoEntity) {
        List<UnitInfoEntity.ResultBean> result = unitInfoEntity.getResult();
        mList.clear();
        mList.addAll(result);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFilterFailed(UnitInfoEntity unitInfoEntity) {
        showToast("抱歉, 没有找到符合条件的职位");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_FILTER && resultCode == RESULT_OK){
            String title = data.getStringExtra("title");
            String entName = data.getStringExtra("entName");
            String salRange = data.getStringExtra("salRange");
            String experience = data.getStringExtra("experience");
            String education = data.getStringExtra("education");
            String major = data.getStringExtra("major");
            String industry = data.getStringExtra("industry");
            String jobType = data.getStringExtra("jobType");
            mActivityPresenter.fiterJob(1, 20, title, entName, salRange, experience, education, major, industry, jobType);
        }
    }
}
