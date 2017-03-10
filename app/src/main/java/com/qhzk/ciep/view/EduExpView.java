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
 * 教育经历抽取一个自定义View 包含三个要素(学校, 学历, 时间)
 */

public class EduExpView extends RelativeLayout {

    @BindView(R.id.college)
    TextView mCollege;
    @BindView(R.id.degree)
    TextView mDegree;
    @BindView(R.id.edu_time)
    TextView mEduTime;

    public EduExpView(Context context) {
        this(context, null);
    }

    public EduExpView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View.inflate(context, R.layout.layout_edu_experience, this);
        ButterKnife.bind(this);
    }

    /**
     * 对外暴露一个可以设置属性的方法
     */
    public void setAttribute(String college, String degree, String edutime){
        if (college != null) {
            mCollege.setText(college);
        }
        if (degree != null) {
            mDegree.setText(degree);
        }
        if (edutime != null) {
            mEduTime.setText(edutime);
        }
    }

}
