package xin.fallen.util;

import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xin.fallen.config.StaticConfig;

/**
 * Author: Fallen
 * Date: 2017/3/7
 * Time: 22:21
 * Usage:发送邮件的工具类
 */
public class EmailUtil {
    private static Logger log = LoggerFactory.getLogger("logger");

    public static boolean isVaildEmail(String emailAddr) {
        return emailAddr.matches(StaticConfig.emailRegex);
    }

    public static boolean sendHtmlEmail(String sender, String reciver, String subject, String content) {
        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.163.com"); // 邮件服务器域名
        //从redis查询授权码
        String password = JedisUtil.getValue("OFFCIAL_MAILBOX_PASSWORD");
        email.setAuthentication(sender, password);//账号与授权码
        email.setCharset("UTF-8");
        try {
            email.setFrom(sender);//设置发件人，必须与账号一致才能发送成功
            email.addTo(reciver);//设置收件人
            email.setSubject(subject);//设置主题
            email.setHtmlMsg(content);//设置邮件内容
            email.setTextMsg("该邮箱暂时不支持html邮件，请换成其他邮箱尝试接收邮件。");//如果不能正确显示的提示
            email.send();
        } catch (Exception e) {
            log.error("邮件发送失败，原因是：{}", e.getMessage());
            return false;
        }
        return true;
    }
}
