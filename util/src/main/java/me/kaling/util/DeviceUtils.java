package me.kaling.util;

import android.os.Build;

public class DeviceUtils {
    /**
     *
     * @return if the device is Rk312x Custom Tablet
     */
    public static boolean isRk312x(){
        return Build.MODEL.trim().toLowerCase().equals("rk312x");
    }

    /**
     *
     * @return if the device is Als Custom Mobile Device
     */
    public static boolean isAls(){
        return Build.MODEL.trim().toLowerCase().startsWith("kt55");
    }


}
