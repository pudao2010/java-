package com.qhzk.ciep.ui.search.unit;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;
import com.qhzk.ciep.entity.SearchUnitEntity;
import com.qhzk.ciep.ui.unitinfo.UnitInfoActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by QixiongYuan on 2016/11/12.
 * 参展单位
 */

public class UnitFragment extends BaseFragment {

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    private List<SearchUnitEntity.EnterpriseBean.RowsBean> mList = new ArrayList<>();
    private BaseQuickAdapter<SearchUnitEntity.EnterpriseBean.RowsBean, BaseViewHolder> mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search_unit;
    }

    @Override
    protected void initview() {
        super.initview();
        mAdapter = new BaseQuickAdapter<SearchUnitEntity.EnterpriseBean.RowsBean, BaseViewHolder>(R.layout.search_unit_item_layout, mList) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, SearchUnitEntity.EnterpriseBean.RowsBean rowsBean) {
                baseViewHolder.setText(R.id.history_company, rowsBean.getName())
                        .setText(R.id.history_category, rowsBean.getIndustry())
                        .setText(R.id.history_location, rowsBean.getModule());
            }
        };

        // 点击事件
        mRecyclerview.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Bundle bundle = new Bundle();
                bundle.putString("id", mList.get(i).getId());
                readyGo(UnitInfoActivity.class, bundle);
            }
        });

        mRecyclerview.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerview.setAdapter(mAdapter);
    }

    public void onSearchSuccess(List<SearchUnitEntity.EnterpriseBean.RowsBean> rows) {
        mList.clear();
        mList.addAll(rows);
        mAdapter.notifyDataSetChanged();
    }
}
