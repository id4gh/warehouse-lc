package com.lc.warehouse.verificationcode.test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName: Wait
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/5/19 上午11:12
 */
public class Wait {
    private static final int MAX_SIZE = 30;
    private final Queue<String> queue = new ArrayDeque<>();

    public void producer(String ele) {
        synchronized (queue) {
            while (queue.size() == MAX_SIZE) {
                try {
                    //挂起当前线程，并释放通过同步块获取的queue上的锁，让消费者线程可以获取该锁，然后获取队列里面的元素
                    queue.wait();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            queue.add(ele);
            queue.notifyAll();
        }
    }

    public String consumer() {
        synchronized (queue) {
            while (queue.size() == 0) {
                try {
                    //挂起当前线程，并释放通过同步块获取的queue上的锁，让生产者线程可以获取该锁，将生产元素放入队列
                    queue.wait();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            String poll = queue.poll();
            queue.notifyAll();
            return poll;
        }
    }

}
