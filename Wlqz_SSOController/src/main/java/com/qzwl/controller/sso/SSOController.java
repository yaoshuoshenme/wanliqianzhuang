package com.qzwl.controller.sso;

import com.alibaba.fastjson.JSON;
import com.qzwl.common.result.R;
import com.qzwl.common.util.CookieUtil;
import com.qzwl.service.sso.SSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class SSOController {
    @Autowired
    private SSOService ssoService;

    //登录
    @GetMapping("/ssologin.do")
    public R login(String username, String password, HttpServletResponse response, HttpServletRequest request){
        //cookie找令牌
        String token = CookieUtil.getCk(request, "token");
        if(null != token && token.length() > 0){
            return ssoService.loginCheck(token);
        }else{
            R r = ssoService.selectByName(username, password);
            if(r.getCode() == 0){
                Cookie cookie = new Cookie("token",JSON.toJSONString(r.getData()));
                response.addCookie(cookie);
            }
            return r;
        }
    }

    //检查
    @RequestMapping("ssologincheck.do")
    public R ssologincheck(HttpServletRequest request, HttpServletResponse response){
        String token = CookieUtil.getCk(request,"token");
        if(null != token){
            return ssoService.loginCheck(token);
        }
        return R.setERROR();
    }
    //注销
    @RequestMapping("/ssologout.do")
    public R ssologout(HttpServletRequest request,HttpServletResponse response){
        String token = CookieUtil.getCk(request, "token");
        CookieUtil.delCK(response, "token");

        return ssoService.logout(token);
    }


}
