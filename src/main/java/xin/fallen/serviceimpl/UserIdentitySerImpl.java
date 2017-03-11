package xin.fallen.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xin.fallen.bean.CnUser;
import xin.fallen.config.StaticConfig;
import xin.fallen.dao.CnUserMapper;
import xin.fallen.po.CnUserOnLine;
import xin.fallen.po.EmailVerify;
import xin.fallen.service.UserIdentitySer;
import xin.fallen.util.*;
import xin.fallen.vo.JsonResult;

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

    public JsonResult userLogin(String username, String password) {
        Integer userId = cnUserMapper.selectPrimaryKeyForLogin(username, password);
        if (userId == null) {
            return JsonResultUtil.resDispatcher("账户名或密码错误", 0);
        }
        String token = UUID.randomUUID().toString();
//        if (JedisUtil.addObjToMap(StaticConfig.onlineUserMapName, token, b)) {
//            return JsonResultUtil.resDispatcher("登陆成功", "登录失败", token);
//        }
        return JsonResultUtil.resDispatcher(0);
    }

    public JsonResult userRegist(CnUser user) {
        String salt = RandomUtil.getRandomString(6);
        Date today = new Date();
        user.setDateJoined(today);
        user.setIsStaff(false);
        user.setIsActive(false);
        user.setIsSuperuser(false);
        user.setLastLogin(today);
        user.setDateJoined(today);
        user.setSalt(salt);
        Integer res = cnUserMapper.insertSelective(user);
        return JsonResultUtil.resDispatcher(res);
    }

    public JsonResult userLogout(String username) {
        return null;
    }

    public JsonResult isEmailExists(String email) {
        return JsonResultUtil.resDispatcher("该邮箱可以使用", "该邮箱已经别人使用了", cnUserMapper.selectEmailIfExist(email) == null);
    }

    public JsonResult isUsernameExists(String username) {
        return JsonResultUtil.resDispatcher("用户名可以使用", "用户名已经别人使用了", cnUserMapper.selectEmailIfExist(username) == null);
    }

    public JsonResult userEmailSend(String email) {
        byte[] b = JedisUtil.getObjFromMap(StaticConfig.registEmailVerifyMapName, email, EmailVerify.class);
        if (b != null && b.length > 0) {
            EmailVerify ev = (EmailVerify) SerializeUtil.unserialize(b);
            if (DateUtil.isOverTime(ev.getTimeStamp(), new Date(), StaticConfig.registEmailTimeOut)) {
                return JsonResultUtil.resDispatcher("请于验证码有效期后再重新获取", 0);
            }
        }
        JedisUtil.delFromMap(StaticConfig.registEmailVerifyMapName, email);
        String captcha = RandomUtil.getRandomString(6);
        EmailVerify ev = new EmailVerify();
        ev.setCaptcha(captcha);
        ev.setTimeStamp(new Date());
        try {
            JedisUtil.addObjToMap(StaticConfig.registEmailVerifyMapName, email, ev);
            EmailUtil.sendHtmlEmail(StaticConfig.officialEmailSender, email, StaticConfig.registEmailSubject, StaticConfig.registEmailContent.replace("{CAPTCHA}", captcha));
        } catch (Exception e) {
            JedisUtil.delFromMap(StaticConfig.registEmailVerifyMapName, email);
            log.error("用户注册验证邮件发送异常，原因是{}", e.getMessage());
            return JsonResultUtil.resDispatcher("验证码发送失败，需要帮助请联系管理员", 0);
        }
        return JsonResultUtil.resDispatcher("发送成功", 1);
    }

    public JsonResult userEmailVerify(String email, String captcha) {
        byte[] b = JedisUtil.getObjFromMap(StaticConfig.registEmailVerifyMapName, email, EmailVerify.class);
        if (b == null || b.length == 0) {
            return JsonResultUtil.resDispatcher("没有找到您的验证码信息，请尝试重新发送", 0);
        }
        EmailVerify ev = (EmailVerify) SerializeUtil.unserialize(b);
        if (DateUtil.isOverTime(ev.getTimeStamp(), new Date(), StaticConfig.registEmailTimeOut)) {
            return JsonResultUtil.resDispatcher("验证码已过期，请重新获取", 0);
        }
        return JsonResultUtil.resDispatcher("验证码正确", "验证码错误", captcha.equalsIgnoreCase(ev.getCaptcha()));
    }
}