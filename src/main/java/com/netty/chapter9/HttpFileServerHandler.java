package com.netty.chapter9;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

import static io.netty.handler.codec.http.HttpMethod.GET;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * @author yanglun
 * @description: http file server handler
 * @date 2019/1/6 13:45
 */
public class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {


    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) throws Exception {
        if (!fullHttpRequest.getDecoderResult().isSuccess()) {
            // wait
            return;
        }
        if (fullHttpRequest.getMethod() != GET) {
            // wait
            return;
        }
        final String uri = fullHttpRequest.getUri();
        final String path = null;
        if (path == null) {
            // wait
            return;
        }
        File file = new File(path);
        if (file.isHidden() || !file.exists()) {
            // wait
            return;
        }
        // 此处胆码省略
        if (!file.isFile()) {
            // wait
            return;
        }
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");// 以只读的方式打开文件
        } catch (FileNotFoundException e) {
            // wait
            return;
        }
        long fileLength = randomAccessFile.length();
        HttpResponse response = new DefaultHttpResponse(HTTP_1_1, OK);

    }


}
