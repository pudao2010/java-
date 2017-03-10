package com.qhzk.ciep.ui.mine.meeting;

import com.qhzk.ciep.entity.MyMeeting;
import com.qhzk.ciep.mvp.MvpView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/30.
 */

public interface MeetingView extends MvpView{

    void onLoadSuccess(List<MyMeeting> myMeetings);
}
