package xin.fallen.service;

import xin.fallen.bean.CnUser;

/**
 * Author: Fallen
 * Date: 2017/3/7
 * Time: 16:52
 * Usage:
 */
public interface UserIdentitySer {

    String userLogin(String username, String password);

    Integer userRegist(CnUser user);

    void userLogout(String username);

    boolean isEmailExists(String email);
}
