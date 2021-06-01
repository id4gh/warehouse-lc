package com.lc.warehouse.verificationcode.controller;

import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: CaptchaController
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/5/18 上午11:01
 */
@Controller
public class CaptchaController {

    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //<img src="/captcha" width="130px" height="48px" />
        CaptchaUtil.out(request, response);
    }
}
