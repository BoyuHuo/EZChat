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

            Message message = TcpServer.message_list.getFirst();
            for (int i = 0; i < TcpServer.room_map.get(""+message.getRoom_id()).size(); i++) {

                ServerThread thread = TcpServer.room_map.get(""+message.getRoom_id()).get(i);
                    thread.sendMessage(message);
            }
            TcpServer.message_list.removeFirst();
            TcpServer.isPrint = TcpServer.message_list.size() > 0 ? true : false;

        }
    }

}
