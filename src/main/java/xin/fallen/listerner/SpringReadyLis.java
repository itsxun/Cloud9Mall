package xin.fallen.listerner;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import redis.clients.jedis.JedisPool;
import xin.fallen.util.ConfigReader;
import xin.fallen.util.HeFengWetUtil;
import xin.fallen.util.IpUtil;
import xin.fallen.util.JedisUtil;

/**
 * Author: fallen
 * Date: 17-2-14
 * Time: 上午9:45
 * Usage:
 */
public class SpringReadyLis implements ApplicationListener<ContextRefreshedEvent> {

    public void onApplicationEvent(ContextRefreshedEvent e) {
        ConfigReader.configInit();
        HeFengWetUtil.apiAddrNow = ConfigReader.getValue("weather_now_addr");
        HeFengWetUtil.apiAddrPre = ConfigReader.getValue("weather_pre_addr");
        IpUtil.ipLocAddr = ConfigReader.getValue("ip_locate_addr");
        JedisUtil.pool = (JedisPool) e.getApplicationContext().getBean("jedisPool");
    }
}