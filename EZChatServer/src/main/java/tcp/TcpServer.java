package tcp;


import entity.Message;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class TcpServer extends ServerSocket {

    private static final int SERVER_PORT = 5566;
    public static boolean isPrint = false;
    public static List<String> user_list = new ArrayList<String>();// the collection of sign-in users
    public static List<ServerThread> thread_list = new ArrayList<ServerThread>();
    public static HashMap<String,List<String>> room_user_list = new HashMap<>();
    public static HashMap<String,List<ServerThread>> room_map = new HashMap<>();
    public static LinkedList<Message> message_list = new LinkedList<Message>();

    /**
     * create server socket, create thread for sending the message to client, monitoring the request
     */
    public TcpServer() throws IOException {
        super(SERVER_PORT);// 创建ServerSocket
        new PrintOutThread();// 处理所有客户端发送的消息
        System.out.println("Server Started!");
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

    public static String getUserListByRoom(String roomId){
        String result = "";
        if(room_user_list.get(roomId)!=null){
            for(String user: room_user_list.get(roomId)){
                result+=user+",";
            }
        }
        return result;
    }



}



