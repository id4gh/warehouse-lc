package com.lc.warehouse.verificationcode.pattem.commandPattern;

/**
 * @ClassName: AddRequirementCommand
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/9/13 下午8:24
 */
public class AddRequirementCommand extends Command {
    @Override
    public void execute() {
        super.rg.find();
        super.rg.add();
        super.rg.plan();
    }
}
