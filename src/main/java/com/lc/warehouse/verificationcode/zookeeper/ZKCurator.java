package com.lc.warehouse.verificationcode.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName: ZKCurator
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/9/27 上午10:15
 */
@Component
public class ZKCurator {

    @Autowired
    CuratorOperator curatorOperator;

    //zk客户端
    @Autowired
    private CuratorFramework client ;

    final static Logger log = LoggerFactory.getLogger(ZKCurator.class);

    /**
     * 初始化
     */
    @PostConstruct
    public void init() {
        client = client.usingNamespace("zk-curator-connector");
    }

    /**
     * 判断zk是否连接
     *
     * @return
     */
    public Boolean isZKAlive() {
        return client.isStarted();
    }


}
