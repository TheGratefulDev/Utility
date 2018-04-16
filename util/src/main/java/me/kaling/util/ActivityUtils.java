package me.kaling.util;

import android.app.Activity;
import android.view.View;
import android.view.WindowManager;

public class ActivityUtils {
    /**
     *
     * make the calling Activity to be  fullscreen
     * @param activity the calling activity
     */
    public static void fullScreenMode(Activity activity){
        activity.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);

    }

    /**
     * make the calling Activity Stay On, it does not going to sleep
     * @param activity the calling activity
     */
    public static void stayWoke(Activity activity){
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    /**
     * Does not allow default custom_keypad show up
     * @param activity the calling activity
     */
    static void suppressDefaultKeyboard(Activity activity){
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
    }
}
