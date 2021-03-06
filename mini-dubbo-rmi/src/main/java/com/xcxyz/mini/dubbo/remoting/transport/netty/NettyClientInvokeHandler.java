package com.xcxyz.mini.dubbo.remoting.transport.netty;

import com.xcxyz.mini.dubbo.model.MiniDubboResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author liuxiaocheng
 * @create 2021/6/1  3:27 下午
 */
public class NettyClientInvokeHandler extends SimpleChannelInboundHandler<MiniDubboResponse> {


    public NettyClientInvokeHandler() {
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MiniDubboResponse response) throws Exception {
        //将Netty异步返回的结果存入阻塞队列,以便调用端同步获取
        RevokerResponseHolder.putResultValue(response);
    }

}
