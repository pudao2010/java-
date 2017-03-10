package com.qhzk.ciep.ui.enterprise;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.db.CiepDatabaseHelper;
import com.qhzk.ciep.entity.EnterpriseEntity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Thisdk on 2016/9/8.
 * 单位信息页面
 */

public class EnterpriseActivity extends BaseActivity {

    private static final String BUNDLE_ENT = "BUNDLE_ENT";

    @BindView(R.id.pdf)
    ImageView mPdfImage;

    @BindView(R.id.category_text)
    TextView mCategoryText;
    @BindView(R.id.domain_text)
    TextView mDomainText;
    @BindView(R.id.synopsis_text)
    TextView mSynopsisText;
    @BindView(R.id.title_text)
    TextView mTitleText;

    private EnterpriseEntity mEnterpriseEntity;
    private CiepDatabaseHelper dbHelper;
    private boolean isExist = false;

    @Override
    public int getLayoutId() {
        return R.layout.activity_enterprise;
    }

    public static Bundle newBundle(EnterpriseEntity entity) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_ENT, entity);
        return bundle;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        mEnterpriseEntity = savedInstanceState.getParcelable(BUNDLE_ENT);
    }

    @Override
    protected void initdata() {
        super.initdata();
        String pdfUrl = mEnterpriseEntity.getPdfUrl();
        // 存入数据库
        dbHelper = new CiepDatabaseHelper(this, null, 1);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String time = sdf.format(date);
        // 先查询是否存在，如果存在就不再插入数据库
        Cursor cursor = database.query("Enterprise", null, null, null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                isExist = name.equals(mEnterpriseEntity.getName());
            }
            cursor.close();
        }
        String sql = "insert into Enterprise (name, type, industry, time, profile, pdf) values (?, ?, ?, ?, ?, ?)";
        String[] values = new String[]{mEnterpriseEntity.getName(),
                mEnterpriseEntity.getEnttype(),
                mEnterpriseEntity.getIndustry(),
                time, mEnterpriseEntity.getProfile(),
                pdfUrl == null ? "" : pdfUrl
        };
        // 执行SQL语句
        if (!isExist) {
            database.execSQL(sql, values);
        } else {
            // 更新数据
            String updateSql = "update Enterprise set time = ? where name = ? ";
            database.execSQL(updateSql, new String[]{time, mEnterpriseEntity.getName()});
        }

    }

    @Override
    protected void initview() {
        super.initview();

        mToolbar.setNavigationOnClickListener(v -> finish());

        if (TextUtils.isEmpty(mEnterpriseEntity.getPdfUrl()))
            mPdfImage.setVisibility(View.INVISIBLE);

        mTitleText.setText(mEnterpriseEntity.getName());
        mCategoryText.setText(mEnterpriseEntity.getEnttype());
        mDomainText.setText(mEnterpriseEntity.getIndustry());
        mSynopsisText.setText(mEnterpriseEntity.getProfile());

    }


    @OnClick(R.id.pdf)
    public void onClick(View view) {
        System.out.println(" ==================== " + ServiceConfig.BASE_URL + mEnterpriseEntity.getPdfUrl());
        readyGo(PDFDisplayActivity.class, PDFDisplayActivity.newActivityBundle(mEnterpriseEntity.getPdfUrl()));
    }

}
