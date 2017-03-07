package xin.fallen.service;

import xin.fallen.bean.CnUser;

/**
 * Author: Fallen
 * Date: 2017/3/7
 * Time: 16:52
 * Usage:
 */
public interface UserIdentitySer {

    String userLogin(String username,String password);

    void userLogout(String username);
}
