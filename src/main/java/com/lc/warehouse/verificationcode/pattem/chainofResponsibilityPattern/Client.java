package com.lc.warehouse.verificationcode.pattem.chainofResponsibilityPattern;

import java.util.ArrayList;

/**
 * @ClassName: Client
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/9/13 下午4:05
 */
public class Client {

    public static void main(String[] args) {
        ArrayList<Women> arrayList = new ArrayList();

        for (int i = 0; i < 3; i++) {
            arrayList.add(new Women(i+1, "我要出去逛街"));
        }
        Handler father = new Father();
        Handler husband = new Husband();
        Handler son = new Son();

        father.setNextHandler(husband);
        husband.setNextHandler(son);

        for (IWomen women : arrayList) {
            father.HandleMessage(women);
        }
    }


}
