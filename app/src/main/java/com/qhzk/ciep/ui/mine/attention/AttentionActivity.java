package com.qhzk.ciep.ui.mine.attention;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.entity.MyFocus;
import com.qhzk.ciep.ui.unitinfo.UnitInfoActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by QixiongYuan on 2016/11/14.
 * 我的关注
 */

public class AttentionActivity extends BaseActivity<AttentionPresenter> implements AttentionView {

//    @BindView(R.id.springview)
//    SpringView mSpringView;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private List<MyFocus.ResultBean> mList = new ArrayList<>();
    private BaseQuickAdapter<MyFocus.ResultBean, BaseViewHolder> mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_attention;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());

        mAdapter = new BaseQuickAdapter<MyFocus.ResultBean, BaseViewHolder>(R.layout.mine_attenttion_item_layout, mList) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, MyFocus.ResultBean resultBean) {
                baseViewHolder.setText(R.id.history_company, resultBean.getName())
                        .setText(R.id.history_category, resultBean.getIndustry());
//                        .setText(R.id.history_location, resultBean.)
            }
        };
        mAdapter.setEmptyView(View.inflate(this, R.layout.empty_view, null));
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                String id = mList.get(i).getId();
                Bundle bundle = new Bundle();
                bundle.putString("id", id);
                readyGo(UnitInfoActivity.class, bundle);
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

    @Override
    public void onLoadSuccess(MyFocus myFocus) {
        mList.clear();
        mList.addAll(myFocus.getResult());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadNodata() {
        showToast("您还没有关注企业");
    }
}
