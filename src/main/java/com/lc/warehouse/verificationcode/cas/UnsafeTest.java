package com.lc.warehouse.verificationcode.cas;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @ClassName: Unsafe
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/5/27 下午3:10
 */
public class UnsafeTest {

//    //获取Unsafe的实例
//    static final Unsafe unsafe = Unsafe.getUnsafe();

    static final Unsafe unsafe;

    //记录变量state在类UnsafeTest中的偏移值
    static final long stateOffset;

    private volatile long state = 0;

    static {
        try {
            //使用反射获取Unsafe的成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");

            //设置为可存取
            field.setAccessible(true);

            //获取该变量值
            unsafe = (Unsafe) field.get(null);

            //获取state变量在类UnsafeTest中的偏移值
            stateOffset = unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("state"));
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            throw new Error(ex);
        }
    }

    public static void main(String[] args) {
        UnsafeTest test = new UnsafeTest();

        Boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(success);
    }

}
