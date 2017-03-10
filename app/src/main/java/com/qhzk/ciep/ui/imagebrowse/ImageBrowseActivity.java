package com.qhzk.ciep.ui.imagebrowse;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.adapter.ViewPageAdapter;
import com.qhzk.ciep.base.BaseActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by pucheng
 * 图片浏览页面
 * 2017年1月9日15:21:55
 */
public class ImageBrowseActivity extends BaseActivity implements ViewPager.OnPageChangeListener, View.OnClickListener, ImageBrowseView {

    private ViewPager mViewPager;
    private TextView hint;
    private ViewPageAdapter mAdapter;
    private ImageBrowsePresenter mPresenter;
    private static ArrayList<String> mImages;
    private String url;
    private int index;

    @Override
    public int getLayoutId() {
        return R.layout.activity_image_browse;
    }

    @Override
    protected void initview() {
        super.initview();
        mViewPager = (ViewPager) this.findViewById(R.id.viewPager);
        hint = (TextView) this.findViewById(R.id.hint);
        findViewById(R.id.save).setOnClickListener(this);
        initPresenter();
        mPresenter.loadImage();
    }

    public void initPresenter() {
        mPresenter = new ImageBrowsePresenter(this);
    }

    @Override
    public Intent getDataIntent() {
        return getIntent();
    }

    @Override
    public void setImageBrowse(List<String> images, int position) {
        if (mAdapter == null && images != null && images.size() != 0) {
            mAdapter = new ViewPageAdapter(this, images);
            mViewPager.setAdapter(mAdapter);
            mViewPager.setCurrentItem(position);
            mViewPager.addOnPageChangeListener(this);
            hint.setText(position + 1 + "/" + images.size());
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mPresenter.setPosition(position);
        hint.setText(position + 1 + "/" + mPresenter.getImages().size());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * 点击保存图片到本地
     */
    @Override
    public void onClick(View v) {
        String[] split = hint.getText().toString().split("/");
        index = Integer.parseInt(split[0]) - 1;
        url = mImages.get(index);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            applyPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, 100);
        } else {
            downLoadFile(url, "展馆" + (index + 1));
        }
    }

    @Override
    protected void onApplyPermissionsResult(int requestCode, boolean isSuccess) {
        super.onApplyPermissionsResult(requestCode, isSuccess);
        if (requestCode == 100 && isSuccess) {
            downLoadFile(url, "展馆" + (index + 1));
        } else {
            showToast("申请写入SD卡失败");
            finish();
        }
    }

    /**
     * 启动ImageBrowseActivity所需要静态方法
     */
    public static void startActivity(Context context, ArrayList<String> images, int position) {
        mImages = images;
        Intent intent = new Intent(context, ImageBrowseActivity.class);
        intent.putStringArrayListExtra("images", images);
        intent.putExtra("position", position);
        context.startActivity(intent);
    }

    private void downLoadFile(String url, String fileName) {
        OkHttpUtils//
                .get()//
                .url(url)//
                .build()//
                .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(), fileName + ".jpg") {

                    @Override
                    public void inProgress(float progress, long total, int id) {
                        super.inProgress(progress, total, id);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d("tag", e.getMessage());
                    }

                    @Override
                    public void onResponse(File file, int id) {
                        Log.d("tag", file.getAbsolutePath());
                        showToast("图片已保存至"+file.getAbsolutePath());
                        // 把文件插入到系统图库
                        try {
                            MediaStore.Images.Media.insertImage(ImageBrowseActivity.this.getContentResolver(), file.getAbsolutePath(), fileName, null);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        // 通知图库更新
                        sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + file.getPath())));
                    }
                });
    }

}
