package xin.fallen.util;

import com.google.gson.Gson;
import xin.fallen.po.IpLocMsg;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: Fallen
 * Date: 2017/3/3
 * Time: 17:41
 * Usage:根据request获取ip地址
 */
public class IpUtil {
    public static String ipLocAddr;

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "127.0.0.1".equals(ip)?"117.81.133.14":ip;
    }

    public static IpLocMsg getLocByIp(String ip) {
        String res = HttpUtil.get(ipLocAddr.replace("{IP}", ip));
        return new Gson().fromJson(res, IpLocMsg.class);
    }
}