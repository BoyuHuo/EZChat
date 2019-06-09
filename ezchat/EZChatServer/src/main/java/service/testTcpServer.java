package service;


import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import entity.Message;
import service.imp.PrintOutThread;
import service.imp.ServerThread;


public class testTcpServer extends ServerSocket {

    private static final int SERVER_PORT = 5566;
    public static boolean isPrint = false;
    public static List<String> user_list = new ArrayList<String>();// the collection of sign-in users
    public static List<ServerThread> thread_list = new ArrayList<ServerThread>();// 服务器已启用线程集合
    public static LinkedList<Message> message_list = new LinkedList<Message>();// 存放用户消息的队列

    /**
     * 创建服务端Socket,创建向客户端发送消息线程,监听客户端请求并处理
     */
    public testTcpServer() throws IOException {
        super(SERVER_PORT);// 创建ServerSocket
        new PrintOutThread();// 处理所有客户端发送的消息
        System.out.println("服务器已启动");
        try {
            while (true) {// 监听客户端请求，启个线程处理
                Socket socket = accept();
                new ServerThread(socket);
            }
        } catch (Exception e) {
        } finally {
            close();
        }
    }



}



