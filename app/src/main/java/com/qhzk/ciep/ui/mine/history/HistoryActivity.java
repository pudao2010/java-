package com.qhzk.ciep.ui.mine.history;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.entity.EnterpriseEntity;
import com.qhzk.ciep.ui.enterprise.EnterpriseActivity;
import com.qhzk.ciep.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by QixiongYuan on 2016/11/10.
 * 2016年12月26日17:05:38
 * 浏览记录 只记录通过 扫描二维码查看的企业
 */

public class HistoryActivity extends BaseActivity<HistoryPresenter> implements HistoryView {

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    private BaseQuickAdapter<EnterpriseEntity, BaseViewHolder> mAdapter;
    private List<EnterpriseEntity> mList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_history;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initdata() {
        super.initdata();
        mAdapter = new BaseQuickAdapter<EnterpriseEntity, BaseViewHolder>(R.layout.mine_history_item_layout, mList) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, EnterpriseEntity enterpriseEntity) {
                baseViewHolder.setText(R.id.history_company, enterpriseEntity.getName())
                        .setText(R.id.history_category, enterpriseEntity.getEnttype())
                        .setText(R.id.history_date, enterpriseEntity.getTime());
            }
        };
        mAdapter.setEmptyView(View.inflate(this, R.layout.empty_view, null));
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                //
                readyGo(EnterpriseActivity.class, EnterpriseActivity.newBundle(mList.get(i)));
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setAdapter(mAdapter);
        mActivityPresenter.loadData(this);
    }

    @Override
    public void onLoadSuccess(List<EnterpriseEntity> list) {
        mList.clear();
        mList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }
}
