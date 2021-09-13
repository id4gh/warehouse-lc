package com.lc.warehouse.verificationcode.pattem.chainofResponsibilityPattern;

/**
 * @ClassName: Hander
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/9/13 下午3:41
 */
public abstract class Handler {

    public final static int FATHER = 1;
    public final static int HUSBAND = 2;
    public final static int SON = 3;

    private int level = 0;
    private Handler nextHandler;

    public Handler(int _level) {
        this.level = _level;
    }


    public final void HandleMessage(IWomen women) {
        if (women.getType() == this.level) {
            this.response(women);
        } else {
            if (this.nextHandler != null) {
                this.nextHandler.HandleMessage(women);
            } else {
                System.out.println("--没地方请示了--");
            }
        }
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected abstract void response(IWomen women);

}
