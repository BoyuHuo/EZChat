package tcp;

import entity.Message;

public class PrintOutThread extends Thread {

    /**
     * 监听是否有消息在队列里的线程类,向除自己之外的客户端发送消息
     */


    public PrintOutThread() {
        start();
    }

    @Override
    public void run() {
        while (true) {
            //如果消息队列没有消息则暂停当前线程，把cpu片段让出给其他线程,提高性能
            if (!TcpServer.isPrint) {
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
            Message message = (Message) TcpServer.message_list.getFirst();
            // 对所有的用户的线程遍历，如果不是自己发的消息就广播给其他人
            for (int i = 0; i < TcpServer.thread_list.size(); i++) {
                // 由于添加线程和用户是一起的，所以i所对应的用户就是i所对应的线程，可以根据这个判断是不是自己的线程
                ServerThread thread = TcpServer.thread_list.get(i);
                if (message.getName() != TcpServer.user_list.get(i)) {
                    thread.sendMessage(message);
                }
            }
            TcpServer.message_list.removeFirst();
            TcpServer.isPrint = TcpServer.message_list.size() > 0 ? true : false;

        }
    }

}
