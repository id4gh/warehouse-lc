package com.lc.warehouse.verificationcode.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: DistributeLock2
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/9/27 上午10:31
 */
@Component
public class DistributeLock {

    @Autowired
    CuratorOperator curatorOperator;

    //zk客户端
    @Autowired
    private CuratorFramework client;

    final static Logger log = LoggerFactory.getLogger(DistributeLock.class);

    //用于挂起当前请求，并等待上一个分布式锁
    private static CountDownLatch zkLockLatch = new CountDownLatch(1);

    //分布式总结点名
    private static final String ZK_LOCK_PROJECT = "lc-locks";
    //分布式节点
    private static final String DISTRIBUTED_LOCK = "distributed-lock";


    /**
     * 初始化锁
     */
    @PostConstruct
    public void init() {

        client = client.usingNamespace("ZKLocks-Namespace");
        /**
         * 创建zk总结点
         *      ZKLocks-Namespace
         *          ｜
         *           —— lc-locks
         *                  ｜
         *                   —— distributed-lock
         */
        try {
            if (client.checkExists().forPath("/" + ZK_LOCK_PROJECT) == null) {
                client.create()
                        .creatingParentsIfNeeded()
                        .withMode(CreateMode.PERSISTENT)
                        .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
                        .forPath("/" + ZK_LOCK_PROJECT);
            }
            addWatcherToLock("/" + ZK_LOCK_PROJECT);
        } catch (Exception e) {
            log.error("客户端连接zk服务器错误... 请重试...");
        }
    }

    /**
     * 获得分布式锁
     */
    public void getLock() {
        while (true) {
            try {
                String s = client.create()
                        .creatingParentsIfNeeded()
                        //EPHEMERAL-临时节点
                        .withMode(CreateMode.EPHEMERAL)
                        .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
                        .forPath("/" + ZK_LOCK_PROJECT + "/" + DISTRIBUTED_LOCK);
                System.out.println(s);
                log.info("获得分布式锁成功...");
                return;
            } catch (Exception e) {
                log.info("获得分布式锁失败...");
                try {
                    if (zkLockLatch.getCount() <= 0) {
                        zkLockLatch = new CountDownLatch(1);
                    }
                    zkLockLatch.await();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }

    /**
     * 释放分布式锁
     */
    public Boolean releaseLock() {
        try {
            if (client.checkExists().forPath("/" + ZK_LOCK_PROJECT + "/" + DISTRIBUTED_LOCK) != null) {
                client.delete().forPath("/" + ZK_LOCK_PROJECT + "/" + DISTRIBUTED_LOCK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        log.info("分布式锁释放完毕");
        return true;
    }

    /**
     * 创建watcher监听
     */
    public void addWatcherToLock(String path) throws Exception {
        final PathChildrenCache cache = new PathChildrenCache(client, path, true);
        cache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
        cache.getListenable().addListener((curatorFramework, event) -> {
            if (event.getType().equals(PathChildrenCacheEvent.Type.CHILD_REMOVED)) {
                String path1 = event.getData().getPath();
                log.info("上个会话已释放锁或该会话已断开，节点路径为：" + path1);
                if (path1.contains(DISTRIBUTED_LOCK)) {
                    log.info("释放计数器，让当前请求来获得分布式锁...");
                    zkLockLatch.countDown();
                }
            }
        });
    }

}
