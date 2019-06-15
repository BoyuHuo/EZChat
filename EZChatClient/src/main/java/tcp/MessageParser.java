package tcp;

import controller.ModifyInformationController;
import controller.SelfPageController;
import entity.ChatManager;
import entity.ChattingRoom;
import entity.Message;
import entity.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import service.RoomService;
import service.UserService;

import service.imp.RoomServiceImp;
import service.imp.UserServiceImp;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MessageParser {

    private UserService userService = new UserServiceImp();


    public class Main extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("view/log.fxml"));
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root, 800, 500));
            primaryStage.show();
        }

        public void main(String[] args) {
            launch(args);
        }
    }

    public MessageParser() {
    }

    public MessageParser(PrintWriter out, BufferedReader in) {
    }

    public enum Instruction {
        message, signin,signup,createroom,joinroom, signout,userlist, userupdate;

        public static Instruction getInstruction(String instruction) {
            return valueOf(instruction.toLowerCase());
        }
    }

    public void parseMessage(String msg) {
        String[] tempMsg = msg.split("@");
        if (tempMsg.length >= 2) {
            switch (Instruction.getInstruction(tempMsg[1])) {
                case message:
                    Message message = new Message();
                    message.setRoom_id( tempMsg[3]);
                    message.setUser_name( tempMsg[5]);
                    message.setMessage(tempMsg[6]);

                    ChatManager.getInstance().setMessage(  ChatManager.getInstance().getMessage()+tempMsg[5]+": "+tempMsg[6] +"\n");
                    break;
                case signin:
                    signInProcess(tempMsg);
                    break;
                case signup:
                    signUpProcess(tempMsg);
                    break;
                case createroom:
                    createRoomProcess(tempMsg);
                    break;
                case joinroom:
                    joinRoomProcess(tempMsg);
                    break;
                case signout:
                    break;
                case userlist:
                    userlistProcess(tempMsg);
                    break;
                case userupdate:
                    if(tempMsg[2].equals("no")){
                        UserServiceImp.setUpdateFlag(1);
                    }
                    else{
                        String[] userInfo = tempMsg[3].split(",");
                        User user = new User(userInfo[0],userInfo[1],userInfo[2],userInfo[3],userInfo[4],userInfo[5].replace("*","@"));
                        SelfPageController.user = user;
                        ModifyInformationController.user = user;
                        UserServiceImp.setUpdateFlag(2);
                    }
                    break;
                default:
                    System.out.println("Unknow header!");
                    break;
            }
        } else {
            System.out.println("server says:" + msg);
        }
    }

    public void signInProcess(String[] tempMsg){
        if (tempMsg[2].equals("no")) {
            UserServiceImp.setLoginFlag(1);
        } else {
            UserServiceImp.setLoginFlag(2);
            String[] userInfo = tempMsg[3].split(",");
            User user = new User(userInfo[0],userInfo[1],userInfo[2],userInfo[3],userInfo[4],userInfo[5].replace("*","@"));
            SelfPageController.user = user;
        }
    }
    public void signUpProcess(String[] tempMsg){
        if(tempMsg[2].equals("no")){
            UserServiceImp.setSignupFlag(1);
        } else {
            UserServiceImp.setSignupFlag(2);
        }
    }
    public void createRoomProcess(String[] tempMsg){
        if(tempMsg[2].equals("no")){
            RoomServiceImp.setCreateRoomFlag(1);
        }else {

            String[] roomInfo = tempMsg[3].split(",");
            ChattingRoom chattingRoom = new ChattingRoom(roomInfo[1],roomInfo[2]);
            chattingRoom.setId(Integer.parseInt(roomInfo[0]));
            RoomServiceImp.room = chattingRoom;

            RoomServiceImp.setCreateRoomFlag(2);
        }

    }
    public void joinRoomProcess(String[] tempMsg){
        if(tempMsg[2].equals("no")){
            RoomServiceImp.setJoinRoomFlag(1);
        }else {
            String[] rooInfo = tempMsg[3].split(",");
            ChattingRoom chattingRoom = new ChattingRoom(rooInfo[1],rooInfo[2]);
            chattingRoom.setId(Integer.parseInt(rooInfo[0]));
            RoomServiceImp.room = chattingRoom;

            RoomServiceImp.setJoinRoomFlag(2);
        }
    }

    public void userlistProcess(String[] tempMsg){
        String[] userlistInfo = tempMsg[6].split(",");
        ArrayList<String> userlist = new ArrayList<>();
        for(int i=0;i<userlistInfo.length;i++){
            if(!"".equals(userlistInfo[i])&&userlistInfo[i]!=null){
                userlist.add(userlistInfo[i]);
            }
        }
        ChatManager.getInstance().setUsers(userlist);
    }

}
