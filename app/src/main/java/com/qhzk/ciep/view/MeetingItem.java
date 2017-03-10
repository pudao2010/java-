package com.qhzk.ciep.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qhzk.ciep.R;

/**
 * Created by Administrator on 2016/12/30.
 */

public class MeetingItem extends LinearLayout {

    private TextView meetingName;
    private TextView meetingNumber;

    public MeetingItem(Context context) {
        this(context, null);
    }

    public MeetingItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        View.inflate(context, R.layout.view_tab_meeting, this);
        meetingName = (TextView) findViewById(R.id.meeting_name);
        meetingNumber = (TextView) findViewById(R.id.meeting_number);
    }

    public void setAttribute(String name, String number){
        meetingName.setText(name);
        meetingNumber.setText(number);
    }
}
