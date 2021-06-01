package com.lc.warehouse.random;

import java.util.Random;

/**
 * @ClassName: RandomTest
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/5/29 下午4:58
 */
public class RandomTest {

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(5));
        }
    }

}
