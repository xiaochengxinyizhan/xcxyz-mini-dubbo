package com.xcxyz.mini.dubbo.config.spring.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author liuxiaocheng
 * @create 2021/6/3  8:48 下午
 */
public class MiniDubboNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("service", new ProviderFactoryBeanDefinitionParser());
        registerBeanDefinitionParser("reference", new RevokerFactoryBeanDefinitionParser());
    }

}
