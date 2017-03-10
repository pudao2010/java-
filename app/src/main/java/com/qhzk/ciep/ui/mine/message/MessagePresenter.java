package com.qhzk.ciep.ui.mine.message;

import com.qhzk.ciep.entity.Message;
import com.qhzk.ciep.mvp.BasePresenter;
import com.qhzk.ciep.protocol.BaseProtocol;
import com.qhzk.ciep.protocol.MessageProtocol;

import okhttp3.Call;

/**
 * Created by pucheng on 2017/2/8.
 *
 */

public class MessagePresenter extends BasePresenter<MessageView> {

    public void loadData(){
        MessageProtocol protocol = new MessageProtocol();
        protocol.loadDataByGet(new BaseProtocol.Callback<Message>() {
            @Override
            public void onError(Call call, Exception e, int id) {
                getMvpView().onError(e);
            }

            @Override
            public void onResponse(Message message, int id) {
                System.out.println(message.code + message.total + message.message);
                if (message.rowsBeens != null) {
                    getMvpView().onLoadSuccess(message);
                }
            }
        });
    }
}
