package xin.fallen.util;

import com.google.gson.Gson;
import xin.fallen.config.StaticConfig;
import xin.fallen.po.WeatherNow;
import xin.fallen.po.WeatherPre;

/**
 * Author: Fallen
 * Date: 2017/3/3
 * Time: 16:21
 * Usage:
 */
public class HeFengWetUtil {


    public static WeatherNow getWeatherNow(String cityId) {
        if (StaticConfig.apiAddrNow == null)
            return null;
        String key = JedisUtil.getValue("HEFENG_KEY");
        return new Gson().fromJson(HttpUtil.get(StaticConfig.apiAddrNow.replace("{CITY}", cityId).replace("{KEY}", key)), WeatherNow.class);
    }

    public static WeatherPre getWeatherPre(String cityId) {
        if (StaticConfig.apiAddrPre == null)
            return null;
        String key = JedisUtil.getValue("HEFENG_KEY");
        return new Gson().fromJson(HttpUtil.get(StaticConfig.apiAddrPre.replace("{CITY}", cityId).replace("{KEY}", key)), WeatherPre.class);
    }
}