package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.exhibitionmap;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;
import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.ui.imagebrowse.ImageBrowseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/12/16.
 * 展馆规划图   TODO 待调整
 */

public class ExhibitionMapFragment extends BaseFragment<ExhibitionMapPresenter> implements ExhibitionMapView {

    @BindView(R.id.pavilion_one)
    ImageView mPavilionOne;
    @BindView(R.id.pavilion_two)
    ImageView mPavilionTwo;
    @BindView(R.id.pavilion_three)
    ImageView mPavilionThree;

    private ArrayList<String> images = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_exhibition_map;
    }

    @Override
    protected void initdata() {
        super.initdata();
        mFragmentPresenter.loadData();
    }

    @Override
    public void onLoadSuccess() {
        Glide.with(this.getContext()).load(ServiceConfig.BASE_URL + "upload/1481694594602018339.png").into(mPavilionOne);
        Glide.with(this.getContext()).load(ServiceConfig.BASE_URL + "upload/1482224468534069392.jpg").into(mPavilionTwo);
        Glide.with(this.getContext()).load(ServiceConfig.BASE_URL + "upload/1482224468534069392.jpg").into(mPavilionThree);
        images.add(ServiceConfig.BASE_URL + "upload/1481694594602018339.png");
        images.add(ServiceConfig.BASE_URL + "upload/1482224468534069392.jpg");
        images.add(ServiceConfig.BASE_URL + "upload/1482224468534069392.jpg");
    }

    @OnClick({R.id.pavilion_one, R.id.pavilion_two, R.id.pavilion_three})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pavilion_one:
                ImageBrowseActivity.startActivity(this.getContext(), images, 0);
                break;
            case R.id.pavilion_two:
                ImageBrowseActivity.startActivity(this.getContext(), images, 1);
                break;
            case R.id.pavilion_three:
                ImageBrowseActivity.startActivity(this.getContext(), images, 2);
                break;
        }
    }
}
