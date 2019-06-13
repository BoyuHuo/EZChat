package tcp;

import controller.SelfPageController;
import entity.ChattingRoom;
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
        message, signin,signup,createroom,joinroom, signout;

        public static Instruction getInstruction(String instruction) {
            return valueOf(instruction.toLowerCase());
        }
    }

    public void parseMessage(String msg) {
        String[] tempMsg = msg.split("@");
        if (tempMsg.length >= 2) {
            switch (Instruction.getInstruction(tempMsg[1])) {
                case message:
                    System.out.println(tempMsg[2]);
                    break;
                case signin:
                    if (tempMsg[2].equals("no")) {
                        UserServiceImp.setLoginFlag(1);
                    } else {
                        UserServiceImp.setLoginFlag(2);
                        String[] userInfo = tempMsg[3].split(",");
                        User user = new User(userInfo[0],userInfo[1],userInfo[2],userInfo[3],userInfo[4],userInfo[5].replace("*","@"));
                        SelfPageController.user = user;
                    }
                    break;
                case signup:
                    if(tempMsg[2].equals("no")){
                        UserServiceImp.setSignupFlag(1);
                    } else {
                        UserServiceImp.setSignupFlag(2);
                    }
                    break;
                case createroom:
                    if(tempMsg[2].equals("no")){
                        RoomServiceImp.setCreateRoomFlag(1);
                    }else {

                        String[] roomInfo = tempMsg[3].split(",");
                        ChattingRoom chattingRoom = new ChattingRoom(roomInfo[1],roomInfo[2]);
                        chattingRoom.setId(Integer.parseInt(roomInfo[0]));
                        RoomServiceImp.room = chattingRoom;
                        System.out.println("sdfsdf"+tempMsg[3]);

                        RoomServiceImp.setCreateRoomFlag(2);
                    }
                    break;
                case joinroom:
                    if(tempMsg[2].equals("no")){
                        RoomServiceImp.setJoinRoomFlag(1);
                    }else {
                        RoomServiceImp.setJoinRoomFlag(2);
                    }
                    break;
                case signout:
                    break;
                default:
                    System.out.println("Unknow header!");
                    break;
            }
        } else {
            System.out.println("server says:" + msg);
        }
    }

}
