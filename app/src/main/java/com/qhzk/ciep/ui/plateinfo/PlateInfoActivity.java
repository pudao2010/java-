package com.qhzk.ciep.ui.plateinfo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.entity.PlateDetail;
import com.qhzk.ciep.entity.PlateEntity;
import com.qhzk.ciep.protocol.BaseProtocol;
import com.qhzk.ciep.protocol.PlateDetailProtocol;
import com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.forum.ForumDetailActivity;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;

/**
 * 板块信息 2016年12月19日22:38:28
 */
public class PlateInfoActivity extends BaseActivity<PlateInfoPresenter> implements PlateInfoView {

    @BindView(R.id.plate_title)
    TextView mPlateTitle;
    @BindView(R.id.profile)
    WebView mProfile;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    private int id;

    private List<PlateEntity.SectionBean.AreaListBean> mList = new ArrayList<>();
    private BaseQuickAdapter<PlateEntity.SectionBean.AreaListBean, BaseViewHolder> mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_plate_info;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        id = savedInstanceState.getInt("id");
    }

    @Override
    protected void initview() {
        super.initview();
        mProfile.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mToolbar.setNavigationOnClickListener(v -> finish());
        mAdapter = new BaseQuickAdapter<PlateEntity.SectionBean.AreaListBean, BaseViewHolder>(R.layout.item_plateinfo, mList) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, PlateEntity.SectionBean.AreaListBean areaListBean) {
                baseViewHolder.setText(R.id.plate_name, areaListBean.getName())
                        .setText(R.id.plate_desc, areaListBean.getDescription());
                System.out.println(areaListBean.getId());
            }
        };
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerview.setAdapter(mAdapter);

        mRecyclerview.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                String id = mList.get(i).getId();
                Bundle bundle = new Bundle();
                bundle.putString("id", id);
                readyGo(ForumDetailActivity.class, bundle);
            }
        });
    }

    @Override
    protected void initdata() {
        super.initdata();
//        mActivityPresenter.loadData(id);
        PlateDetailProtocol protocol = new PlateDetailProtocol(id);
        protocol.loadDataByGet(new BaseProtocol.Callback<PlateEntity>() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(PlateEntity plateEntity, int id) {
                mPlateTitle.setText(plateEntity.getSection().getName());
                String description = plateEntity.getSection().getDescription();
//                mProfile.setText(description);
                description = description.replace("<img", "<img style='max-width:90%;height:auto;'");
                mProfile.loadDataWithBaseURL(ServiceConfig.BASEURL, description, "text/html", "utf-8", null);
                List<PlateEntity.SectionBean.AreaListBean> areaList = plateEntity.getSection().getAreaList();
                mList.clear();
                mList.addAll(areaList);
                mAdapter.notifyDataSetChanged();
            }

        });
    }

    @Override
    public void onLoadSuccess(PlateDetail plateDetail) {
        System.out.println("plateDetail==========" + plateDetail);
    }
}
