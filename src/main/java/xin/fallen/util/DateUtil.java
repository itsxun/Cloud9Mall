package xin.fallen.util;

import java.util.Date;

/**
 * Author: Fallen
 * Date: 2017/3/8
 * Time: 16:26
 * Usage:
 */
public class DateUtil {
    public static boolean isOverTime(Date date, Date flag) {
        return date.compareTo(flag) > 0;
    }

    public static boolean isOverTime(Date date, Date flag, int second) {
        return !(date == null || flag == null) && date.getTime() > (flag.getTime() + second * 1000);
    }
}