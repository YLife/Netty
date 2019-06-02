package com.netty.chapter2.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;


/**
 * @author yanglun
 * @description: child channel handler
 * @date 2018/12/30 22:47
 */
public class ChildChannelHandler extends ChannelInitializer<SocketChannel>{

    @Override
    protected void initChannel(SocketChannel arg0) throws Exception {
        arg0.pipeline().addLast(new TimeServerHadler());
    }
}
