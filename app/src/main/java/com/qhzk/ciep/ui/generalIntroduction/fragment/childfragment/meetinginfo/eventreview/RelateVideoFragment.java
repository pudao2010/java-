package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.eventreview;

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
import com.qhzk.ciep.entity.NewVideoEntity;
import com.qhzk.ciep.ui.video.VideoActivity;
import com.qhzk.ciep.utils.ServiceUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/19.
 * 2016年12月24日17:47:18
 * 往届回顾   相关视频
 */

public class RelateVideoFragment extends BaseFragment<RelateVideoPresenter> implements RelateVideoView{

    private BaseQuickAdapter<NewVideoEntity, BaseViewHolder> mAdapter;
    private List<NewVideoEntity> mVideoEntityList;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.springview)
    SpringView mSpringView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_relate_video;
    }

    @Override
    protected void initview() {
        super.initview();
        mVideoEntityList = new ArrayList<>();
        mSpringView.setHeader(new DefaultHeader(this.getContext()));
        mSpringView.setFooter(new DefaultFooter(this.getContext()));
        mSpringView.setType(SpringView.Type.FOLLOW);
        mSpringView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                mFragmentPresenter.loadData(1,20);
            }
            @Override
            public void onLoadmore() {
                mFragmentPresenter.loadMore();
            }
        });
        mAdapter = new BaseQuickAdapter<NewVideoEntity, BaseViewHolder>(R.layout.video_list_item, mVideoEntityList) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, NewVideoEntity videoEntity) {
                baseViewHolder.setText(R.id.video_title, videoEntity.getTitle()).setText(R.id.video_date, videoEntity.getCreateTime());
                ImageView imageView = baseViewHolder.getView(R.id.video_preview);
                Glide.with(RelateVideoFragment.this).load(ServiceConfig.BASE_URL+videoEntity.getImgUrl()).dontAnimate().centerCrop().error(R.mipmap.ic_launcher).into(imageView);
            }
        };

        mRecyclerview.setLayoutManager(new GridLayoutManager(getActivity(),2));
        mRecyclerview.setAdapter(mAdapter);

        mRecyclerview.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                NewVideoEntity entity = mVideoEntityList.get(i);
                VideoActivity.VideoIntent intent = new VideoActivity.VideoIntent();
                System.out.println(ServiceUtil.subImageUrl(entity.getUrl()));
                intent.setPlayUrl(ServiceUtil.subImageUrl(entity.getUrl().trim()));
                intent.setTitle(entity.getTitle());
                readyGo(VideoActivity.class,VideoActivity.newBundle(intent));
            }
        });

    }

    @Override
    protected void initdata() {
        super.initdata();
        mFragmentPresenter.loadData(1, 20);
    }

    @Override
    public void onLoadSuccess(List<NewVideoEntity> list) {
        mSpringView.onFinishFreshAndLoad();
        mVideoEntityList.clear();
        mVideoEntityList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadMore(List<NewVideoEntity> list) {
        mSpringView.onFinishFreshAndLoad();
        mVideoEntityList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }
}
