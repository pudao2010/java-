package com.qhzk.ciep.base;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.qhzk.ciep.CiepApplication;
import com.qhzk.ciep.R;
import com.qhzk.ciep.mvp.BasePresenter;
import com.qhzk.ciep.mvp.MvpView;
import com.qhzk.ciep.utils.ReflexUtil;
import com.qhzk.ciep.utils.StateBarTranslucentUtil;
import com.squareup.leakcanary.RefWatcher;

import butterknife.ButterKnife;


/**
 * Created by Thisdk on 2016/3/23.
 * 基础的Activity,封装了公用的方法
 * 添加了presenter的自动管理
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements MvpView {

    protected String TAG = getClass().getSimpleName();

    public abstract int getLayoutId();

    protected P mActivityPresenter;

    protected Toolbar mToolbar;

    protected LayoutInflater mLayoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initActivityPresenter();
        if (savedInstanceState == null)
            savedInstanceState = getIntent().getExtras();
        if (savedInstanceState != null)
            init(savedInstanceState);
        mLayoutInflater = getLayoutInflater();
        initview();
        initdata();
    }

    private void initActivityPresenter() {
        try {
            Class<P> classGeneric = ReflexUtil.getClassGeneric(this, 0);
            if (classGeneric != null) {
                mActivityPresenter = classGeneric.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (mActivityPresenter != null) {
            Class mvpViewClass = mActivityPresenter.getMvpViewClass();
            if (mvpViewClass == null) {
                throw new RuntimeException("the presenter is not generic type");
            }
            boolean isHaveMvpViewInterface = false;
            Class<?>[] interfaces = getClass().getInterfaces();
            for (Class clazz : interfaces) {
                if (mvpViewClass == clazz) {
                    isHaveMvpViewInterface = true;
                    break;
                }
            }
            if (!isHaveMvpViewInterface) {
                throw new RuntimeException("please implements MvpView : " + mvpViewClass.getName());
            }
            mActivityPresenter.attachView(this);
        }
    }

    protected void init(Bundle savedInstanceState) {
    }

    protected void initview() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar == null) return;
        StateBarTranslucentUtil.setStateBarTranslucent(this);
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        int stateBarHeight = getResources().getDimensionPixelSize(resourceId);
        AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) mToolbar.getLayoutParams();
        layoutParams.setMargins(0, stateBarHeight, 0, 0);
        mToolbar.setLayoutParams(layoutParams);
    }

    protected void initdata() {
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        if (mActivityPresenter != null) {
            mActivityPresenter.detachView();
            mActivityPresenter = null;
        }

        RefWatcher refWatcher = CiepApplication.getRefWatcher(this);
        refWatcher.watch(this);
    }

    /**
     * 运行时权限封装
     *
     * @param permission
     * @param requestCode
     */

    protected void applyPermissions(String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{permission}, requestCode);
        } else {
            onApplyPermissionsResult(requestCode, true);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length == 0) {
            onApplyPermissionsResult(requestCode, false);
            return;
        }
        onApplyPermissionsResult(requestCode, grantResults[0] == PackageManager.PERMISSION_GRANTED);
    }

    protected void onApplyPermissionsResult(int requestCode, boolean isSuccess) {
    }

    //---------------------------------------------------------------------------------

    protected void readyGo(Class<? extends BaseActivity> clazz) {
        startActivity(new Intent(this, clazz));
    }

    protected void readyGoForResult(Class<? extends BaseActivity> clazz, int requestCode) {
        startActivityForResult(new Intent(this, clazz), requestCode);
    }

    protected void readyGoForResult(Class<? extends BaseActivity> clazz, Bundle bundle, int requestCode) {
        Intent intent = new Intent(this, clazz);
        intent.putExtras(bundle);
        startActivityForResult(intent, requestCode);
        //设置切换动画，从右边进入，左边退出
//        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }

    protected void readyGo(Class<? extends BaseActivity> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        intent.putExtras(bundle);
        startActivity(intent);
        //设置切换动画，从右边进入，左边退出
//        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }

    protected void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    protected void showToast(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }

    /**
     * MvpView 中的接口方法.这里的是默认实现,如果需要其他方式的展示错误,请在子类重写
     *
     * @param msg
     */
    @Override
    public void showErrorInfo(String msg) {
        showToast(msg);
    }

}
