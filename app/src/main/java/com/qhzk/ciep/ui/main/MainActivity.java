package com.qhzk.ciep.ui.main;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.RadioGroup;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.config.Constant;
import com.qhzk.ciep.ui.home.HomeFragment;
import com.qhzk.ciep.ui.login.LoginActivity;
import com.qhzk.ciep.ui.mine.MineFragment;
import com.qhzk.ciep.ui.plate.PlateFragment;
import com.qhzk.ciep.ui.tickets.TicketsFragment;
import com.qhzk.ciep.utils.SharedPrefUtil;
import com.qhzk.ciep.utils.StateBarTranslucentUtil;

import butterknife.BindView;
import cn.jpush.android.api.JPushInterface;

public class MainActivity extends BaseActivity<IMainPresenter> implements IMainView {

    @BindView(R.id.radio_container)
    RadioGroup mRadioGroup;
    private FragmentManager mFragmentManager;

    private HomeFragment mHomeFragment;
    private PlateFragment mPlateFragment;
    private TicketsFragment mTicketsFragment;
    private MineFragment mMineFragment;

    private RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = (group, checkedId) -> {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        switch (checkedId) {
            case R.id.icon_home:
                if (!mHomeFragment.isAdded()) {
                    transaction.add(R.id.content, mHomeFragment);
                }
                hideFragment(transaction);
                transaction.show(mHomeFragment);
                break;
            case R.id.icon_plate:
                if (!mPlateFragment.isAdded()) {
                    transaction.add(R.id.content, mPlateFragment);
                }
                hideFragment(transaction);
                transaction.show(mPlateFragment);
                break;
            case R.id.icon_ticket:
                if (isLogin()) {
                    if (!mTicketsFragment.isAdded()) {
                        transaction.add(R.id.content, mTicketsFragment);
                    }
                    hideFragment(transaction);
                    transaction.show(mTicketsFragment);
                } else {
                    readyGo(LoginActivity.class);
                    mRadioGroup.check(R.id.icon_home);
                }
                break;
            case R.id.icon_mine:
                if (!mMineFragment.isAdded()) {
                    transaction.add(R.id.content, mMineFragment);
                }
                hideFragment(transaction);
                transaction.show(mMineFragment);
                break;
        }
        transaction.commit();
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_temp;
    }

    @Override
    public void onLoginSuccess() {
        // 获取极光推送注册的ID
        String registrationID = JPushInterface.getRegistrationID(this);
        System.out.println("极光推送注册的ID======="+registrationID);
        boolean flag = SharedPrefUtil.getPrefBoolean(this, Constant.ISCOMMITJPUSHID);
        if (!flag) {
            mActivityPresenter.commitJpushId(registrationID);
        }

    }

    @Override
    public void onCommitJpushIDSuccess() {
        System.out.println("提交Jpush ID成功");
        SharedPrefUtil.savePrefBoolean(this, Constant.ISCOMMITJPUSHID, true);
    }

    @Override
    public void onCommitJpushIdFailed() {
        System.out.println("提交Jpush ID失败");
    }

    @Override
    public void onError(Exception e) {
        showToast("网络异常" + e);
    }

    @Override
    protected void initview() {
        super.initview();
        mFragmentManager = getSupportFragmentManager();
        StateBarTranslucentUtil.setStateBarTranslucent(this);

        mHomeFragment = new HomeFragment();
        mPlateFragment = new PlateFragment();
        mTicketsFragment = new TicketsFragment();
        mMineFragment = new MineFragment();
        mFragmentManager.beginTransaction()
                .add(R.id.content, mHomeFragment)
                .commit();
    }

    @Override
    protected void initdata() {
        super.initdata();
        // 去做一次登录
        String username = SharedPrefUtil.getPrefString(this, Constant.LOGIN_USER, "");
        String password = SharedPrefUtil.getPrefString(this, Constant.LOGIN_PASSWORD, "");
//        String md5Password = MD5Util.MD5(password);
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            mActivityPresenter.login(username, password);
        }
        mRadioGroup.check(R.id.icon_home);
        mRadioGroup.setOnCheckedChangeListener(mOnCheckedChangeListener);
    }

    /**
     * 隐藏所有Fragment
     */
    public void hideFragment(FragmentTransaction transaction) {

        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
        if (mPlateFragment != null) {
            transaction.hide(mPlateFragment);
        }
        if (mTicketsFragment != null) {
            transaction.hide(mTicketsFragment);
        }
        if (mMineFragment != null) {
            transaction.hide(mMineFragment);
        }
    }

    private long mExitTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - mExitTime > 2000) {
                mExitTime = System.currentTimeMillis();
                showToast("再按一次退出程序");
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private boolean isLogin() {
        String loginUser = SharedPrefUtil.getPrefString(this, Constant.LOGIN_USER, "");
        return !TextUtils.isEmpty(loginUser);
    }
}
