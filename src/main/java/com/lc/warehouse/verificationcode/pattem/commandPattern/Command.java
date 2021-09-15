package com.lc.warehouse.verificationcode.pattem.commandPattern;

/**
 * @ClassName: Command
 * @Author: mayanchao
 * @Description: 抽象命令类
 * @Date: 2021/9/13 下午8:20
 */
public abstract class Command {

    protected RequirmentGroup rg = new RequirmentGroup();
    protected PageGroup pg = new PageGroup();
    protected CodeGroup cg = new CodeGroup();

    public abstract void execute();
}
