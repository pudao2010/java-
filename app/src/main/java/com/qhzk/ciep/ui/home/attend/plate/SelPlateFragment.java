package com.qhzk.ciep.ui.home.attend.plate;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.qhzk.ciep.R;
import com.qhzk.ciep.adapter.MeetingAdapter;
import com.qhzk.ciep.base.BaseFragment;
import com.qhzk.ciep.entity.MeetingEntity;
import com.qhzk.ciep.protocol.BaseProtocol;
import com.qhzk.ciep.protocol.MeetingProtocol;
import com.qhzk.ciep.ui.home.attend.AttendSuccessActivity;
import com.qhzk.ciep.view.AttendMeetingDialog;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * Created by pudao on 2016/12/23.
 * TODO 选择板块
 */

public class SelPlateFragment extends BaseFragment<SelPlatePresenter> implements SelPlateView {
    private List<MeetingEntity> mGroupList = new ArrayList<>();
    private MeetingAdapter mAdapter;
    @BindView(R.id.expand_list)
    ExpandableListView mExpandableListView;
    @BindView(R.id.btn_selected)
    Button mBtnSelected;
    @BindView(R.id.btn_commit)
    Button mBtnCommit;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sel_plate;
    }

    @Override
    protected void initview() {
        super.initview();
        MeetingProtocol meetingProtocol = new MeetingProtocol();
        meetingProtocol.loadDataByGet(new BaseProtocol.Callback<List<MeetingEntity>>() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(List<MeetingEntity> meetingEntities, int id) {
                mGroupList.clear();
                mGroupList.addAll(meetingEntities);
                mAdapter = new MeetingAdapter(SelPlateFragment.this.getContext(), mGroupList);
                mExpandableListView.setAdapter(mAdapter);
//                System.out.println(meetingEntities.get(0).getName());
//                System.out.println(meetingEntities.get(0).getMeetingList().get(0).getTitle());
            }
        });
    }

    @Override
    protected void initdata() {
        super.initdata();
        mExpandableListView.setOnGroupClickListener((expandableListView, view, i, l) -> false);

        mExpandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
//                System.out.println("关闭了======"+groupPosition);
            }
        });

        mExpandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
//                System.out.println("开启了======"+groupPosition);
            }
        });
        mExpandableListView.setOnChildClickListener((expandableListView, view, i, i1, l) -> {
//                System.out.println("child被点击了:");
            CheckBox cb = (CheckBox) view.findViewById(R.id.child_name);
            if (cb.isChecked()){
//                System.out.println("添加到集合中 :"+mGroupList.get(i).getMeetingList().get(i1).getTitle());
            }else{
//                System.out.println("从集合中移除 :"+mGroupList.get(i).getMeetingList().get(i1).getTitle());
            }
            return true;
        });
    }

    @OnClick({R.id.btn_selected, R.id.btn_commit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_selected:
                if (mAdapter.mSelected.size()==0){
                    Toast.makeText(getContext(), "你还未选择参会的板块", Toast.LENGTH_SHORT).show();
                }else{
                    AttendMeetingDialog attendMeetingDialog = new AttendMeetingDialog(getContext(), mAdapter.mSelected);
                    attendMeetingDialog.show();
                }
                break;
            case R.id.btn_commit:
                // 非空判断
                HashSet<String> mConfIds = mAdapter.mConfIds;
                if (mConfIds.size() > 0){
                    Iterator<String> iterator = mConfIds.iterator();
                    StringBuilder confIds = new StringBuilder();
                    while(iterator.hasNext()){
                        confIds.append(iterator.next()).append(",");
                    }
                    if (confIds.length() > 0){
                        confIds.setLength(confIds.length() - 1);
                    }
                    String commitIds = confIds.toString();
                    System.out.println(commitIds);
                    if (!commitIds.equals("")){
                        mFragmentPresenter.commit(commitIds);
                    }
                }else {
                    //TODO 提示用户还未选择
                    showToast("你目前还没有选择");
                }
                break;
        }
    }

    @Override
    public void onCommitSuccess() {
        readyGo(AttendSuccessActivity.class);
        this.getActivity().finish();
    }
}
