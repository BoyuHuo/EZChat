package tcp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import service.UserService;

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
        message, signin, signout;

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
                        System.out.println(tempMsg[2]);
                    } else {
                        System.out.println(tempMsg[2]);
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
