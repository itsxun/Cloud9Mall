package xin.fallen.service;


import xin.fallen.po.WeatherNow;
import xin.fallen.po.WeatherNowEx;
import xin.fallen.po.WeatherPre;
import xin.fallen.po.WeatherPreEx;

import java.util.ArrayList;

/**
 * Author: Fallen
 * Date: 2017/3/3
 * Time: 15:17
 * Usage:
 */
public interface HeFengWetSer {

    WeatherNow getWeatherNow(String cityName);

    WeatherNowEx convertNowEx(WeatherNow wn);

    WeatherPre getWeatherPre(String cityName);

    ArrayList<WeatherPreEx> convertPreEx(WeatherPre wp);

}