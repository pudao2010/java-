package com.qhzk.ciep.ui.mine.meeting;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.entity.MyMeeting;
import com.qhzk.ciep.view.MeetingItem;

import java.util.List;

import butterknife.BindView;

public class MeetingDetailActivity extends BaseActivity {

    @BindView(R.id.meeting_container)
    LinearLayout mMeetingContainer;
    private List<MyMeeting.MeetingListBean> meetingList;

    @Override
    public int getLayoutId() {
        return R.layout.activity_meeting_detail;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        MyMeeting myMeeting = (MyMeeting) savedInstanceState.getSerializable("serializable");
        meetingList = myMeeting.getMeetingList();
    }

    @Override
    protected void initdata() {
        super.initdata();
        for (int i = 0; i < meetingList.size(); i++) {
            MeetingItem meetingItem = new MeetingItem(this);
            MyMeeting.MeetingListBean meetingListBean = meetingList.get(i);
            meetingItem.setAttribute(meetingListBean.getTitle(), meetingListBean.getSerilNum());
            mMeetingContainer.addView(meetingItem);
        }

    }
}
