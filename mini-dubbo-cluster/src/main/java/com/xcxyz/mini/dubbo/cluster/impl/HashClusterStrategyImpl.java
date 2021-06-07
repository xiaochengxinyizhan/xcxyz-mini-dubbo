package com.xcxyz.mini.dubbo.cluster.impl;

import com.xcxyz.mini.dubbo.cluster.ClusterStrategy;
import com.xcxyz.mini.dubbo.common.utils.IPHelper;
import com.xcxyz.mini.dubbo.model.ProviderService;

import java.util.List;

/**
 * @author liuxiaocheng
 * @create 2021/6/1  4:01 下午
 */
public class HashClusterStrategyImpl implements ClusterStrategy {

    @Override
    public ProviderService select(List<ProviderService> providerServices) {
        //获取调用方ip
        String localIP = IPHelper.localIp();
        //获取源地址对应的hashcode
        int hashCode = localIP.hashCode();
        //获取服务列表大小
        int size = providerServices.size();

        return providerServices.get(hashCode % size);
    }
}
