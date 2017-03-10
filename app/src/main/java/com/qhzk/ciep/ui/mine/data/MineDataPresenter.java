package com.qhzk.ciep.ui.mine.data;

import com.qhzk.ciep.CiepApplication;
import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.config.Constant;
import com.qhzk.ciep.mvp.BasePresenter;
import com.qhzk.ciep.protocol.CiepProtocol;
import com.qhzk.ciep.protocol.ResumeInfoProtocol;
import com.qhzk.ciep.utils.SharedPrefUtil;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/12/27.
 */

public class MineDataPresenter extends BasePresenter<MineDataView> {

    public void uploadData(){
        String username = SharedPrefUtil.getPrefString(CiepApplication.getApplication(), Constant.LOGIN_USER, "");
        String password = SharedPrefUtil.getPrefString(CiepApplication.getApplication(), Constant.LOGIN_PASSWORD, "");
        if (!username.equals("") && !password.equals("")){
            mApi.login(username, password, new ResultSubscriber<Void>(this) {
                @Override
                public void onSuccess(Void aVoid) {
                    new ResumeInfoProtocol(new CiepProtocol.Callback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            System.out.println("错误===="+e);
                            getMvpView().onUploadFailed();
                        }

                        @Override
                        public void onSuccess() {
                            System.out.println("成功===============");
                            getMvpView().onUploadSuccess();
                        }

                        @Override
                        public void onFailed() {
                            System.out.println("失败================");
                            getMvpView().onUploadFailed();
                        }
                    }).uploadDataByGet();
                }
            });
        }
    }
}
