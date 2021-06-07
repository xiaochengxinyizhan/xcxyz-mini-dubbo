package com.xcxyz.mini.dubbo.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liuxiaocheng
 * @create 2021/6/1  4:54 下午
 */
public class MainClient {

    private static final Logger logger = LoggerFactory.getLogger(MainClient.class);

    public static void main(String[] args) throws Exception {

        //引入远程服务
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/mini-dubbo-consumer.xml");
        //获取远程服务
        final HelloService helloService = (HelloService) context.getBean("remoteHelloService");

        long count = 1000000000000000000L;

        //调用服务并打印结果
        for (int i = 0; i < count; i++) {
            try {
                String result = helloService.sayHello("滴滴哒哒,i=" + i);
                System.out.println(result);
            } catch (Exception e) {
                logger.warn("--------", e);
            }
        }

        //关闭jvm
        System.exit(0);
    }
}
