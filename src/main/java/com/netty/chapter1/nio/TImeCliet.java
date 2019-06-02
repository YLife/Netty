package com.netty.chapter1.nio;

/**
 * @author yanglun
 * @description: time client
 * @date 2018/12/30 0:03
 */
public class TImeCliet {

    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                // use default value
            }
        }
        new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-001")
                .start();
    }
}
