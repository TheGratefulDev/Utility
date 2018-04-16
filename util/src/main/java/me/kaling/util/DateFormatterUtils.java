package me.kaling.util;

import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatterUtils {

    /**
     * All the Common Date Time Format
     */
    public static class CommonDateFormat {

        public static final String HOURS_MINUTE_AMPM = "h:mm a";
        public static final String MILITARY_HOURS_MINUTE = "HH:mm";
        public static final String DAY_OF_WEEK_FULL = "EEEE";
        public static final String DAY_OF_WEEK_SHORT = "EEE";
        public static final String YEAR_DASH_MONTH_DASH_DAY_NUM = "yyyy-MM-dd";
        public static final String EEEE_MMM_D_YYYY = "EEEE, MMM d, yyyy";
        public static final String EEEE_MMM_D = "EEEE, MMM d";
        public static final String MOUNTH_FULL = "MMM";
        public static final String DAYS = "dd";
        public static final String MONTH_DAY_COMMA_YEAR = "MMM dd, yyyy";
        public static final String YEAR = "yyyy";
        public static final String ISO_8601_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.S";

    }

    /**
     * Format Date Time Utility
     *
     * @param inputTimeStamp Original DateTime String
     * @param inputTimeStampType Original DateTime String format
     * @param formatType Desired DateTimeFormat Type
     * @return formatted DateTime
     */
    public static String formatDateTime(String inputTimeStamp, String inputTimeStampType, String formatType) throws Exception {

        if (TextUtils.isEmpty(inputTimeStamp) || TextUtils.isEmpty(inputTimeStampType) || TextUtils.isEmpty(formatType)) {
            return null;
        }

        Date inputDate = convertStringToDate(inputTimeStamp, inputTimeStampType);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatType, Locale.US);

        return simpleDateFormat.format(inputDate);
    }


    /**
     * Convert String to Date
     * @param inputTimeStamp String
     * @param inputTimeStampType Data Type
     * @return Date
     */
    public static Date convertStringToDate(String inputTimeStamp, String inputTimeStampType) throws Exception {

        if( TextUtils.isEmpty(inputTimeStamp) || TextUtils.isEmpty(inputTimeStampType) ){
            return null;
        }

        SimpleDateFormat iso8601Format = new SimpleDateFormat(inputTimeStampType, Locale.US);
        return iso8601Format.parse(inputTimeStamp);
    }
}
