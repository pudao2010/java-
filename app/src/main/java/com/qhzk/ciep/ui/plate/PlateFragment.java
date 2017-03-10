package com.qhzk.ciep.ui.plate;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;
import com.qhzk.ciep.entity.MeetingEntity;
import com.qhzk.ciep.protocol.BaseProtocol;
import com.qhzk.ciep.protocol.MeetingProtocol;
import com.qhzk.ciep.ui.plateinfo.PlateInfoActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;

/**
 * Created by pudao on 2016/12/19.
 * 大会板块
 */

public class PlateFragment extends BaseFragment {

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    private List<MeetingEntity> mPlateList = new ArrayList<>();
    private BaseQuickAdapter<MeetingEntity, BaseViewHolder> mAdapter;
    private MeetingProtocol protocol;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_plate;
    }

    @Override
    protected void initview() {
        super.initview();
        mSwipeRefreshLayout.setOnRefreshListener(() -> getPlateInfo());

        mSwipeRefreshLayout.setColorSchemeResources(
                R.color.swiperefresh_color1, R.color.swiperefresh_color2,
                R.color.swiperefresh_color3, R.color.swiperefresh_color4);

        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        int stateBarHeight = getResources().getDimensionPixelSize(resourceId);
        AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) mToolbar.getLayoutParams();
        layoutParams.setMargins(0, stateBarHeight, 0, 0);
        mToolbar.setLayoutParams(layoutParams);
        mAdapter = new BaseQuickAdapter<MeetingEntity, BaseViewHolder>(R.layout.item_plate, mPlateList) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, MeetingEntity meetingEntity) {
                baseViewHolder.setText(R.id.name, meetingEntity.getName());
            }
        };
    }

    @Override
    protected void initdata() {
        super.initdata();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setAdapter(mAdapter);
        getPlateInfo();

        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                int id = mPlateList.get(i).getId();
                Bundle bundle = new Bundle();
                bundle.putInt("id", id);
                readyGo(PlateInfoActivity.class, bundle);
            }
        });

    }

    private void getPlateInfo() {
        if (protocol == null) {
            protocol = new MeetingProtocol();
        }
        protocol.loadDataByGet(new BaseProtocol.Callback<List<MeetingEntity>>() {
            @Override
            public void onError(Call call, Exception e, int id) {
                mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onResponse(List<MeetingEntity> meetingEntities, int id) {
                mSwipeRefreshLayout.setRefreshing(false);
                mPlateList.clear();
                mPlateList.addAll(meetingEntities);
                mAdapter.notifyDataSetChanged();
            }
        });
    }
}
