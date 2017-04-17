package com.cxria.livetest.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by haiyang-lu on 16-8-22.
 * <p/>
 * 联网工具类
 */
public class NetworkUtils {
    public static final int NETWORK_DISCONNECTED = 0;
    public static final int NETWORK_WIFI = 1;
    public static final int NETWORK_MOBILE = 2;
    public static final int NETWORK_OTHERS = 3;

    /**
     * 检查网络状态
     *
     * @param context 上下文
     * @return 网络状态
     * @see NetworkUtils#NETWORK_WIFI wifi网络
     * @see NetworkUtils#NETWORK_MOBILE 移动网络
     * @see NetworkUtils#NETWORK_DISCONNECTED 无网络连接
     * @see NetworkUtils#NETWORK_OTHERS 其他网络
     */
    public static int checkNetworkState(Context context) {
        if (context == null) {
            throw new RuntimeException("context为空");
        }

        if (!isOnline(context)) {
            return NETWORK_DISCONNECTED;
        }

        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiNetworkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        boolean isWifiConn = wifiNetworkInfo.isConnected();
        if (isWifiConn) {
            return NETWORK_WIFI;
        } else {
            NetworkInfo networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            boolean isMobileConnected = networkInfo.isConnected();
            if (isMobileConnected) {
                return NETWORK_MOBILE;
            } else {
                return NETWORK_OTHERS;
            }
        }

    }

    private static boolean isOnline(Context context) {
        ConnectivityManager connMgr = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

}
