package xin.fallen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xin.fallen.bean.CnUser;
import xin.fallen.service.UserIdentitySer;
import xin.fallen.util.EmailUtil;
import xin.fallen.util.JsonResultUtil;
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
        String token = userIdentitySerImpl.userLogin(username, password);
        return JsonResultUtil.resDispatcher("登陆成功", "登录失败", token);
    }

    @RequestMapping("/regist")
    @ResponseBody
    public JsonResult userRegist(CnUser user) {
        Integer userId = userIdentitySerImpl.userRegist(user);
        return JsonResultUtil.resDispatcher(userId);
    }

    @RequestMapping("/regist/SendEmail")
    @ResponseBody
    public JsonResult userEmailSend(String email) {
        if (EmailUtil.isVaildEmail(email) || !userIdentitySerImpl.isEmailExists(email)) {
            return JsonResultUtil.resDispatcher("", "该邮箱格式不对或已经被使用", 0);
        }
        return JsonResultUtil.resDispatcher("发送成功，请注意查收", "邮件有效期内请不要重复发送邮件", userIdentitySerImpl.userEmailSend(email));
    }

    @RequestMapping("/regist/VerifyEmail")
    @ResponseBody
    public JsonResult userEmailVerify(String email, String captcha) {
        return JsonResultUtil.resDispatcher(userIdentitySerImpl.userEmailVerify(email, captcha));
    }

}
