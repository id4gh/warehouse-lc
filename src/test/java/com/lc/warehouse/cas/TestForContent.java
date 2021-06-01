package com.lc.warehouse.cas;

import org.junit.jupiter.api.Test;
import sun.misc.Contended;

import java.io.*;

/**
 * @ClassName: TestForContent
 * @Author: mayanchao
 * @Description: 伪公项（因为cpu和主内存之间添加了一级或多级高速缓冲存储器Cache，集成在cpu内部）
 * @Date: 2021/5/27 下午4:33
 */
public class TestForContent {

    static final int LINE_NUM = 1024;
    static final int COLUM_NUM = 1024;

    public static void main(String[] args) {

        long[][] array = new long[LINE_NUM][COLUM_NUM];

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < LINE_NUM; ++i) {
            for (int j = 0; j < COLUM_NUM; ++j) {
                array[i][j] = i * 2 + j;
            }
        }
        long endTime = System.currentTimeMillis();
        long cacheTime = endTime - startTime;
        System.out.println("cache time:" + cacheTime);
    }
}

class TestForContent2 {

    static final int LINE_NUM = 1024;
    static final int COLUM_NUM = 1024;

    public static void main(String[] args) {

        long[][] array = new long[LINE_NUM][COLUM_NUM];

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < LINE_NUM; ++i) {
            for (int j = 0; j < COLUM_NUM; ++j) {
                array[j][i] = i * 2 + j;
            }
        }
        long endTime = System.currentTimeMillis();
        long cacheTime = endTime - startTime;
        System.out.println("no cache time:" + cacheTime);
    }
}
