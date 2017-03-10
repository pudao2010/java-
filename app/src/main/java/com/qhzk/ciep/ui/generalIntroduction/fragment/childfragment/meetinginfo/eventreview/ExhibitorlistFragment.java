package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.eventreview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;
import com.qhzk.ciep.entity.Exhibitor;
import com.qhzk.ciep.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/19.
 * 展商名录
 */

public class ExhibitorlistFragment extends BaseFragment<ExhibitorlistPresenter> implements ExhibitorlistView {

    @BindView(R.id.springview)
    SpringView mSpringView;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    private BaseQuickAdapter<Exhibitor, BaseViewHolder> mAdapter;
    private List<Exhibitor> mLists = new ArrayList<>();


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_exhibitor_list;
    }


    @Override
    public void onLoadSuccess(List<Exhibitor> exhibitors) {
        mSpringView.onFinishFreshAndLoad();
        mLists.clear();
        mLists.addAll(exhibitors);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadMore(List<Exhibitor> exhibitors) {
        mSpringView.onFinishFreshAndLoad();
        mLists.addAll(exhibitors);
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
                mFragmentPresenter.loadData(1, 20);
            }
            @Override
            public void onLoadmore() {
                mFragmentPresenter.loadMore();
            }
        });

        mAdapter = new BaseQuickAdapter<Exhibitor, BaseViewHolder>(R.layout.item_exhibitor_list, mLists) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, Exhibitor exhibitor) {
                baseViewHolder.setText(R.id.exhibitor_name, exhibitor.getName())
                        .setText(R.id.exhibitor_contact, "联系人 :"+exhibitor.getContacts())
                        .setText(R.id.exhibitor_moblie,  "电  话 :"+exhibitor.getPhone());
            }
        };

        mRecyclerview.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                System.out.println(mLists.get(i).getId());
            }
        });
        mRecyclerview.addItemDecoration(new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL_LIST));
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerview.setAdapter(mAdapter);
    }

    @Override
    protected void initdata() {
        super.initdata();
        mFragmentPresenter.loadData(1, 20);
    }
}
