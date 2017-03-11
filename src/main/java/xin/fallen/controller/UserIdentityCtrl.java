package xin.fallen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xin.fallen.bean.CnUser;
import xin.fallen.service.UserIdentitySer;
import xin.fallen.util.EmailUtil;
import xin.fallen.vo.JsonResult;

import javax.annotation.Resource;

/**
 * Author: Fallen
 * Date: 2017/3/6
 * Time: 16:06
 * Usage:
 */
@Controller
@RequestMapping("/user")
public class UserIdentityCtrl {

    @Resource
    private UserIdentitySer userIdentitySerImpl;

    @RequestMapping("/login")
    @ResponseBody
    public JsonResult userLogin(String username, String password) {
        return userIdentitySerImpl.userLogin(username, password);
    }

    @RequestMapping("/regist")
    @ResponseBody
    public JsonResult userRegist(CnUser user) {
        return userIdentitySerImpl.userRegist(user);
    }

    @RequestMapping("/regist/SendEmail")
    @ResponseBody
    public JsonResult userEmailSend(String email) {
        if (EmailUtil.isVaildEmail(email)) {
            return userIdentitySerImpl.isEmailExists(email);
        }
        return userIdentitySerImpl.userEmailSend(email);
    }

    @RequestMapping("/regist/VerifyUsername")
    @ResponseBody
    public JsonResult usernameVerify(String username) {
        return userIdentitySerImpl.isUsernameExists(username);
    }

    @RequestMapping("/regist/VerifyEmail")
    @ResponseBody
    public JsonResult userEmailVerify(String email, String captcha) {
        return userIdentitySerImpl.userEmailVerify(email, captcha);
    }
}