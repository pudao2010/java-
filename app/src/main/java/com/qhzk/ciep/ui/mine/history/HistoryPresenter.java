package com.qhzk.ciep.ui.mine.history;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.qhzk.ciep.db.CiepDatabaseHelper;
import com.qhzk.ciep.entity.EnterpriseEntity;
import com.qhzk.ciep.mvp.BasePresenter;
import com.qhzk.ciep.utils.ThreadUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pucheng on 2017/2/23.
 */

public class HistoryPresenter extends BasePresenter<HistoryView> {

    private List<EnterpriseEntity> mList = new ArrayList<>();

    public void loadData(Context context) {
        // 读取数据库文件
        CiepDatabaseHelper helper = new CiepDatabaseHelper(context, null, 1);
        SQLiteDatabase database = helper.getReadableDatabase();
//        String sql = "select * from Enterprise";
        ThreadUtil.runOnBackgroundThread(new Runnable() {
            @Override
            public void run() {
                Cursor cursor = database.query("Enterprise", null, null, null, null, null, null);
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        // 遍历cursor对象, 取出数据
                        EnterpriseEntity entity = new EnterpriseEntity();
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        entity.setName(name);
                        String type = cursor.getString(cursor.getColumnIndex("type"));
                        entity.setEnttype(type);
                        String industry = cursor.getString(cursor.getColumnIndex("industry"));
                        entity.setIndustry(industry);
                        String time = cursor.getString(cursor.getColumnIndex("time"));
                        entity.setTime(time);
                        String profile = cursor.getString(cursor.getColumnIndex("profile"));
                        entity.setProfile(profile);
                        String pdf = cursor.getString(cursor.getColumnIndex("pdf"));
                        entity.setPdfUrl(pdf);
                        mList.add(entity);
                    } while (cursor.moveToNext());
                    cursor.close();
                    ThreadUtil.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            getMvpView().onLoadSuccess(mList);
                        }
                    });
                }
            }
        });
    }

}
