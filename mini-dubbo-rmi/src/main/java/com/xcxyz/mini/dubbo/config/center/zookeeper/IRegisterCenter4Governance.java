package com.xcxyz.mini.dubbo.config.center.zookeeper;

import com.xcxyz.mini.dubbo.model.InvokerService;
import com.xcxyz.mini.dubbo.model.ProviderService;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

/**
 * @author liuxiaocheng
 * @create 2021/6/1  4:20 下午
 */
public interface IRegisterCenter4Governance {

    /**
     * 获取服务提供者列表与服务消费者列表
     *
     * @param serviceName
     * @param appKey
     * @return
     */
    public Pair<List<ProviderService>, List<InvokerService>> queryProvidersAndInvokers(String serviceName, String appKey);


}
