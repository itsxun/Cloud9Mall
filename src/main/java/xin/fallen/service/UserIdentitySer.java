package xin.fallen.service;

import xin.fallen.bean.CnUser;
import xin.fallen.vo.JsonResult;

/**
 * Author: Fallen
 * Date: 2017/3/7
 * Time: 16:52
 * Usage:
 */
public interface UserIdentitySer {

    JsonResult userLogin(String username, String password);

    JsonResult userRegist(CnUser user);

    JsonResult userLogout(String username);

    JsonResult isEmailExists(String email);

    JsonResult isUsernameExists(String username);

    JsonResult userEmailSend(String email);

    JsonResult userEmailVerify(String email, String captcha);
}
