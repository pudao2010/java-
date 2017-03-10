package com.qhzk.ciep.ui.home.new_center.conference_video;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;
import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.entity.ConfVideoEntity;
import com.qhzk.ciep.ui.video.VideoActivity;
import com.qhzk.ciep.utils.ServiceUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by pucheng on 2017年1月12日11:38:43.
 * 大会视频
 */

public class ConferenceVideoFragment extends BaseFragment<ConferenceVideoPresenter> implements ConferenceVideoView {

    @BindView(R.id.springview)
    SpringView mSpringView;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    private BaseQuickAdapter<ConfVideoEntity, BaseViewHolder> mAdapter;
    private List<ConfVideoEntity> mVideoEntityList;

    public static ConferenceVideoFragment newInstance() {
        Bundle args = new Bundle();
        ConferenceVideoFragment fragment = new ConferenceVideoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_conference_video;
    }

    @Override
    protected void initview() {
        super.initview();
        mSpringView.setHeader(new DefaultHeader(this.getContext()));
        mSpringView.setFooter(new DefaultFooter(this.getContext()));
        mSpringView.setType(SpringView.Type.FOLLOW);
        mSpringView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                if (mFragmentPresenter != null) {
                    mFragmentPresenter.loadData();
                    mFragmentPresenter.page = 1;
                }

            }
            @Override
            public void onLoadmore() {
                if (mFragmentPresenter != null) {
                    mFragmentPresenter.loadMore();
                }

            }
        });
        mVideoEntityList = new ArrayList<>();

        mAdapter = new BaseQuickAdapter<ConfVideoEntity, BaseViewHolder>(R.layout.video_list_item, mVideoEntityList) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, ConfVideoEntity videoEntity) {
                baseViewHolder.setText(R.id.video_title, videoEntity.getTitle()).setText(R.id.video_date, videoEntity.getCreate_date());
                ImageView imageView = baseViewHolder.getView(R.id.video_preview);
                Glide.with(ConferenceVideoFragment.this)
                        .load(ServiceConfig.BASE_URL+videoEntity.getPreviewpath())
                        .dontAnimate().centerCrop()
                        .error(R.mipmap.ic_launcher)
                        .into(imageView);
            }
        };

        mRecyclerview.setLayoutManager(new GridLayoutManager(getActivity(),2));
        mRecyclerview.setAdapter(mAdapter);

        mRecyclerview.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ConfVideoEntity entity = mVideoEntityList.get(i);
                VideoActivity.VideoIntent intent = new VideoActivity.VideoIntent();
                System.out.println(ServiceUtil.subImageUrl(entity.getVideopath()));
                intent.setPlayUrl(ServiceUtil.subImageUrl(entity.getVideopath().trim()));
                intent.setTitle(entity.getTitle());
                readyGo(VideoActivity.class,VideoActivity.newBundle(intent));
            }
        });

    }

    @Override
    protected void initdata() {
        super.initdata();
        mFragmentPresenter.loadData();
    }

    @Override
    public void onLoadSuccess(List<ConfVideoEntity> list) {
        mSpringView.onFinishFreshAndLoad();
        mVideoEntityList.clear();
        mVideoEntityList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadMore(List<ConfVideoEntity> list) {
        mSpringView.onFinishFreshAndLoad();
        mVideoEntityList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadNoMore(List<ConfVideoEntity> list) {
        showToast("没有更多数据了");
        mSpringView.onFinishFreshAndLoad();
        mVideoEntityList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(Exception e) {
        showToast("网络异常 :"+e);
    }
}
