package com.netty.chapter5;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author yanglun
 * @description: test user info
 * @date 2019/1/3 23:11
 */
public class TestUserInfo {

    public static void main(String[] args) throws IOException {
        UserInfo userInfo = new UserInfo("Welcome to netty", 100);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bos);
        os.writeObject(userInfo);
        os.flush();
        os.close();
        byte[] b = bos.toByteArray();
        System.out.println("The jdk serializable length is : " + b.length);
        b.clone();
        System.out.println("------------------------");
        System.out.println("The byte array serializable length is : "
                + userInfo.codeC().length);
    }
}
