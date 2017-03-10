package com.qhzk.ciep.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qhzk.ciep.R;

/**
 * Created by pucheng on 2017/1/6.
 * 个人资料相关的自定义组合控件, 弹出底部对话框
 */

public class MineItemView extends LinearLayout {

    private TextView mValue;
    private TextView mKey;

    public MineItemView(Context context) {
        this(context, null);
    }

    public MineItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View.inflate(context, R.layout.view_mine_item, this);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MineItemView);
        String itemKey = typedArray.getString(R.styleable.MineItemView_itemKey);
        String itemValue = typedArray.getString(R.styleable.MineItemView_itemValue);
        mKey = (TextView) findViewById(R.id.mine_itme_key);
        mValue = (TextView) findViewById(R.id.mine_item_value);
        mKey.setText(itemKey);
        mValue.setText(itemValue);
        typedArray.recycle();
    }

    public void setItemKey(String key){
        mKey.setText(key);
    }

    public void setItemValue(String value){
        mValue.setText(value);
    }

    public String getValue(){
        return mValue.getText().toString().trim();
    }
}
