package com.lc.warehouse.verificationcode.pattem.commandPattern;

/**
 * @ClassName: RequirmentGroup
 * @Author: mayanchao
 * @Description: 美工组
 * @Date: 2021/9/13 下午8:11
 */
public class PageGroup extends Group {


    @Override
    public void find() {
        System.out.println("找到美工组。。。");
    }

    @Override
    public void add() {
        System.out.println("客户需要增加一个页面。。。");
    }

    @Override
    public void change() {
        System.out.println("客户需要修改一个页面。。。");
    }

    @Override
    public void delete() {
        System.out.println("客户要求删除一个页面。。。");

    }

    @Override
    public void plan() {
        System.out.println("客户要求页面变更计划。。。");

    }
}
