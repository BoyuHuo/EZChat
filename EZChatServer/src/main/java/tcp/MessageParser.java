package tcp;

import entity.ChattingRoom;
import entity.Message;
import entity.User;
import service.ChattingRoomService;
import service.MessageService;
import service.ServerService;
import service.UserService;
import service.imp.ChattingRoomServiceImp;
import service.imp.MessageServiceImp;
import service.imp.ServerServiceImp;
import service.imp.UserServiceImp;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MessageParser {

    private ServerThread serverThread;
    private PrintWriter out;  //To client
    private BufferedReader in;  //From client
    private String name;
    int firstFlag = 0;


    private ServerService serverService = new ServerServiceImp();
    private UserService userService = new UserServiceImp();
    private ChattingRoomService chattingRoomService = new ChattingRoomServiceImp();
    private MessageService messageService = new MessageServiceImp();


    public MessageParser(PrintWriter out, BufferedReader in, ServerThread serverThread) {
        this.out = out;
        this.in = in;
        this.serverThread = serverThread;
    }


    public enum Instruction {
        message, signin, userlist, messagelist, signup, createroom, joinroom, history,userupdate;

        public static Instruction getInstruction(String instruction) {
            return valueOf(instruction.toLowerCase());
        }
    }

    public void parseMessage(String msg) {
        String[] tempMsg = msg.split("@");
        if (tempMsg.length >= 3) {
            switch (Instruction.getInstruction(tempMsg[1])) {
                case message:
                    Message message = new Message();
                    message.setRoom_id(Integer.parseInt(tempMsg[3]));
                    message.setUser_id(Integer.parseInt(tempMsg[4]));
                    message.setUser_name(name);
                    message.setMessage(tempMsg[6]);
                    messageService.saveMessage(message);

                    serverService.pushMessage(message);

                    break;
                case signin:
                    userValidedProcess(tempMsg);
                    break;
                case signup:
                    userSignupProcess(tempMsg);
                    break;
                case userlist:
                    out.println(serverService.listOnlineUsers());
                    break;
                case messagelist:
                    out.println(serverService.listmassage());
                    break;
                case createroom:
                    createChattingRoomProcess(tempMsg);
                    break;
                case joinroom:
                    joinChattingRoomProcess(tempMsg);
                    break;
                case history:
                    break;
                case userupdate:
                    uesrUpdateProcess(tempMsg);
                    break;
                default:
                    break;
            }
        } else {
            System.out.println(tempMsg.length);
        }
    }


    public void userValidedProcess(String[] tempMsg) {
        String[] userCredential = tempMsg[2].split("%");
        User user = userService.signIn(userCredential[0], userCredential[1]);
        if (user != null) {
            name = user.getUsername();
            TcpServer.user_list.add(name);
            TcpServer.thread_list.add(serverThread);
            out.println("@signin@yes@" + user.toString());
            out.println("Hi, " + name + ", Welcome back!");
            System.out.println(name + " has signed in!");

        } else {
            out.println("@signin@no");
        }
    }

    public void userSignupProcess(String[] tempMsg) {
        String[] userInfo = tempMsg[2].split(",");
        User user = new User(userInfo[0], userInfo[1], userInfo[2], userInfo[3], userInfo[4], userInfo[5].replace("*", "@"));
        Boolean result = userService.signUp(user);
        String resultStr = result ? "yes" : "no";
        out.println("@signup@" + resultStr);
    }

    public void createChattingRoomProcess(String[] tempMsg){
        String roomName= tempMsg[2];
        ChattingRoom chattingRoom = chattingRoomService.createChattingRoom(roomName);
        if(chattingRoom!=null){
            out.println("@createRoom@yes@"+chattingRoom.toString());
        }else{
            out.println("@createRoom@no");
        }
    }
    public void joinChattingRoomProcess(String[] tempMsg){
        ChattingRoom chattingRoom = chattingRoomService.joinChattingRoom(tempMsg[2]);

        if(TcpServer.room_map.get(""+chattingRoom.getId())==null){
            TcpServer.room_map.put(""+chattingRoom.getId(),new ArrayList<>());
        }
        if(TcpServer.room_user_list.get(""+chattingRoom.getId())==null){
            TcpServer.room_user_list.put(""+chattingRoom.getId(),new ArrayList<>());
        }
        if(!TcpServer.room_map.get(""+chattingRoom.getId()).contains(serverThread)){
            serverThread.setRoomId(""+chattingRoom.getId());
            TcpServer.room_map.get(""+chattingRoom.getId()).add(serverThread);
        }
        if(!TcpServer.room_map.get(""+chattingRoom.getId()).contains(name)){
            TcpServer.room_user_list.get(""+chattingRoom.getId()).add(name);
        }

        if(chattingRoom!=null){
            out.println("@joinroom@yes@"+chattingRoom.toString());
            serverThread.setRoomId(tempMsg[2]);
            Message message = new Message();
            message.setRoom_id(chattingRoom.getId());
            message.setUser_name(name);
            message.setMessage("join the chatting room");
            serverService.pushMessage(message);

            Message message1 = new Message();
            message1.setRoom_id(chattingRoom.getId());
            message1.setUser_name(name);
            message1.setType_flag(1);
            message1.setMessage(TcpServer.getUserListByRoom(chattingRoom.getId()+""));

            serverService.pushMessage(message1);

        }else {
            out.println("@joinroom@no");
        }


    }

    public void uesrUpdateProcess(String[] tempMsg){
        String[] userInfo = tempMsg[2].split(",");
        User user = new User(userInfo[0], userInfo[1], userInfo[2], userInfo[3], userInfo[4], userInfo[5].replace("*", "@"));
        User result = userService.updateUserInfo(user);
        String resultStr = result==null ? "yes" : "no";
        if(resultStr.equals("yes")){
            out.println("@signup@" + resultStr+"@"+resultStr.toString());
        }else{
            out.println("@signup@" + resultStr);
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
