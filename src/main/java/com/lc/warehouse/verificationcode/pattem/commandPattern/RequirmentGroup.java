package com.lc.warehouse.verificationcode.pattem.commandPattern;

/**
 * @ClassName: RequirmentGroup
 * @Author: mayanchao
 * @Description: 需求组
 * @Date: 2021/9/13 下午8:11
 */
public class RequirmentGroup extends Group {


    @Override
    public void find() {
        System.out.println("找到需求组。。。");
    }

    @Override
    public void add() {
        System.out.println("客户需要增加一个需求。。。");
    }

    @Override
    public void change() {
        System.out.println("客户需要修改一个需求。。。");
    }

    @Override
    public void delete() {
        System.out.println("客户要求删除一个需求。。。");

    }

    @Override
    public void plan() {
        System.out.println("客户要求需求变更计划。。。");

    }
}
