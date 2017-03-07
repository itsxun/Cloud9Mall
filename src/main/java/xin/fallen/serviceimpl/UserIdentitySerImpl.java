package xin.fallen.serviceimpl;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import xin.fallen.bean.CnUser;
import xin.fallen.config.StaticConfig;
import xin.fallen.dao.CnUserMapper;
import xin.fallen.service.UserIdentitySer;
import xin.fallen.util.JedisUtil;
import xin.fallen.vo.JsonResult;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Author: Fallen
 * Date: 2017/3/7
 * Time: 16:55
 * Usage:
 */
@Service
public class UserIdentitySerImpl implements UserIdentitySer {

    @Resource
    private CnUserMapper cnUserMapper;

    public String userLogin(String username, String password) {
        Integer userId = cnUserMapper.selectPrimaryKeyForLogin(username, password);
        if (userId == null) {
            return null;
        }
        String token = UUID.randomUUID().toString();
        JedisUtil.setValue(token, String.valueOf(userId), StaticConfig.userAliveTime);
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
        return cnUserMapper.selectEmailIfExist(email)==null;
    }
}