package com.qhzk.ciep.view;

import android.app.DatePickerDialog;
import android.content.Context;

import com.qhzk.ciep.R;

/**
 * Created by pucheng on 2017/2/7.
 *
 */

public class CiepDataPicker extends DatePickerDialog {

    public CiepDataPicker(Context context, OnDateSetListener listener, int year, int month, int dayOfMonth) {
        this(context, R.style.CiepDatePickerDialogTheme, listener, year, month, dayOfMonth);
    }

    public CiepDataPicker(Context context, int themeResId, OnDateSetListener listener, int year, int monthOfYear, int dayOfMonth) {
        super(context, R.style.CiepDatePickerDialogTheme, listener, year, monthOfYear, dayOfMonth);
    }
}
