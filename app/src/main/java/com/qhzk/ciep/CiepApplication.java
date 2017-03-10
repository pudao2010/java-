package com.qhzk.ciep;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.qhzk.ciep.common.okhttp.OkHttpClientManage;
import com.qhzk.ciep.common.retrofit.RetrofitManage;
import com.qhzk.ciep.config.CacheConfig;
import com.qhzk.ciep.library_zxing.ZXingLibrary;
import com.qhzk.ciep.utils.DiskUtil;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;
import com.zhy.http.okhttp.OkHttpUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import cn.jpush.android.api.JPushInterface;
import cn.sharesdk.framework.ShareSDK;
import okhttp3.OkHttpClient;

/**
 * Created by Thisdk on 2016/8/27.
 * 全局的App类
 */
public class CiepApplication extends Application {

    private static CiepApplication sAppApplication;

    private String TAG = getClass().getSimpleName();

    //目录仓库
    private Map<String, File> mCatalogRepertory;
    //缓存目录,可能被清理
    private File mCacheHome;
    //缓存目录,长期,卸载应用才会消失
    private File mFileHome;
    //版本信息
    private String mAppVersionName;
    private int mAppVersionCode;
    private RefWatcher refWatcher;

    public static RefWatcher getRefWatcher(Context context) {
        CiepApplication application = (CiepApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sAppApplication = this;
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        //安装leakcanary
        refWatcher = LeakCanary.install(this);
        //初始化应用运行时信息
        initCacheCatalog();
        //初始化网络框架
        initOKHttpUtils();
        //App版本信息
        PackageManager manager = this.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
            mAppVersionName = info.versionName;
            mAppVersionCode = info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        ZXingLibrary.initDisplayOpinion(CiepApplication.this);
        // 当发布release版本时,将调试模式置为false
        JPushInterface.setDebugMode(false);
        JPushInterface.init(CiepApplication.this);

        ShareSDK.initSDK(CiepApplication.this);

        initTencentX5();

    }

    private void initOKHttpUtils() {
        OkHttpClientManage.init(this);
        RetrofitManage.init(OkHttpClientManage.getOkHttpCacheClient());
        // 保证单例模式
        OkHttpClient okHttpCacheClient = OkHttpClientManage.getOkHttpCacheClient();
        OkHttpUtils.initClient(okHttpCacheClient);
    }

    // 初始化腾讯浏览器X5内核服务
    private void initTencentX5() {
        QbSdk.PreInitCallback callback = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                Log.e("app", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
            }
        };
        QbSdk.setTbsListener(new TbsListener() {
            @Override
            public void onDownloadFinish(int i) {
                Log.d("app", "onDownloadFinish");
            }

            @Override
            public void onInstallFinish(int i) {
                Log.d("app", "onInstallFinish");
            }

            @Override
            public void onDownloadProgress(int i) {
                Log.d("app", "onDownloadProgress:" + i);
            }
        });
        QbSdk.initX5Environment(getApplicationContext(), callback);
    }

    private void initCacheCatalog() {
        mCatalogRepertory = new HashMap<>();
        boolean enable = DiskUtil.isSDCardEnable();
        mCacheHome = enable ? getExternalCacheDir() : getCacheDir();
        mFileHome = enable ? getExternalFilesDir(null) : getFilesDir();
        if (mCacheHome != null && !mCacheHome.exists()) mCacheHome.mkdirs();
        if (mFileHome != null && !mFileHome.exists()) mFileHome.mkdirs();
        for (String catalog : CacheConfig.CATALOG_CACHE) {
            File file = new File(mCacheHome, catalog);
            if (!file.exists()) file.mkdirs();
            mCatalogRepertory.put(catalog, file);
        }
    }

    public File getAppCatalog(String catalogKey) {
        return mCatalogRepertory.get(catalogKey);
    }

    public File getCacheHome() {
        return mCacheHome;
    }

    public File getFileHome() {
        return mFileHome;
    }

    public String getAppVersionName() {
        return mAppVersionName;
    }

    public int getAppVersionCode() {
        return mAppVersionCode;
    }

    public static CiepApplication getApplication() {
        return sAppApplication;
    }

}
