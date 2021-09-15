package com.lc.warehouse.verificationcode.pattem.commandPattern;

/**
 * @ClassName: Client
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/9/13 下午8:29
 */
public class Client {

    public static void main(String[] args) {
        Invoker zhangsan = new Invoker();

        System.out.println("___________________");

        Command command = new AddRequirementCommand();

        zhangsan.setCommand(command);
        zhangsan.action();
    }
}
