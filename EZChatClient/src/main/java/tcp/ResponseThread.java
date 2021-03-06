package tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ResponseThread extends Thread {
    /**
     * 用于监听服务器端向客户端发送消息线程类
     */

    private BufferedReader buff;
    private MessageParser messageParser;

    public ResponseThread() {
        try {
            buff = new BufferedReader(new InputStreamReader(testTcpClient.client.getInputStream()));
            messageParser = new MessageParser();
            start();
        } catch (Exception e) {
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String result = buff.readLine();
                if (result.contains("@byeClient@")) {//客户端申请退出，服务端返回确认退出
                    break;
                } else {//输出服务端发送消息
                    messageParser.parseMessage(result);
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

