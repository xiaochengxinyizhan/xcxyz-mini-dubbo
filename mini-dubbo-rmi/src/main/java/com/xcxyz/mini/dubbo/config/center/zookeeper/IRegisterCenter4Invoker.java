package com.xcxyz.mini.dubbo.config.center.zookeeper;

import com.xcxyz.mini.dubbo.model.InvokerService;
import com.xcxyz.mini.dubbo.model.ProviderService;

import java.util.List;
import java.util.Map;

/**
 * @author liuxiaocheng
 * @create 2021/6/1  4:21 下午
 */
public interface IRegisterCenter4Invoker {

    /**
     * 消费端初始化服务提供者信息本地缓存
     *
     * @param remoteAppKey
     * @param groupName
     */
    public void initProviderMap(String remoteAppKey, String groupName);


    /**
     * 消费端获取服务提供者信息
     *
     * @return
     */
    public Map<String, List<ProviderService>> getServiceMetaDataMap4Consume();


    /**
     * 消费端将消费者信息注册到zk对应的节点下
     *
     * @param invoker
     */
    public void registerInvoker(final InvokerService invoker);

}
