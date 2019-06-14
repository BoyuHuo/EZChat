package service.imp;

import entity.Message;
import service.ServerService;
import tcp.TcpServer;

public class ServerServiceImp implements ServerService {

    public String listOnlineUsers() {
        String s = "--- Online User list ---\015\012";
        for (int i = 0; i < TcpServer.user_list.size(); i++) {
            s += "[" + TcpServer.user_list.get(i) + "]\015\012";
        }
        s += "--------------------";
        return s;
    }


    public String listmassage() {
        String s = "--- Message list ---\015\012";
        for (int i = 0; i < TcpServer.message_list.size(); i++) {
            s += "[" + TcpServer.message_list.get(i) + "]\015\012";
        }
        s += "--------------------";
        return s;
    }



    // 放入消息队列末尾，准备发送给客户端
    public void pushMessage(String roomId,String name, String msg, int type) {
        if(type==0) {
            Message message = new Message(name, msg);
            message.setRoom_id(Integer.parseInt(roomId));

            TcpServer.message_list.addLast(message);

            TcpServer.isPrint = true;
        }else if(type==1){
            Message message = new Message(name, msg);
            message.setRoom_id(Integer.parseInt(roomId));
            message.setUser_name("userlist");

            // 放入用户信息
            TcpServer.message_list.addLast(message);
            // 表示可以向其他用户发送消息
            TcpServer.isPrint = true;
        }
    }
}
