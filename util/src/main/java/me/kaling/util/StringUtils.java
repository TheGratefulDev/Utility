package me.kaling.util;

import android.text.Html;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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


    /**
     * Check if Json is Valid
     * @param string json String
     * @return true if is json array or json object
     */
    public static boolean isJSONValid(String string) {
        try {
            new JSONObject(string);
        } catch (JSONException ex) {
            // edited, to include @Arthur's comment
            // e.g. in case JSONArray is valid as well...
            try {
                new JSONArray(string);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }



    public static String removeNullAndEmpty(String string){

        if( string == null){
            return "";
        }

        if( TextUtils.isEmpty(string.trim()) ){
            return "";
        }

        if( string.trim().equalsIgnoreCase("null") ){
            return "";
        }

        return string;

    }

}
