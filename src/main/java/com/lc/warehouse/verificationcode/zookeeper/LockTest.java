package com.lc.warehouse.verificationcode.zookeeper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: Demo
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/9/27 上午11:35
 */
@RestController
public class LockTest {

    @Autowired
    LockService lockService;

    @RequestMapping("/lockTest")
    public void test() {
        new Thread(() -> {
            lockService.lockTest();
        }, "AA").start();


        new Thread(() -> {
            lockService.lockTest();
        }, "BB").start();

        new Thread(() -> {
            lockService.lockTest();
        }, "CC").start();

        new Thread(() -> {
            lockService.lockTest();
        }, "DD").start();
    }


}

@Service
class LockService {
    @Autowired
    DistributeLock distributeLock;

    public void lockTest() {
        distributeLock.getLock();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        distributeLock.releaseLock();
    }

}
