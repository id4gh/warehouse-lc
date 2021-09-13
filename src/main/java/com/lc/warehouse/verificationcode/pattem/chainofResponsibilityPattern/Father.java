package com.lc.warehouse.verificationcode.pattem.chainofResponsibilityPattern;

/**
 * @ClassName: Father
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/9/13 下午3:55
 */
public class Father extends Handler {

    public Father() {
        super(Handler.FATHER);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("---女儿向父亲请示---");
        System.out.println(women.getRequest());
    }
}
