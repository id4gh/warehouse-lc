package com.lc.warehouse.verificationcode.pattem.proxyPattern;

import org.springframework.stereotype.Service;

/**
 * @ClassName: Hello
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/9/7 上午11:24
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("Hello world!");
    }
}