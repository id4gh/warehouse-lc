package com.lc.warehouse.verificationcode.pattem.factoryPattern;

/**
 * @ClassName: ResponsibilityFactory
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/9/15 上午10:48
 */
public abstract class AbstractResponsibilityFactory {

    /**
     * 创建责任人
     *
     * @param c
     * @param <T>
     * @return
     */
    public abstract <T extends Responsibility> T createResponsibility(Class<T> c);

}
