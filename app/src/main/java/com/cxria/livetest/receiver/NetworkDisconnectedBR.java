package com.cxria.livetest.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.cxria.livetest.utils.NetworkUtils;


/**
 * Created by haiyang-lu on 16-9-12.
 * 当网络状态改变时发送的广播的接收器
 * action: android:name="android.net.conn.CONNECTIVITY_CHANGE"
 */
public class NetworkDisconnectedBR extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int state = NetworkUtils.checkNetworkState(context);
        if (state == NetworkUtils.NETWORK_MOBILE) {
            Toast.makeText(context, "使用手机网络", Toast.LENGTH_SHORT).show();
        } else if (state == NetworkUtils.NETWORK_DISCONNECTED) {
            Toast.makeText(context, "断开网络链接", Toast.LENGTH_SHORT).show();
        }
    }
}
