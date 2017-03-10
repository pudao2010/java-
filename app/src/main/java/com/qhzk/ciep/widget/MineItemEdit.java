package com.qhzk.ciep.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qhzk.ciep.R;

/**
 * Created by pucheng on 2017/1/6.
 */

public class MineItemEdit extends LinearLayout implements View.OnClickListener {

    private EditText mValue;

    public MineItemEdit(Context context) {
        this(context, null);
    }

    public MineItemEdit(Context context, AttributeSet attrs) {
        super(context, attrs);
        View.inflate(context, R.layout.view_mine_edit, this);
        TextView mKey = (TextView) findViewById(R.id.mine_itme_key);
        mValue = (EditText) findViewById(R.id.mine_item_value);
        findViewById(R.id.mine_del).setOnClickListener(this);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MineItemEdit);
        String itemKey = typedArray.getString(R.styleable.MineItemEdit_itemEditKey);
        String itemValue = typedArray.getString(R.styleable.MineItemEdit_itemEditValue);
        String itemHint = typedArray.getString(R.styleable.MineItemEdit_itemEditHint);
        mKey.setText(itemKey);
        mValue.setText(itemValue);
        mValue.setHint(itemHint);
        typedArray.recycle();
    }

    public String getValue(){
        return mValue.getText().toString().trim();
    }

    @Override
    public void onClick(View v) {
        mValue.setText("");
    }

    public void setValue(String value){
        mValue.setText(value);
    }
}
