package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

import entity.Message;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class ServerThread extends Thread{


    private Socket client;

    private PrintWriter out;  //To client

    private BufferedReader in;  //From client

    private String name;

    private MessageParser messageParser;

    int firstFlag = 0;

    public ServerThread(Socket s) throws IOException {
        client = s;
        out = new PrintWriter(client.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(
                client.getInputStream()));
        in.readLine();

        messageParser = new MessageParser(out,in);

        start();
    }

    @Override
    public void run() {
        out.println("Server connected! \n Welcome back! \n Please sign in first! ");
        System.out.println("New Client connected! IP:"+ client.getInetAddress()+" at " + new Date().toString());
        try {
            String line = in.readLine();
            while (!"byeClient".equals(line)) {

                messageParser.parseMessage(line);

                line = in.readLine();

                // 第一次进入，保存名字
                if (firstFlag == 0) {
                    name = line;
                    messageParser.setName(name);
                    TcpServer.user_list.add(name);
                    TcpServer.thread_list.add(this);
                    out.println(name + "你好,可以开始聊天了...");
                    System.out.println(name + "连接服务器");
                    pushMessage(name, "进入聊天室");
                } else {
                    pushMessage(name, line);
                }
                firstFlag++;
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
            TcpServer.thread_list.remove(this);
            TcpServer.user_list.remove(name);
            pushMessage(name, "退出了聊天室");
        }
    }


    // 向客户端发送一条消息
    public void sendMessage(Message message) {
        out.println(message.getName() + ":" + message.getMessage());
    }


}
