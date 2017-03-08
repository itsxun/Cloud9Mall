package xin.fallen.po;

import java.util.Date;

/**
 * Author: Fallen
 * Date: 2017/3/8
 * Time: 17:46
 * Usage:
 */
public class EmailVerify {
    private String captcha;
    private Date timeStamp;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
