package com.qhzk.ciep.ui.mine.meeting;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.MyMeeting;
import com.qhzk.ciep.mvp.BasePresenter;

import java.util.List;

/**
 * Created by Administrator on 2016/12/30.
 */

public class MeetingPresenter extends BasePresenter<MeetingView>{
    public void loadData(){
        mApi.getMyMeetings(new ResultSubscriber<List<MyMeeting>>(this) {
            @Override
            public void onSuccess(List<MyMeeting> myMeetings) {
                getMvpView().onLoadSuccess(myMeetings);
            }
        });
    }
}
