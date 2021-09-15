package com.lc.warehouse.verificationcode.pattem.commandPattern;

/**
 * @ClassName: Invoker
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/9/13 下午8:26
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action() {
        this.command.execute();
    }
}
