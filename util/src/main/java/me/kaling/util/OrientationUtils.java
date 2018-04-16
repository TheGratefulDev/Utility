package me.kaling.util;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;

public class OrientationUtils {

    /**
     * Lock Current Orientation
     * @param activity calling Activity
     */
    public static void lockOrientation(Activity activity){
        int currentOrientation = activity.getResources().getConfiguration().orientation;
        if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        } else {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
        }
    }

    /**
     * Unlock Orientation
     * @param activity calling Activity
     */
    public static void unlockOrientation(Activity activity){
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
    }

    /**
     * Check if orientation is in Portrait
     * @param activity calling Activity
     * @return true if the orientation is portrait
     */
    public static boolean isPortrait(Activity activity){
        return activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
    }

    /**
     * Check if orientation is in LandScape
     * @param activity calling Activity
     * @return true if the orientation is landscape
     */
    public static boolean isLandscape(Activity activity){
        return activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

}
