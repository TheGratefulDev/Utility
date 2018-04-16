package me.kaling.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.IOException;

public class ConnectionUtils {
    /**
     * Check if the device isOnline
     * @param context application context
     * @return true if the device can ping 8.8.8.8
     */
    public static boolean isOnline(Context context){

        if(ConnectionUtils.isConnectedMobile(context) || ConnectionUtils.isConnectedWifi(context)){
            Runtime runtime = Runtime.getRuntime();
            try{
                Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
                int exitValue = ipProcess.waitFor();
                Log.i("Exit Value : ", String.valueOf(exitValue));

                return (exitValue == 0);

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

        }

        return false;
    }

    /**
     * Check if the device is connect to wifi
     * @param context application context
     * @return true if the device is connect to wifi
     */
    public static boolean isConnectedWifi(Context context){
        NetworkInfo info = getNetworkInfo(context);
        return (info != null && info.isConnected() && info.getType() == ConnectivityManager.TYPE_WIFI);
    }

    /**
     * Check if the device is connect to data plan
     * @param context application context
     * @return true if the device is connect to data plan
     */
    public static boolean isConnectedMobile(Context context){
        NetworkInfo info = getNetworkInfo(context);
        return (info != null && info.isConnected() && info.getType() == ConnectivityManager.TYPE_MOBILE);
    }


    /**
     * required android.permission.ACCESS_NETWORK_STATE
     * get Network info From the context
     * @param context application context
     * @return NetworkInfo
     */
    @SuppressLint("MissingPermission")
    public static NetworkInfo getNetworkInfo(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager ==null){
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }


}
