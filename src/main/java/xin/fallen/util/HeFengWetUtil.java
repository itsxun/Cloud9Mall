package xin.fallen.util;

import com.google.gson.Gson;
import xin.fallen.po.WeatherNow;
import xin.fallen.po.WeatherPre;

/**
 * Author: Fallen
 * Date: 2017/3/3
 * Time: 16:21
 * Usage:
 */
public class HeFengWetUtil {
    public static String apiAddrNow = null;
    public static String apiAddrPre = null;

    public static WeatherNow getWeatherNow(String cityId) {
        if (apiAddrNow == null)
            return null;
        String key = JedisUtil.getValue("HEFENG_KEY");
        return new Gson().fromJson(HttpUtil.get(apiAddrNow.replace("{CITY}", cityId).replace("{KEY}", key)), WeatherNow.class);
    }

    public static WeatherPre getWeatherPre(String cityId) {
        if (apiAddrPre == null)
            return null;
        String key = JedisUtil.getValue("HEFENG_KEY");
        return new Gson().fromJson(HttpUtil.get(apiAddrPre.replace("{CITY}", cityId).replace("{KEY}", key)), WeatherPre.class);
    }
}