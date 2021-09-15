package com.lc.warehouse.verificationcode.pattem.factoryPattern;

/**
 * @ClassName: Client
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/9/13 下午4:05
 */
public class Client {

    public static void main(String[] args) {
        AbstractResponsibilityFactory factory = new ResponsibilityFactory();
        Responsibility father = factory.createResponsibility(Father.class);
        father.responsibility();
        System.out.println("------------------------------");
        Responsibility husband = factory.createResponsibility(Husband.class);
        husband.responsibility();
        System.out.println("------------------------------");
        Responsibility son = factory.createResponsibility(Son.class);
        son.responsibility();
        System.out.println("------------------------------");
    }

}
