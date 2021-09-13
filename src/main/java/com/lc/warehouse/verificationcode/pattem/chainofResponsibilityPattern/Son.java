package com.lc.warehouse.verificationcode.pattem.chainofResponsibilityPattern;

/**
 * @ClassName: Son
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/9/13 下午4:01
 */
public class Son extends Handler {

    public Son() {
        super(Handler.SON);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("---女儿向儿子请示---");
        System.out.println(women.getRequest());
    }
}
