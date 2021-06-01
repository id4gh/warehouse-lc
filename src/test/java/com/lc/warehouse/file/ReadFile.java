package com.lc.warehouse.file;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @ClassName: ReadFile
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/5/21 上午11:08
 */
public class ReadFile {

    //        String filePath = "/Users/mayanchao/Desktop/域名";
    private String filePath = "/Users/mayanchao/杂物/2019年初工作汇报.txt";

    /**
     * 实用普通流读取文本信息
     *
     * @throws Exception
     */
    @Test
    void bufferedReader() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String str = null;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }

        InputStream in = new FileInputStream(filePath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
    }


    /**
     * 实用stream流读取文本信息
     *
     * @throws Exception
     */
    @Test
    void stream() throws Exception {
        Stream<String> lines = Files.lines(Paths.get(filePath));
        lines.forEach(System.out::println);
    }
}
