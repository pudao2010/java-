package com.qhzk.ciep.ui.mine.meeting;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.entity.MyMeeting;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by QixiongYuan on 2016/11/14.
 * 我的会议
 */

public class MeetingActivity extends BaseActivity<MeetingPresenter> implements MeetingView{

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    private List<MyMeeting> mList = new ArrayList<>();
    private BaseQuickAdapter<MyMeeting, BaseViewHolder> mAdapter;
    @Override
    public int getLayoutId() {
        return R.layout.activity_meeting;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());
        mAdapter = new BaseQuickAdapter<MyMeeting, BaseViewHolder>(R.layout.mine_meeting_item_layout, mList) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, MyMeeting myMeeting) {
                baseViewHolder.setText(R.id.plate_name, myMeeting.getName())
                        .setText(R.id.contact_name, "联系人 : "+myMeeting.getContract())
                        .setText(R.id.contact_mobile, "电话 : "+myMeeting.getPhoneNum());
            }
        };
    }

    @Override
    protected void initdata() {
        super.initdata();
        mActivityPresenter.loadData();
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerview.setAdapter(mAdapter);

        mRecyclerview.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MyMeeting myMeeting = mList.get(i);
                Bundle bundle = new Bundle();
                bundle.putSerializable("serializable", myMeeting);
                readyGo(MeetingDetailActivity.class, bundle);
            }
        });
    }

    @Override
    public void onLoadSuccess(List<MyMeeting> myMeetings) {
        mList.clear();
        mList.addAll(myMeetings);
        mAdapter.notifyDataSetChanged();
    }
}
