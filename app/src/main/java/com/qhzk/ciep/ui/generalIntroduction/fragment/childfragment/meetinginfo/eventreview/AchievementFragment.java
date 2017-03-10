package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.eventreview;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
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
import com.qhzk.ciep.entity.AchieveMent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/19.
 * 取得成果
 */

public class AchievementFragment extends BaseFragment<AchievementPresenter> implements AchievementView {

    private BaseQuickAdapter<AchieveMent, BaseViewHolder> mAdapter;
    private List<AchieveMent> mLists = new ArrayList<>();

    @BindView(R.id.springview)
    SpringView mSpringView;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_achievement;
    }

    @Override
    public void onLoadSuccess(List<AchieveMent> list) {
        mSpringView.onFinishFreshAndLoad();
        mLists.clear();
        mLists.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadMore(List<AchieveMent> list) {
        mSpringView.onFinishFreshAndLoad();
        mLists.addAll(list);
        mAdapter.notifyDataSetChanged();
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
                mFragmentPresenter.loadData(1,20);
            }
            @Override
            public void onLoadmore() {
                mFragmentPresenter.loadMore();
            }
        });
        mAdapter = new BaseQuickAdapter<AchieveMent, BaseViewHolder>(R.layout.item_achievement, mLists) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, AchieveMent achieveMent) {
                baseViewHolder.setText(R.id.title, achieveMent.getTitle())
                        .setText(R.id.desc, achieveMent.getIntro())
                        .setText(R.id.date, achieveMent.getCreateTime().split(" ")[0]);
                ImageView image = baseViewHolder.getView(R.id.image);
                Glide.with(AchievementFragment.this)
                        .load(ServiceConfig.BASE_URL+achieveMent.getImageUrl())
                        .placeholder(R.mipmap.ic_launcher)
                        .dontAnimate().centerCrop()
                        .error(R.mipmap.ic_launcher)
                        .into(image);
            }
        };
        mRecyclerview.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                System.out.println("id====================="+mLists.get(i).getId());
                Bundle bundle = new Bundle();
                bundle.putString("id", mLists.get(i).getId());
                readyGo(AchievementDetailActivity.class, bundle);
            }
        });
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerview.setAdapter(mAdapter);
    }

    @Override
    protected void initdata() {
        super.initdata();
        mFragmentPresenter.loadData(1, 20);
    }
}
