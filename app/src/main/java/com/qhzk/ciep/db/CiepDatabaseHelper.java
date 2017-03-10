package com.qhzk.ciep.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pucheng on 2017/2/23.
 * 目的 : 存储用户通过扫描二维码查看的企业,存储在数据库中
 * 便于在浏览记录中展示
 */

public class CiepDatabaseHelper extends SQLiteOpenHelper{

    public static final String CREATE_ENTERPRISE = "create table Enterprise ("
            + "id integer primary key autoincrement, " // 数据库主键
            + "name text, "                            // 企业名称
            + "type text, "                            // 单位类别
            + "industry text, "                        // 行业领域
            + "time text, "                            // 浏览时间
            + "profile text, "                         // 单位简介
            + "pdf text)";                             // pdf地址

    /**
     *
     * @param context 上下文环境
     *     数据库文件名, 直接写死 ciep.db
     * @param factory 可以填null
     * @param version 数据库的版本号
     */
    public CiepDatabaseHelper(Context context, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "ciep.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ENTERPRISE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
