package com.xcxyz.mini.dubbo.demo;

/**
 * @author liuxiaocheng
 * @create 2021/6/1  4:53 下午
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String somebody) {
        return "hello " + somebody + "!";
    }

}
