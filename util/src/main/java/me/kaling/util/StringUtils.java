package me.kaling.util;

import android.text.Html;

public class StringUtils {

    /**
     * Check if the String is a json array or start with [
     * @param string Json String
     * @return is true if it is json array
     */
    public static boolean isJsonArray(String string){
        return string.startsWith("[");
    }


    /**
     * Stripped all the dash of the keys
     * @param key UUID KEY ID
     * @return  Key without dash
     */
    public static String strippedKey(String key) {
        return key.replace("-", "");
    }


    /**
     * Stripped Html from the string
     * @param html String that contain html
     * @return stripped html String
     */
    public static String strippedHtml(String html) {
        return Html.fromHtml(html).toString();
    }

}
