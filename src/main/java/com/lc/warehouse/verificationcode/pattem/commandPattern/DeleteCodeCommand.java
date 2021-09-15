package com.lc.warehouse.verificationcode.pattem.commandPattern;

/**
 * @ClassName: DeleteCodeCommand
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/9/13 下午8:28
 */
public class DeleteCodeCommand extends Command {
    @Override
    public void execute() {
        super.cg.find();
        super.cg.delete();
        super.cg.plan();
    }
}
