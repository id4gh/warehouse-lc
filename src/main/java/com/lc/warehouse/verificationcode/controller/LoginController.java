package com.lc.warehouse.verificationcode.controller;

import com.lc.warehouse.common.Message;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: LoginController
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/5/18 上午11:05
 */
@Controller
public class LoginController {

    @Autowired
    RedisTemplate redisTemplate;

    @PostMapping("/login")
    public Message login(HttpServletRequest request, HttpServletResponse response, String username, String password, String verCode) {
        if (!CaptchaUtil.ver(verCode, request)) {
            // 清除session中的验证码
            CaptchaUtil.clear(request);
            return Message.error("验证码不正确");
        }
        return Message.success();
    }
}