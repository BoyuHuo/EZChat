package tcp;

import entity.Message;
import service.ServerService;
import service.imp.ServerServiceImp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class ServerThread extends Thread{


    private Socket client;

    private PrintWriter out;  //To client

    private BufferedReader in;  //From client

    private String name;

    private MessageParser messageParser;

    private ServerService serverService = new ServerServiceImp();



    public ServerThread(Socket s) throws IOException {
        client = s;
        out = new PrintWriter(client.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(
                client.getInputStream()));
        in.readLine();

        messageParser = new MessageParser(out,in,this);

        start();
    }

    @Override
    public void run() {

        out.println("Server connected!");
        System.out.println("New Client connected! IP:"+ client.getInetAddress()+" at " + new Date().toString());

        try {

            String line = in.readLine();
            while (!line.contains("@bye@")) {
                messageParser.parseMessage(line);
                line = in.readLine();
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
            serverService.pushMessage(name, " leave the chatting room!");
        }
    }


    // 向客户端发送一条消息
    public void sendMessage(Message message) {
        out.println(message.getName() + ":" + message.getMessage());
    }


}
