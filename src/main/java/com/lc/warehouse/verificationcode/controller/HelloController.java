package com.lc.warehouse.verificationcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: HelloController
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/5/18 下午2:38
 */
@RestController
public class HelloController {

    @Autowired


    @RequestMapping("/hello")
    public  String hello(){
        return "hello,spring boot !";
    }

    public static void main(String[] args) {
        List<Integer> llnkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();

        Map<String, String> conurrentHashMap = new ConcurrentHashMap<>();
    }





}
