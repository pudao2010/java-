package com.qhzk.ciep.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qhzk.ciep.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/26.
 * 工作经验抽取一个自定义View 包含(公司, 工作时间)
 */

public class WorkExpView extends RelativeLayout {
    @BindView(R.id.work_company)
    TextView mWorkCompany;
    @BindView(R.id.work_time)
    TextView mWorkTime;

    public WorkExpView(Context context) {
        this(context, null);
    }

    public WorkExpView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View.inflate(context, R.layout.layout_work_exp, this);
        ButterKnife.bind(this);
    }

    public void setAttribute(String workCompany, String workTime){
        mWorkCompany.setText(workCompany);
        mWorkTime.setText(workTime);
    }
}
