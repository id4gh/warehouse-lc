package com.lc.warehouse.verificationcode.pattem.proxyPattern;

/**
 * @ClassName: HelloProxy
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/9/7 上午11:25
 */
public class HelloProxy implements HelloService {
    private HelloService helloService = new HelloServiceImpl();
    @Override
    public void sayHello() {
        System.out.println("Before invoke sayHello" );
        helloService.sayHello();
        System.out.println("After invoke sayHello");
    }

}

