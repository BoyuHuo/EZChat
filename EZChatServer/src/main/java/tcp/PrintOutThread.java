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
            Message message = TcpServer.message_list.getFirst();
            // 对所有的用户的线程遍历，如果不是自己发的消息就广播给其他人
            System.out.println("里面的是"+ message.getRoom_id());
            for (int i = 0; i < TcpServer.room_map.get(""+message.getRoom_id()).size(); i++) {

                ServerThread thread = TcpServer.room_map.get(""+message.getRoom_id()).get(i);
                    thread.sendMessage(message);
            }
            TcpServer.message_list.removeFirst();
            TcpServer.isPrint = TcpServer.message_list.size() > 0 ? true : false;

        }
    }

}
