package com.xcxyz.mini.dubbo.model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author liuxiaocheng
 * @create 2021/6/1  3:33 下午
 */
public class MiniDubboResponseWrapper {

    //存储返回结果的阻塞队列
    private BlockingQueue<MiniDubboResponse> responseQueue = new ArrayBlockingQueue<MiniDubboResponse>(1);
    //结果返回时间
    private long responseTime;

    /**
     * 计算该返回结果是否已经过期
     *
     * @return
     */
    public boolean isExpire() {
        MiniDubboResponse response = responseQueue.peek();
        if (response == null) {
            return false;
        }

        long timeout = response.getInvokeTimeout();
        if ((System.currentTimeMillis() - responseTime) > timeout) {
            return true;
        }
        return false;
    }

    public static MiniDubboResponseWrapper of() {
        return new MiniDubboResponseWrapper();
    }

    public BlockingQueue<MiniDubboResponse> getResponseQueue() {
        return responseQueue;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }
}
