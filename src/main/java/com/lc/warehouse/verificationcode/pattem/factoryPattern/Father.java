package com.lc.warehouse.verificationcode.pattem.factoryPattern;

/**
 * @ClassName: Father
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/9/13 下午3:55
 */
public class Father implements Responsibility {


    @Override
    public void responsibility() {
        System.out.println("我是爸爸");
    }
}
