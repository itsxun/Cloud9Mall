package xin.fallen.listerner;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import redis.clients.jedis.JedisPool;
import xin.fallen.config.StaticConfig;
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
        StaticConfig.apiAddrNow = ConfigReader.getValue("weather_now_addr");
        StaticConfig.apiAddrPre = ConfigReader.getValue("weather_pre_addr");
        StaticConfig.ipLocAddr = ConfigReader.getValue("ip_locate_addr");
        StaticConfig.userAliveTime = Integer.parseInt(ConfigReader.getValue("user_alive_time"));
        StaticConfig.adminAliveTime = Integer.parseInt(ConfigReader.getValue("admin_alive_time"));
        StaticConfig.offcialMailboxAddr = ConfigReader.getValue("offcial_mailbox_addr");
        StaticConfig.registEmailSubject = ConfigReader.getValue("regist_email_subject");
        StaticConfig.officialEmailSender = ConfigReader.getValue("official_email_sender");
        StaticConfig.emailRegex = ConfigReader.getValue("email_regex");
        StaticConfig.registEmailContent = ConfigReader.getValue("regist_email_content");
        StaticConfig.registEmailVerifyMapName = ConfigReader.getValue("regist_email_verify_map_name");
        StaticConfig.onlineUserMapName = ConfigReader.getValue("online_user_map_name");
        StaticConfig.onlineAdminMapName = ConfigReader.getValue("online_admin_map_name");
        StaticConfig.registEmailTimeOut = Integer.parseInt(ConfigReader.getValue("regist_email_time_out"));
        JedisUtil.pool = (JedisPool) e.getApplicationContext().getBean("jedisPool");
    }
}