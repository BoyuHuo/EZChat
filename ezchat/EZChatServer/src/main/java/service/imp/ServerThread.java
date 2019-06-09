package service.imp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import entity.Message;
import service.testTcpServer;

public class ServerThread extends Thread{


    private Socket client;

    private PrintWriter out;

    private BufferedReader in;

    private String name;

    public ServerThread(Socket s) throws IOException {
        client = s;
        out = new PrintWriter(client.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(
                client.getInputStream()));
        in.readLine();

        start();
    }

    @Override
    public void run() {
        out.println("成功连上聊天室,请输入你的名字：");
        System.out.println(getName());
        try {
            int flag = 0;
            String line = in.readLine();
            while (!"byeClient".equals(line)) {

                // 查看在线用户列表
                if ("showuser".equals(line)) {
                    out.println(this.listOnlineUsers());
                    line = in.readLine();
                }
                if ("showmessage".equals(line)) {
                    out.println(this.listmassage());
                    line = in.readLine();
                }

                // 第一次进入，保存名字
                if (flag == 0) {
                    name = line;
                    testTcpServer.user_list.add(name);
                    testTcpServer.thread_list.add(this);
                    out.println(name + "你好,可以开始聊天了...");
                    System.out.println(name + "连接服务器");
                    pushMessage(name, "进入聊天室");
                } else {
                    pushMessage(name, line);
                }
                flag++;
                line = in.readLine();
                System.out.println(name + ":" + line);
            }
            out.println("byeClient");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {// 用户退出聊天室
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            testTcpServer.thread_list.remove(this);
            testTcpServer.user_list.remove(name);
            pushMessage(name, "退出了聊天室");
        }
    }

    // 放入消息队列末尾，准备发送给客户端
    public void pushMessage(String name, String msg) {
        Message message = new Message(name, msg);
        // 放入用户信息
        testTcpServer.message_list.addLast(message);
        // 表示可以向其他用户发送消息
        testTcpServer.isPrint = true;
    }

    // 向客户端发送一条消息
    public void sendMessage(Message message) {
        out.println(message.getName() + ":" + message.getMessage());
    }

    private String listOnlineUsers() {
        String s = "--- Online User list ---\015\012";
        for (int i = 0; i < testTcpServer.user_list.size(); i++) {
            s += "[" + testTcpServer.user_list.get(i) + "]\015\012";
        }
        s += "--------------------";
        return s;
    }


    private String listmassage() {
        String s = "--- Message list ---\015\012";
        for (int i = 0; i < testTcpServer.message_list.size(); i++) {
            s += "[" + testTcpServer.message_list.get(i) + "]\015\012";
        }
        s += "--------------------";
        return s;
    }
}
