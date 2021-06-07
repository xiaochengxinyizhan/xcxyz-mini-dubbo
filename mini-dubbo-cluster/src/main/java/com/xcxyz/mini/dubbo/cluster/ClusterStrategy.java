package com.xcxyz.mini.dubbo.cluster;

import com.xcxyz.mini.dubbo.model.ProviderService;

import java.util.List;

/**
 * @author liuxiaocheng
 * @create 2021/6/1  3:59 下午
 */
public interface ClusterStrategy {
    /**
     * 负载策略算法
     *
     * @param providerServices
     * @return
     */
    public ProviderService select(List<ProviderService> providerServices);
}
