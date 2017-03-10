package com.qhzk.ciep.ui.mine.message;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.entity.Message;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 我的消息页面 2016年12月20日10:08:12
 */
public class MessageActivity extends BaseActivity<MessagePresenter> implements MessageView {

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    private BaseQuickAdapter<Message.RowsBean, BaseViewHolder> mAdapter;
    private List<Message.RowsBean> mList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());

        mAdapter = new BaseQuickAdapter<Message.RowsBean, BaseViewHolder>(R.layout.item_message, mList) {

            @Override
            protected void convert(BaseViewHolder baseViewHolder, Message.RowsBean rowsBean) {
                baseViewHolder.setText(R.id.message_title, rowsBean.messageTextBean.title)
                        .setText(R.id.message_content, rowsBean.messageTextBean.content)
                        .setText(R.id.message_time, rowsBean.messageTextBean.createtime);
            }
        };
        mAdapter.setEmptyView(View.inflate(this, R.layout.empty_view, null));
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview.setAdapter(mAdapter);
    }

    @Override
    protected void initdata() {
        super.initdata();
        mActivityPresenter.loadData();
    }

    @Override
    public void onLoadSuccess(Message message) {
        mList.clear();
        mList.addAll(message.rowsBeens);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(Exception e) {
        showToast("网络错误");
    }
}
