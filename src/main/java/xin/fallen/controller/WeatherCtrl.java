package xin.fallen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xin.fallen.po.*;
import xin.fallen.service.HeFengWetSer;
import xin.fallen.util.IpUtil;
import xin.fallen.util.JsonResultUtil;
import xin.fallen.vo.JsonResult;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Author: Fallen
 * Date: 2017/3/3
 * Time: 14:43
 * Usage:
 */
@Controller
@RequestMapping("/weather")
public class WeatherCtrl {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Resource
    private HeFengWetSer heFengWetSerImpl;

    @RequestMapping("/now")
    @ResponseBody
    public JsonResult getWeatherNow(HttpServletRequest req) {
        String ip = IpUtil.getIpAddr(req);
        IpLocMsg locMsg = IpUtil.getLocByIp(ip);
        WeatherNow wn = heFengWetSerImpl.getWeatherNow(locMsg.getData().getCity().replace("市", ""));
        WeatherNowEx wne = heFengWetSerImpl.convertNowEx(wn);
        return JsonResultUtil.resDispatcher(wne);
    }

    @RequestMapping("/pre")
    @ResponseBody
    public JsonResult getWeatherForecast(HttpServletRequest req) {
        String ip = IpUtil.getIpAddr(req);
        IpLocMsg locMsg = IpUtil.getLocByIp(ip);
        WeatherPre wp = heFengWetSerImpl.getWeatherPre(locMsg.getData().getCity().replace("市", ""));
        ArrayList<WeatherPreEx> list = heFengWetSerImpl.convertPreEx(wp);
        return JsonResultUtil.resDispatcher(list);
    }
}