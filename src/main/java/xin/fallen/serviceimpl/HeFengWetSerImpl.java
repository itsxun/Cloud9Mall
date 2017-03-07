package xin.fallen.serviceimpl;

import org.springframework.stereotype.Service;
import xin.fallen.dao.HefengCityCodeMapper;
import xin.fallen.po.WeatherNow;
import xin.fallen.po.WeatherNowEx;
import xin.fallen.po.WeatherPre;
import xin.fallen.po.WeatherPreEx;
import xin.fallen.service.HeFengWetSer;
import xin.fallen.util.HeFengWetUtil;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Author: Fallen
 * Date: 2017/3/3
 * Time: 15:20
 * Usage:
 */
@Service
public class HeFengWetSerImpl implements HeFengWetSer {

    @Resource
    private HefengCityCodeMapper hefengCityCodeMapper;

    public WeatherNow getWeatherNow(String cityName) {
        String cityId = "CN" + hefengCityCodeMapper.selectPrimaryKeyByCityName(cityName);
        return HeFengWetUtil.getWeatherNow(cityId);
    }

    public WeatherPre getWeatherPre(String cityName) {
        String cityId = "CN" + hefengCityCodeMapper.selectPrimaryKeyByCityName(cityName);
        return HeFengWetUtil.getWeatherPre(cityId);
    }

    public WeatherNowEx convertNowEx(WeatherNow wn) {
        WeatherNowEx wne = new WeatherNowEx();
        wne.setTemp(wn.getHeWeather5().get(0).getNow().getTmp()+"℃");
        wne.setWeaSta(wn.getHeWeather5().get(0).getNow().getCond().getTxt());
        wne.setVis(wn.getHeWeather5().get(0).getNow().getVis()+"公里");
        wne.setWdir(wn.getHeWeather5().get(0).getNow().getWind().getDir());
        wne.setSc(wn.getHeWeather5().get(0).getNow().getWind().getSc()+"级");
        return wne;
    }

    public ArrayList<WeatherPreEx> convertPreEx(WeatherPre wp) {
        ArrayList<WeatherPreEx> list = new ArrayList<WeatherPreEx>(wp.getHeWeather5().get(0).getDaily_forecast().size());
        for (WeatherPre.HeWeather5Bean.DailyForecastBean dfb : wp.getHeWeather5().get(0).getDaily_forecast()) {
            WeatherPreEx wpe = new WeatherPreEx();
            wpe.setDate(dfb.getDate());
            wpe.setWeaStaD(dfb.getCond().getTxt_d());
            wpe.setWeaStaN(dfb.getCond().getTxt_n());
            wpe.setRainP(dfb.getPop() + "%");
            wpe.setTempMax(dfb.getTmp().getMax()+"℃");
            wpe.setTempMin(dfb.getTmp().getMin()+"℃");
            wpe.setVis(dfb.getVis()+"公里");
            wpe.setWdir(dfb.getWind().getDir());
            wpe.setSc(dfb.getWind().getSc()+"级");
            list.add(wpe);
        }
        return list;
    }
}