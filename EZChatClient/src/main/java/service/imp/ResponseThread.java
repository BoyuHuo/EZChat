package service.imp;

import service.testTcpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ResponseThread extends Thread {
    /**
     * 用于监听服务器端向客户端发送消息线程类
     */

    private BufferedReader buff;

    public ResponseThread() {
        try {
            buff = new BufferedReader(new InputStreamReader(testTcpClient.client.getInputStream()));
            start();
        } catch (Exception e) {
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String result = buff.readLine();
                if ("byeClient".equals(result)) {//客户端申请退出，服务端返回确认退出
                    break;
                } else {//输出服务端发送消息
                    System.out.println(result);
                }
            }
            testTcpClient.in.close();
            testTcpClient.out.close();
            testTcpClient.client.close();
        } catch (Exception e) {
        }
    }
}

