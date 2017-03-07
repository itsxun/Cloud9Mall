package xin.fallen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xin.fallen.bean.CnUser;
import xin.fallen.service.UserIdentitySer;
import xin.fallen.util.JsonResultUtil;
import xin.fallen.vo.JsonResult;

import javax.annotation.Resource;
import java.util.Random;
import java.util.UUID;

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
    public JsonResult userLogin(String username, String password) {
        String token = userIdentitySerImpl.userLogin(username, password);
        return JsonResultUtil.resDispatcher(token);
    }


}
