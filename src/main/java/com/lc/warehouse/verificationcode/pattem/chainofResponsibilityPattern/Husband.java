package com.lc.warehouse.verificationcode.pattem.chainofResponsibilityPattern;

/**
 * @ClassName: Husband
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/9/13 下午3:59
 */
public class Husband extends Handler {

    public Husband() {
        super(Handler.HUSBAND);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("---女儿向丈夫请示---");
        System.out.println(women.getRequest());
    }
}
