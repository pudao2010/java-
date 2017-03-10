package com.qhzk.ciep.ui.resetpasswd;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;
import com.qhzk.ciep.common.okhttp.OkHttpClientManage;
import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.protocol.CiepProtocol;
import com.qhzk.ciep.protocol.VerifyImgcodeProtocol;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 2016年12月25日16:54:44
 * 找回密码 蒲导
 */

public class InputUsernameFragment extends BaseFragment<InputUsernamePresenter> implements InputUsernameView {

    private static final int SHOW_IMG = 1;
    @BindView(R.id.input_email)
    EditText mInputEmail;
    @BindView(R.id.input_verify_code)
    EditText mInputVerifyCode;
    @BindView(R.id.verify_img)
    ImageView mVerifyImg;
    String authkey; // 调图形验证码时需要传的参数
    private OkHttpClient client;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_input_username;
    }

    @Override
    protected void initview() {
        super.initview();
    }
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.arg1 == 1){
                mVerifyImg.setImageBitmap((Bitmap) msg.obj);
            }
        }
    };
    @Override
    protected void initdata() {
        super.initdata();
        String url = ServiceConfig.BASE_URL + "captcha?" + "time=" + System.currentTimeMillis();
//        Glide.with(getContext())
//                .load(url)
//                .into(mVerifyImg);
        try {
            getAuthkey(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getAuthkey(String url) throws IOException {
        new Thread(() -> {
            if (client == null) {
                client = OkHttpClientManage.getOkHttpCacheClient();
            }
            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .build();
            Response response = null;
            try {
                response = client.newCall(request).execute();
                InputStream inputStream = response.body().byteStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                Message msg = new Message();
                msg.obj = bitmap;
                msg.arg1 = SHOW_IMG;
                mHandler.sendMessage(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (response != null) {
                authkey = response.header("authkey");
                System.out.println("开始的authkey=============="+authkey);
            }
        }).start();

    }

    @OnClick({R.id.verify_img, R.id.btn_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.verify_img:
                //更换图形验证码
                String url = ServiceConfig.BASE_URL + "captcha?" + "time=" + System.currentTimeMillis();
                try {
                    getAuthkey(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_next:
                //TODO 验证图形验证码
                String email = mInputEmail.getText().toString().trim();
                String code = mInputVerifyCode.getText().toString().trim();
                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(code)){
//                    mFragmentPresenter.verifyImgcode(email, code);
                    VerifyImgcodeProtocol protocol = new VerifyImgcodeProtocol(new CiepProtocol.Callback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            System.out.println("异常: "+e);
                        }

                        @Override
                        public void onSuccess() {
                            onVerifySuccess();
                        }

                        @Override
                        public void onFailed() {
                            showToast("验证失败, 请稍后再从新尝试");
                        }
                    });
                    protocol.setUserEmail(email);
                    protocol.setCode(code);
                    protocol.setAuthkey(authkey);
                    System.out.println("请求的authkey=============="+authkey);
                    protocol.uploadDataByPost();
                    ResetPasswdActivity activity = (ResetPasswdActivity) getActivity();
                    activity.mEmail = email;
                }else{
                    showToast("请填写验证码");
                }
                break;
        }
    }

    @Override
    public void onVerifySuccess() {
        showToast("验证码已发送至你的邮箱, 请尽快查收");
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, new VerifyIdentityFragment());
        transaction.commit();
    }
}
