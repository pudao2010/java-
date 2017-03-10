package com.qhzk.ciep.ui.home;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;
import com.qhzk.ciep.config.Constant;
import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.entity.NewEntity;
import com.qhzk.ciep.ui.generalIntroduction.GeneralIntroductionActivity;
import com.qhzk.ciep.ui.home.attend.AttendActivity;
import com.qhzk.ciep.ui.home.new_center.NewCenterActivity;
import com.qhzk.ciep.ui.login.LoginActivity;
import com.qhzk.ciep.ui.newsdetail.NewsDetailActivity;
import com.qhzk.ciep.ui.notice.ConferenceNoticeActivity;
import com.qhzk.ciep.ui.projectdock.ProjectDockActivity;
import com.qhzk.ciep.ui.qrcode.QRcodeActivity;
import com.qhzk.ciep.ui.search.SearchActivity;
import com.qhzk.ciep.ui.talentdock.TalentDockActivity;
import com.qhzk.ciep.utils.SharedPrefUtil;
import com.qhzk.ciep.view.BannerImageHolder;
import com.qhzk.ciep.view.MarqueeView;
import com.qhzk.ciep.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by pucheng on 2017年1月9日11:43:50
 *
 */

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeView {

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    private ConvenientBanner mBanner;
    private MarqueeView mMarquee;
    private RecyclerView mHeadRecyclerView;

    private BaseQuickAdapter<NewItem, BaseViewHolder> mAdapter;
    private BaseQuickAdapter<RecHeadItem, BaseViewHolder> mRecAdapter;
    private List<NewItem> mNewItemLists;

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initview() {
        super.initview();
        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            //TODO 谷歌的下拉刷新
            mFragmentPresenter.getBannersData();
            mFragmentPresenter.getMarqueesData();
            mFragmentPresenter.getNewItemData();
        });

        mSwipeRefreshLayout.setColorSchemeResources(
                R.color.swiperefresh_color1, R.color.swiperefresh_color2,
                R.color.swiperefresh_color3, R.color.swiperefresh_color4);
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        int stateBarHeight = getResources().getDimensionPixelSize(resourceId);
        AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) mToolbar.getLayoutParams();
        layoutParams.setMargins(0, stateBarHeight, 0, 0);
        mToolbar.setLayoutParams(layoutParams);
        // 包含了轮播图到新闻中心,是RecyclerView的head
        View recHeadView = mLayoutInflater.inflate(R.layout.home_rec_head_view, null);
        //
        recHeadView.findViewById(R.id.text_new).setOnClickListener(v -> readyGo(NewCenterActivity.class));
        //
        recHeadView.findViewById(R.id.more_news).setOnClickListener(view -> readyGo(NewCenterActivity.class));
        // 大会通知点击事件
        recHeadView.findViewById(R.id.event_review).setOnClickListener(view -> readyGo(ConferenceNoticeActivity.class));
        mNewItemLists = new ArrayList<>();
        //TODO 新闻中心item视图
        mAdapter = new BaseQuickAdapter<NewItem, BaseViewHolder>(R.layout.home_rec_item_layout, mNewItemLists) {

            @Override
            protected void convert(BaseViewHolder baseViewHolder, NewItem newItem) {
                baseViewHolder.setText(R.id.title, newItem.getTitle())
                        .setText(R.id.date, newItem.getDate());
                ImageView image = baseViewHolder.getView(R.id.image);
                //
                System.out.println("缩率图=========="+newItem.getIcon());
                Glide.with(HomeFragment.this)
                        .load(newItem.getIcon())
                        .dontAnimate()
                        .centerCrop()
                        .error(R.mipmap.ic_launcher)
                        .into(image);
            }
        };

        mAdapter.addHeaderView(recHeadView);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerview.addItemDecoration(new DividerItemDecoration(HomeFragment.this.getContext(), DividerItemDecoration.VERTICAL_LIST));
        mRecyclerview.setAdapter(mAdapter);
        // 新闻中心条目的点击事件
        mRecyclerview.addOnItemTouchListener(new com.chad.library.adapter.base.listener.OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Bundle bundle = new Bundle();
                bundle.putString("id", list.get(i).getId());
                bundle.putString("title", list.get(i).getTitle());
                bundle.putString("imgUrl", ServiceConfig.BASE_URL + list.get(i).getPcimg());
                System.out.println(ServiceConfig.BASE_URL + list.get(i).getPcimg());
                readyGo(NewsDetailActivity.class, bundle);
            }
        });

        //广告轮播图
        mBanner = (ConvenientBanner) recHeadView.findViewById(R.id.banner);
        mBanner.setPageIndicator(new int[]{R.drawable.icon_spod, R.drawable.icon_spod_solid});
        mBanner.setOnItemClickListener(position -> {
            switch (position) {
                case 0:

                    break;
                case 1:

                    break;
            }
        });

        mMarquee = (MarqueeView) recHeadView.findViewById(R.id.marquee);
        mMarquee.setOnItemClickListener((position, textView) -> {
            readyGo(ConferenceNoticeActivity.class);
        });

        mHeadRecyclerView = (RecyclerView) recHeadView.findViewById(R.id.recyclerview);
        List<RecHeadItem> recHeadItems = new ArrayList<>();
        recHeadItems.add(new RecHeadItem(R.drawable.icon_home_001, "我要参会"));
        recHeadItems.add(new RecHeadItem(R.drawable.icon_home_002, "参展指南"));
        recHeadItems.add(new RecHeadItem(R.drawable.icon_home_003, "大会介绍"));
        recHeadItems.add(new RecHeadItem(R.drawable.icon_home_004, "大会论坛"));
        recHeadItems.add(new RecHeadItem(R.drawable.icon_home_005, "人才对接"));
        recHeadItems.add(new RecHeadItem(R.drawable.icon_home_006, "项目对接"));
        recHeadItems.add(new RecHeadItem(R.drawable.icon_home_007, "大会服务"));
        recHeadItems.add(new RecHeadItem(R.drawable.icon_home_008, "往期回顾"));
        mRecAdapter = new BaseQuickAdapter<RecHeadItem, BaseViewHolder>(R.layout.home_head_rec_item, recHeadItems) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, RecHeadItem recHeadItem) {
                Button button = baseViewHolder.getView(R.id.button);
                button.setText(recHeadItem.text);
                Drawable drawable = AppCompatDrawableManager.get().getDrawable(getActivity(), recHeadItem.icon);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                button.setCompoundDrawables(null, drawable, null, null);
            }
        };
        mHeadRecyclerView.addOnItemTouchListener(new com.chad.library.adapter.base.listener.OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Bundle bundle = new Bundle();
                switch (i) {
                    case 0:
                        if (isLogin()){
                            mFragmentPresenter.checkIsAttend();
                        }else{
                            readyGo(LoginActivity.class);
                        }
                        break;
                    case 1:
                        bundle.putInt("position", 2);
                        readyGo(GeneralIntroductionActivity.class, bundle);
                        break;
                    case 2:
                        bundle.putInt("position", 0);
                        readyGo(GeneralIntroductionActivity.class, bundle);
                        break;
                    case 3:
                        bundle.putInt("position", 1);
                        readyGo(GeneralIntroductionActivity.class, bundle);
                        break;
                    case 4:
                        readyGo(TalentDockActivity.class);
                        break;
                    case 5:
                        startActivity(new Intent(HomeFragment.this.getContext(), ProjectDockActivity.class));
                        break;
                    case 6:
                        bundle.putInt("position", 4);
                        readyGo(GeneralIntroductionActivity.class, bundle);
                        break;
                    case 7://暂时未做数据统计
//                        readyGo(DatastatisticsActivity.class);
                        bundle.putInt("position", 6);
                        readyGo(GeneralIntroductionActivity.class, bundle);
                        break;
                }
            }
        });
        mHeadRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        mHeadRecyclerView.setAdapter(mRecAdapter);

    }

    private boolean isLogin() {
        String loginUser = SharedPrefUtil.getPrefString(this.getContext(), Constant.LOGIN_USER, "");
        return !TextUtils.isEmpty(loginUser);
    }

    @Override
    protected void initdata() {
        super.initdata();
        mSwipeRefreshLayout.setRefreshing(true);
        mFragmentPresenter.getBannersData();
        mFragmentPresenter.getMarqueesData();
        mFragmentPresenter.getNewItemData();
    }

    @Override
    public void onResume() {
        super.onResume();
        mBanner.startTurning(3500);
    }

    @Override
    public void onPause() {
        super.onPause();
        mBanner.stopTurning();
    }

    @OnClick({R.id.add, R.id.search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                readyGo(QRcodeActivity.class);
                break;
            case R.id.search:
                readyGo(SearchActivity.class);
                break;
        }
    }

    @Override
    public void onBannerResult(List<String> list) {
        mSwipeRefreshLayout.setRefreshing(false);
        mBanner.setPages(BannerImageHolder::new, list);
    }

    @Override
    public void onMarqueesResult(List<String> list) {
        mMarquee.startWithList(list);
    }

    @Override
    public void onNewItemResult(List<NewItem> list) {
        mNewItemLists.clear();
        mNewItemLists.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    List<NewEntity> list;

    @Override
    public void onNewItemResults(List<NewEntity> list) {
        this.list = list;
    }

    @Override
    public void onCheckIsAttend(boolean isAttend) {
        if (isAttend){
            showToast("您已报名参会,请到展票页查看个人的参会二维码");
        } else {
            readyGo(AttendActivity.class);
        }
    }

    static class RecHeadItem {
        int icon;
        String text;

        RecHeadItem(int icon, String text) {
            this.icon = icon;
            this.text = text;
        }
    }

    // 首页新闻中心的bean
    public static class NewItem {
        private String icon;
        private String title;
        private String date;

        public NewItem(String icon, String title, String date) {
            this.icon = icon;
            this.title = title;
            this.date = date;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }

}
