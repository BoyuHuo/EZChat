package service;


import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import entity.Message;


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

    /**
     * 监听是否有消息在队列里的线程类,向除自己之外的客户端发送消息
     */

    class PrintOutThread extends Thread {

        public PrintOutThread() {
            start();
        }

        @Override
        public void run() {
            while (true) {
                //如果消息队列没有消息则暂停当前线程，把cpu片段让出给其他线程,提高性能
                if (!isPrint) {
                    try {
                        Thread.sleep(500);
                        sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    continue;
                }
                // 将缓存在队列中的消息按顺序发送到各客户端，并从队列中清除。
                Message message = (Message) message_list.getFirst();
                // 对所有的用户的线程遍历，如果不是自己发的消息就广播给其他人
                for (int i = 0; i < thread_list.size(); i++) {
                    // 由于添加线程和用户是一起的，所以i所对应的用户就是i所对应的线程，可以根据这个判断是不是自己的线程
                    ServerThread thread = thread_list.get(i);
                    if (message.getName() != user_list.get(i)) {
                        thread.sendMessage(message);
                    }
                }
                message_list.removeFirst();
                isPrint = message_list.size() > 0 ? true : false;

            }
        }
    }



}



