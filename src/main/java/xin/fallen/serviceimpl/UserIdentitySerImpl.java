package xin.fallen.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import xin.fallen.bean.CnUser;
import xin.fallen.config.StaticConfig;
import xin.fallen.dao.CnUserMapper;
import xin.fallen.po.EmailVerify;
import xin.fallen.service.UserIdentitySer;
import xin.fallen.util.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * Author: Fallen
 * Date: 2017/3/7
 * Time: 16:55
 * Usage:
 */
@Service
public class UserIdentitySerImpl implements UserIdentitySer {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private CnUserMapper cnUserMapper;

    public String userLogin(String username, String password) {
        Integer userId = cnUserMapper.selectPrimaryKeyForLogin(username, password);
        if (userId == null) {
            return null;
        }
        String token = UUID.randomUUID().toString();
        JedisUtil.setValue(token, String.valueOf(userId), StaticConfig.userAliveTime);
//        JedisUtil.addToMap(StaticConfig.onlineUserMapName,token)
        return token;
    }

    public Integer userRegist(CnUser user) {
        Date today = new Date();
        user.setDateJoined(today);
        user.setIsStaff(false);
        user.setIsActive(false);
        user.setIsSuperuser(false);
        user.setLastLogin(today);
        user.setDateJoined(today);
        cnUserMapper.insertSelective(user);
        return user.getId();
    }

    public void userLogout(String username) {

    }

    public boolean isEmailExists(String email) {
        return cnUserMapper.selectEmailIfExist(email) == null;
    }

    public boolean userEmailSend(String email) {
        String obj = JedisUtil.getFromMap(StaticConfig.registEmailVerifyMapName, email);
        if (obj == null) {
            return false;
        }
        EmailVerify ev = (EmailVerify) SerializeUtil.unserialize(obj.getBytes());
        if (DateUtil.isOverTime(new Date(), ev.getTimeStamp(), StaticConfig.registEmailTimeOut)) {
            String captcha = RandomUtil.getRandomString();
            try {
                JedisUtil.addToMap(StaticConfig.registEmailVerifyMapName, email, captcha);
                EmailUtil.sendHtmlEmail(StaticConfig.officialEmailSender, email, StaticConfig.registEmailSubject, StaticConfig.registEmailContent.replace("{CAPTCHA}", captcha));
            } catch (Exception e) {
                JedisUtil.delFromMap(StaticConfig.registEmailVerifyMapName, email);
                log.error("用户注册验证邮件发送异常，原因是{}");
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean userEmailVerify(String email, String captcha) {
//        Long timeStamp = Long.parseLong(JedisUtil.getFromMap(StaticConfig.registEmailTimeStampMapName, email));
//        Date date = new Date(timeStamp);
//        if (DateUtil.isOverTime(new Date(), date, StaticConfig.registEmailTimeOut)) {
//            JedisUtil.delFromMap(StaticConfig.registEmailTimeStampMapName, email);
//            JedisUtil.delFromMap(StaticConfig.registEmailVerifyMapName, email);
//            return false;
//        }
//        String _captcha = JedisUtil.getFromMap(StaticConfig.registEmailVerifyMapName, email);
//        if (_captcha.equalsIgnoreCase(captcha)) {
//            JedisUtil.delFromMap(StaticConfig.registEmailTimeStampMapName, email);
//            JedisUtil.delFromMap(StaticConfig.registEmailVerifyMapName, email);
//            return true;
//        }
        return false;
    }
}