package xin.fallen.po;

import java.util.Date;

/**
 * Author: Fallen
 * Date: 2017/3/8
 * Time: 22:54
 * Usage:
 */
public class CnUserOnLine {
    private int userId;
    private Date timeStamp;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}