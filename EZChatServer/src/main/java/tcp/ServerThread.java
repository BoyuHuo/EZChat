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

    public String name;

    private String roomId;

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
            out.println("@byeClient@1");


        } catch (Exception e) {
            out.println("IP:"+client.getInetAddress()+"disconnected! bye!");
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            TcpServer.thread_list.remove(this);
            TcpServer.user_list.remove(name);
            if(TcpServer.room_user_list.get(roomId)!=null){
                TcpServer.room_user_list.get(roomId).remove(name);
            }
            if(TcpServer.room_map.get(roomId)!=null){
                TcpServer.room_map.get(roomId).remove(this);
            }
            Message message = new Message();
            if(roomId!=null){
                message.setRoom_id(Integer.parseInt(roomId));
            }
            message.setUser_name(name);
            message.setMessage(" leave the chatting room!");
            serverService.pushMessage(message);

            Message userlistMessage = new Message();
            if(roomId!=null){
                userlistMessage.setRoom_id(Integer.parseInt(roomId));
            }
            userlistMessage.setUser_name(name);
            userlistMessage.setType_flag(1);
            userlistMessage.setMessage(TcpServer.getUserListByRoom(roomId+""));

            serverService.pushMessage(userlistMessage);
        }
    }


    // 向客户端发送一条消息
    public void sendMessage(Message message) {
        if(message.getType_flag()==1){
            out.println("@userlist@"+message.toString());
        }
        else{
            out.println("@message@"+message.toString());
        }

    }


    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }


}
