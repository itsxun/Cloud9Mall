package xin.fallen.util;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;

import java.io.File;

/**
 * Author: Fallen
 * Date: 2017/3/7
 * Time: 22:21
 * Usage:
 */
public class EmailUtil {
    public static void sendHtmlEmail() {
        HtmlEmail email = new HtmlEmail();//如果要发送带附件的邮件，需使用这个类
        email.setHostName("smtp.163.com"); // 邮件服务器域名
        email.setAuthentication("cloud9mall@163.com", "Fallen2333");
        email.setCharset("UTF-8");
        try {
            email.setFrom("cloud9mall@163.com");//设置发件人
            email.addTo("24276284@qq.com");//设置收件人
            email.setSubject("明天开会");//设置主题
            email.setMsg("操你大爷不让发");//设置邮件内容
            email.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        sendHtmlEmail();
    }
}
