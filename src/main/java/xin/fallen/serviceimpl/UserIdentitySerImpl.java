package xin.fallen.serviceimpl;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import xin.fallen.bean.CnUser;
import xin.fallen.dao.CnUserMapper;
import xin.fallen.service.UserIdentitySer;

import javax.annotation.Resource;

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

        return null;
    }

    public void userLogout(String username) {

    }
}
