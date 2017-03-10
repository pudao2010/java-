package com.qhzk.ciep.jpush;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.qhzk.ciep.R;
import com.qhzk.ciep.ui.main.MainActivity;

import org.json.JSONObject;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by pucheng on 2017/1/10.
 * 接入极光推送, 仅仅使用 系统通知 作为推送的方式时使用此广播
 * TODO 待完成
 */

public class CiepReceiver extends BroadcastReceiver {

    private static final String TAG = "CiepReceiver";
    private static final int NOTIFICATION_FLAG = 1;

    private NotificationManager mNotificationManager;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (null == mNotificationManager) {
            mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        }

        Bundle bundle = intent.getExtras();
//        Log.d(TAG, "onReceive - " + intent.getAction() + ", extras: " + AndroidUtil.printBundle(bundle));

        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
            Log.d(TAG, "JPush用户注册成功");

        } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
            Log.d(TAG, "接受到推送下来的自定义消息");
            //TODO 应该在通知栏显示
            showNotification(context);
        } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
            Log.d(TAG, "接受到推送下来的通知");

            receivingNotification(context,bundle);

        } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
            Log.d(TAG, "用户点击打开了通知");
            //TODO 打开相应的界面
            openNotification(context,bundle);

        } else {
            Log.d(TAG, "Unhandled intent - " + intent.getAction());
        }
    }

    private void showNotification(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        Notification notify= new Notification.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)                 // 设置状态栏中的小图片，尺寸一般建议在24×24， 这里也可以设置大图标
                .setTicker("有新短消息了！")                         //设置显示的提示文字
                        .setContentTitle("标题")                    // 设置显示的标题
                        .setContentText("推送的消息内容")            // 消息的详细内容
                        .setContentIntent(pendingIntent)            // 关联PendingIntent
                        .setNumber(1)                               // 在TextView的右方显示的数字，可以在外部定义一个变量，点击累加setNumber(count),这时显示的和
                        .build();                         // 需要注意build()是在API level16及之后增加的，在API11中可以使用getNotificatin()来代替
        notify.flags |= Notification.FLAG_AUTO_CANCEL;
        NotificationManager manager =(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        //设置优先级
        notify.priority = Notification.PRIORITY_DEFAULT;
        //设置通知类别
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            notify.category = Notification.CATEGORY_MESSAGE;
        }
        manager.notify(NOTIFICATION_FLAG, notify);

    }

    private void receivingNotification(Context context, Bundle bundle){
        String title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
        Log.d(TAG, " title : " + title);
        String message = bundle.getString(JPushInterface.EXTRA_ALERT);
        Log.d(TAG, "message : " + message);
        String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
        Log.d(TAG, "extras : " + extras);
    }

    // 用户打开推送的通知
    private void openNotification(Context context, Bundle bundle){
        String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
        String myValue;
        try {
            JSONObject extrasJson = new JSONObject(extras);
            myValue = extrasJson.optString("myKey");
        } catch (Exception e) {
            Log.w(TAG, "Unexpected: extras is not a valid json", e);
            return;
        }
//        if (TYPE_THIS.equals(myValue)) {
//            Intent mIntent = new Intent(context, ThisActivity.class);
//            mIntent.putExtras(bundle);
//            mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            context.startActivity(mIntent);
//        } else if (TYPE_ANOTHER.equals(myValue)){
//            Intent mIntent = new Intent(context, AnotherActivity.class);
//            mIntent.putExtras(bundle);
//            mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            context.startActivity(mIntent);
//        }
    }
}
