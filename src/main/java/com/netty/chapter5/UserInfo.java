package com.netty.chapter5;

import java.io.Serializable;
import java.nio.ByteBuffer;

/**
 * @author yanglun
 * @description: user info
 * @date 2019/1/3 23:03
 */
public class UserInfo implements Serializable {


    private static final long serialVersionUID = -8084079097933094362L;
    private String userName;
    private int userId;

    public UserInfo(String userName, int userId) {
        this.userName = userName;
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public byte[] codeC() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        byte[] value = this.userName.getBytes();
        buffer.putInt(value.length);
        buffer.put(value);
        buffer.putInt(this.userId);
        buffer.flip();
        value = null;
        byte[] result = new byte[buffer.remaining()];
        buffer.get(result);
        return result;
    }
}
