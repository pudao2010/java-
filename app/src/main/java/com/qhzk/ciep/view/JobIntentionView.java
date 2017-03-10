package com.qhzk.ciep.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qhzk.ciep.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/26.
 * 求职意向 包含(职位名称. 期望薪资)
 */

public class JobIntentionView extends LinearLayout {
    @BindView(R.id.job_title)
    TextView mJobTitle;
    @BindView(R.id.salary_expect)
    TextView mSalaryExpect;

    public JobIntentionView(Context context) {
        this(context, null);
    }

    public JobIntentionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View.inflate(context, R.layout.layout_job_intention, this);
        ButterKnife.bind(this);
    }

    public void setAttribute(String title, String salary){
        mJobTitle.setText(title);
        mSalaryExpect.setText(salary);
    }
}
