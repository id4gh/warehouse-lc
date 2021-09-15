package com.lc.warehouse.verificationcode.pattem.factoryPattern;

/**
 * @ClassName: ResponsibilityFactory
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/9/15 上午10:52
 */
public class ResponsibilityFactory extends AbstractResponsibilityFactory {
    @Override
    public <T extends Responsibility> T createResponsibility(Class<T> c) {
        Responsibility responsibility = null;
        try {
            responsibility = (T) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("报错");
        }
        return (T) responsibility;
    }
}
