package com.lc.warehouse.verificationcode.pattem.commandPattern;

/**
 * @ClassName: RequirmentGroup
 * @Author: mayanchao
 * @Description: 代码组
 * @Date: 2021/9/13 下午8:11
 */
public class CodeGroup extends Group {


    @Override
    public void find() {
        System.out.println("找到代码组。。。");
    }

    @Override
    public void add() {
        System.out.println("客户需要增加一个功能。。。");
    }

    @Override
    public void change() {
        System.out.println("客户需要修改一个功能。。。");
    }

    @Override
    public void delete() {
        System.out.println("客户要求删除一个功能。。。");

    }

    @Override
    public void plan() {
        System.out.println("客户要求功能变更计划。。。");

    }
}
