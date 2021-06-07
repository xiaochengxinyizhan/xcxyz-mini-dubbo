package com.xcxyz.mini.dubbo.cluster.impl;

import com.google.common.collect.Lists;
import com.xcxyz.mini.dubbo.cluster.ClusterStrategy;
import com.xcxyz.mini.dubbo.model.ProviderService;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;

/**
 * @author liuxiaocheng
 * @create 2021/6/1  4:03 下午
 */
public class WeightRandomClusterStrategyImpl  implements ClusterStrategy {


    @Override
    public ProviderService select(List<ProviderService> providerServices) {
        //存放加权后的服务提供者列表
        List<ProviderService> providerList = Lists.newArrayList();
        for (ProviderService provider : providerServices) {
            int weight = provider.getWeight();
            for (int i = 0; i < weight; i++) {
                providerList.add(provider.copy());
            }
        }

        int MAX_LEN = providerList.size();
        int index = RandomUtils.nextInt(0, MAX_LEN - 1);
        return providerList.get(index);
    }
}
