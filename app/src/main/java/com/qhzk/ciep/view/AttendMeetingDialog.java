package com.qhzk.ciep.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.qhzk.ciep.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/18.
 *  我参加的板块及会议  对话框 //待调整
 */

public class AttendMeetingDialog extends Dialog {
    private List<String> mSelected;
    private List<Meeting> mMeetingList = new ArrayList<>();
    private int heightPixels;

    public AttendMeetingDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public AttendMeetingDialog(Context context, List<String> list) {
        this(context, R.style.Theme_Light_Dialog);
        heightPixels = context.getResources().getDisplayMetrics().heightPixels;
        mSelected = list;
        View dialogView = LayoutInflater.from(context).inflate(R.layout.view_attend_meeting, null);
        dialogView.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        ListView listView = (ListView) dialogView.findViewById(R.id.listview);
        for (int i = 0; i < list.size(); i++) {
            String plateAndTitle = list.get(i);
            String[] strings = plateAndTitle.split(",");
            Meeting meeting = new Meeting();
            meeting.plate = strings[0];
            meeting.title = strings[1];
            mMeetingList.add(meeting);
        }
        listView.setAdapter(new MyAdapter());
        initWindow();
        setContentView(dialogView);
    }

    private void initWindow() {
        //设置dialog在屏幕底部
        Window window = getWindow();
        window.setGravity(Gravity.BOTTOM);
        //设置dialog弹出时的动画效果，从屏幕底部向上弹出
        window.setWindowAnimations(R.style.dialogStyle);
        window.getDecorView().setPadding(0, 0, 0, 0);
        //获得window窗口的属性
        WindowManager.LayoutParams lp = window.getAttributes();
        //设置窗口宽度为充满全屏
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        //设置窗口高度为包裹内容
        lp.height = (int) (heightPixels*0.4);
        //将设置好的属性set回去
        window.setAttributes(lp);
    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            if (mMeetingList != null){
                return mMeetingList.size();
            }
            return 0;
        }

        @Override
        public Meeting getItem(int i) {
            if (mMeetingList != null) {
                mMeetingList.get(i);
            }
            return null;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder;
            if (view == null){
                view = View.inflate(getContext(), R.layout.item_attend_meeting, null);
                holder = new ViewHolder(view);
                view.setTag(holder);
            }else {
                holder = (ViewHolder) view.getTag();
            }
            Meeting meeting = mMeetingList.get(i);
            holder.plate.setText(meeting.plate);
            holder.title.setText(meeting.title);
            holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mMeetingList.remove(i);
                    for (int j = 0; j < mSelected.size(); j++) {
                        String s = mSelected.get(j);
                        if (s.endsWith(meeting.title)){
                            mSelected.remove(j);
                            j--;
                        }
                    }
                    notifyDataSetChanged();
                }
            });
            return view;
        }
    }

    private class Meeting{
        public String plate;
        public String title;
    }

    private static class ViewHolder{
        TextView plate;
        TextView title;
        ImageView delete;
        public ViewHolder(View itemView){
            delete = (ImageView) itemView.findViewById(R.id.delete);
            plate = (TextView) itemView.findViewById(R.id.plate);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
