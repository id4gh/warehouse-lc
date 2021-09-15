package com.lc.warehouse.verificationcode.pattem.proxyPattern;

import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName: Handler
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/9/7 上午10:56
 */
@Component
public class ProxyInvocationHandler implements InvocationHandler {

    //被代理的接口
    private Object target;


    public void setTarget(Object target) {
        this.target = target;
    }

    //获取代理类
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    //调用代理程序
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }


}
