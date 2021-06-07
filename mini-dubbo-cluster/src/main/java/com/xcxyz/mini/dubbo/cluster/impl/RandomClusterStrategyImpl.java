package com.xcxyz.mini.dubbo.cluster.impl;

import com.xcxyz.mini.dubbo.cluster.ClusterStrategy;
import com.xcxyz.mini.dubbo.model.ProviderService;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;

/**
 * @author liuxiaocheng
 * @create 2021/6/1  4:02 下午
 */
public class RandomClusterStrategyImpl  implements ClusterStrategy {
    @Override
    public ProviderService select(List<ProviderService> providerServices) {
        int MAX_LEN = providerServices.size();
        int index = RandomUtils.nextInt(0, MAX_LEN - 1);
        return providerServices.get(index);
    }
}
