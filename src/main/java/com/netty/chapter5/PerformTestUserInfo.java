package com.netty.chapter5;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

/**
 * @author yanglun
 * @description: perform test user info
 * @date 2019/1/3 23:26
 */
public class PerformTestUserInfo {

    public static void main(String[] args) throws IOException {
        UserInfo userInfo = new UserInfo("Welcome to netty", 100);
        int loop = 1000000;
        ByteArrayOutputStream  bos;
        ObjectOutputStream os;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(userInfo);
            os.close();
            byte[] b = bos.toByteArray();
            bos.close();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("The jdk serializable cost time is : "
                + (endTime - startTime) + "ms");
        System.out.println("--------------------");
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            byte[] b = userInfo.codeC();
        }
        endTime = System.currentTimeMillis();
        System.out.println("The byte array serializable cost time is : "
                + (endTime - startTime) + "ms");
    }
}
