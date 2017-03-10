package com.qhzk.ciep.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.entity.MeetingEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Administrator on 2016/12/22.
 * 我要参会页面,可展开选项的适配
 * BUG
 */

public class MeetingAdapter extends BaseExpandableListAdapter {

    public List<String> mSelected = new ArrayList<>();
    public HashSet<String> mConfIds = new HashSet<>(); // HashSet保证唯一性,用户存储用户参加的Meeting的id
    private List<MeetingEntity> mGroupList;
    private Context mContext;
    private String groupName;
    private String childName;

    public MeetingAdapter(Context context, List<MeetingEntity> list) {
        mContext = context;
        mGroupList = list;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    // 分组个数
    @Override
    public int getGroupCount() {
        return mGroupList.size();
    }

    // 子分组的个数
    @Override
    public int getChildrenCount(int i) {
        return mGroupList.get(i).getMeetingList().size();
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    // 分组和子选项是否持有稳定的ID, 就是说底层数据的改变会不会影响到它们
    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        GroupViewHolder groupViewHolder;
        if (view == null){
            view = View.inflate(mContext, R.layout.item_meeting_group, null);
            groupViewHolder = new GroupViewHolder(view);
            view.setTag(groupViewHolder);
        }else{
            groupViewHolder = (GroupViewHolder) view.getTag();
        }
        groupViewHolder.groupName.setText(mGroupList.get(i).getName());
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ChildeViewHolder childeViewHolder;
        if (view == null){
            view = View.inflate(mContext, R.layout.item_meeting_child, null);
            childeViewHolder = new ChildeViewHolder(view);
            view.setTag(childeViewHolder);
        }else{
            childeViewHolder = (ChildeViewHolder) view.getTag();
        }
        childeViewHolder.childItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    mGroupList.get(i).getMeetingList().get(i1).isChecked = true;
                    groupName = mGroupList.get(i).getName();
                    childName = mGroupList.get(i).getMeetingList().get(i1).getTitle();
                    // 添加到集合中
                    mSelected.add(groupName + "," + childName);
                    // 添加到HashSet集合中
                    mConfIds.add(mGroupList.get(i).getMeetingList().get(i1).getId());
                }else{
                    mGroupList.get(i).getMeetingList().get(i1).isChecked = false;
                    if (mSelected.contains(groupName + "," + childName)){
                        mSelected.remove(groupName + "," + childName);
                    }
                    //
                    if (mConfIds.contains(mGroupList.get(i).getMeetingList().get(i1).getId())){
                        mConfIds.remove(mGroupList.get(i).getMeetingList().get(i1).getId());
                    }
                }
            }
        });
        childeViewHolder.childItem.setText(mGroupList.get(i).getMeetingList().get(i1).getTitle());
        if (mGroupList.get(i).getMeetingList().get(i1).isChecked){
            childeViewHolder.childItem.setChecked(true);

        }else {
            childeViewHolder.childItem.setChecked(false);

        }
        return view;
    }

    // 子元素是否可以被选中
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int i) {

    }

    @Override
    public void onGroupCollapsed(int i) {

    }

    @Override
    public long getCombinedChildId(long l, long l1) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long l) {
        return 0;
    }

    private static class GroupViewHolder{
        ImageView groupIcon;
        TextView groupName;
        public GroupViewHolder(View groupView){
            groupIcon = (ImageView) groupView.findViewById(R.id.group_icon);
            groupName = (TextView) groupView.findViewById(R.id.group_name);
        }
    }

    private static class ChildeViewHolder{
        CheckBox childItem;
        public ChildeViewHolder(View childView){
            childItem = (CheckBox) childView.findViewById(R.id.child_name);
        }
    }
}
