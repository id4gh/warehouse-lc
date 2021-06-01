package com.lc.warehouse.verificationcode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/5/18 下午2:38
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public  String hello(){
        return "hello,spring boot !";
    }

}
