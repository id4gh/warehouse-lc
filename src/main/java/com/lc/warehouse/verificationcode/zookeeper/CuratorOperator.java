package com.lc.warehouse.verificationcode.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ClassName: CuratorOperator
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/9/27 上午9:45
 */
@Component
public class CuratorOperator {

    public CuratorFramework client = null;
    public static final String zkServerPath = "192.168.0.129:2181";

    /**
     * 实例化zk客户端
     */
    @Bean
    public CuratorFramework getCuratorFrameworkClient(){
        /**
         * 同步创建zk示例，原生api是异步的
         *
         * curator链接zookeeper的重试策略:
         *
         * 1>ExponentialBackoffRetry【推荐】
         * baseSleepTimeMs：初始sleep时间(ms)
         * maxRetries：最大重试次数，超过时间就不链接了
         * maxSleepMs：最大重试时间(ms)
         *
         * 给定一个初始sleep时间base5leep丁imeMs，在这个基础上结合重试次数，通过以下公式计算出当前需要sleep的时间:
         当前sleep时间=baseSleepTimeMs*Math.max(1, random.nextInt(1<<(retryCount+1)))
         可以看出，随着重试次数的增加，计算出的sleep时间会越来越大。如果该sleep时间在maxSleepMs的范围之内，那么就使用该sleep时间，否则使用maxSleepMs。另外，
         maxRetries参数控制了最大重试次数，以避免无限制的重试。
         */
//        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 5);

        /**
         * curator链接zookeeper的策略:
         * 2>RetryNTimes【推荐】
         * n：重试的次数
         * sleepMsBetweenRetries：每次重试间隔的时间(ms)
         */
		RetryPolicy retryPolicy = new RetryNTimes(3, 5000);

        /**
         * curator链接zookeeper的策略:
         * 3>RetryOneTime
         * sleepMsBetweenRetry:只重试一次，重试间隔的时间
         */
//		RetryPolicy retryPolicy2 = new RetryOneTime(3000);

        /**
         * 4>
         * 永远重试，不推荐使用
         */
//		RetryPolicy retryPolicy3 = new RetryForever(retryIntervalMs)

        /**
         * curator链接zookeeper的策略:
         * 5>RetryUntilElapsed
         * maxElapsedTimeMs:最大重试时间
         * sleepMsBetweenRetries:每次重试间隔
         * 重试时间超过maxElapsedTimeMs后，就不再重试
         */
//		RetryPolicy retryPolicy4 = new RetryUntilElapsed(2000, 3000);

        //创建客户端
        client = CuratorFrameworkFactory.builder()  //builder
                .connectString(zkServerPath)
                .sessionTimeoutMs(10000)  //session超时时间
                .retryPolicy(retryPolicy)  //重试策略
                .build();
        /**
         * CuratorFrameworkFactory工厂在创建出一个客户端CuratorFramework实例之后，实质上并没有完成会话的创建，而是需要调用
         CuratorFramework的sta rt)方法来完成会话的创建。
         */
        client.start();

        return client;
    }


    /**
     *
     * @Description: 关闭zk客户端连接
     */
//    public void closeZKClient() {
//        if (client != null) {
//            this.client.close();
//        }
//    }


//    public static void main(String[] args) throws Exception {
//        // 实例化
//        CuratorOperator cto = new CuratorOperator();
//        boolean isZkCuratorStarted = cto.client.isStarted();
//        System.out.println("当前客户的状态：" + (isZkCuratorStarted ? "连接中" : "已关闭"));
//
//        Thread.sleep(3000);
//
//        cto.closeZKClient();
//        boolean isZkCuratorStarted2 = cto.client.isStarted();
//        System.out.println("当前客户的状态：" + (isZkCuratorStarted2 ? "连接中" : "已关闭"));
//    }

}