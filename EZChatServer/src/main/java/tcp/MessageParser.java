package tcp;

import entity.Message;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class MessageParser {

    private PrintWriter out;  //To client
    private BufferedReader in;  //From client
    private String name;

    public MessageParser(PrintWriter out, BufferedReader in) {
        this.out = out;
        this.in = in;
    }


    public enum Instruction {
        message, signin, signout, userlist, messagelist;

        public static Instruction getInstruction(String instruction) {
            return valueOf(instruction.toLowerCase());
        }
    }

    public void parseMessage(String msg) {
        String[] tempMsg = msg.split("@");
        if (tempMsg.length >= 3) {
            switch (Instruction.getInstruction(tempMsg[1])) {
                case message:
                    pushMessage(name, tempMsg[2]);
                    break;
                case signin:
                    break;
                case signout:
                    break;
                case userlist:
                    out.println(this.listOnlineUsers());
                    break;
                case messagelist:
                    out.println(this.listmassage());
                    break;
                default:
                    break;
            }
        } else {
            System.out.println(tempMsg.length);
        }
    }


    private String listOnlineUsers() {
        String s = "--- Online User list ---\015\012";
        for (int i = 0; i < TcpServer.user_list.size(); i++) {
            s += "[" + TcpServer.user_list.get(i) + "]\015\012";
        }
        s += "--------------------";
        return s;
    }


    private String listmassage() {
        String s = "--- Message list ---\015\012";
        for (int i = 0; i < TcpServer.message_list.size(); i++) {
            s += "[" + TcpServer.message_list.get(i) + "]\015\012";
        }
        s += "--------------------";
        return s;
    }

    // 放入消息队列末尾，准备发送给客户端
    public void pushMessage(String name, String msg) {
        Message message = new Message(name, msg);
        // 放入用户信息
        TcpServer.message_list.addLast(message);
        // 表示可以向其他用户发送消息
        TcpServer.isPrint = true;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
