package com.xcxyz.mini.dubbo.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liuxiaocheng
 * @create 2021/6/1  4:54 下午
 */
public class MainServer {
    public static void main(String[] args) throws Exception {

        //发布服务
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/mini-dubbo-provider.xml");
        context.start();
        System.out.println(" 服务发布完成");
    }
}
