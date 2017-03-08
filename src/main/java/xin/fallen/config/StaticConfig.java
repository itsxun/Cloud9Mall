package xin.fallen.config;

/**
 * Author: fallen
 * Date: 17-2-15
 * Time: 下午4:34
 * Usage:
 */
public class StaticConfig {
    //    实况天气请求地址
    public static String apiAddrNow;
    //    预报天气请求地址
    public static String apiAddrPre;
    //    ip定位请求地址
    public static String ipLocAddr;
    //    用户未操作掉线时间
    public static int userAliveTime;
    //    管理员未操作掉线时间
    public static int adminAliveTime;
    //    官方邮箱地址
    public static String offcialMailboxAddr;
    //    注册邮件的主题
    public static String registEmailSubject;
    //    官方邮箱发送方
    public static String officialEmailSender;
    //    邮箱正则表达式
    public static String emailRegex;
    //    用户注册发送邮件的正文
    public static String registEmailContent;
    //    redis中待验证邮箱的集合map名称
    public static String registEmailVerifyMapName;
    //    redis中在线用户的集合map名称
    public static String onlineUserMapName;
    //    redis中在线的管理员的集合map名称
    public static String onlineAdminMapName;
    //注册邮件过期时间，单位：秒
    public static int registEmailTimeOut;
}
