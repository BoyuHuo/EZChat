package tcp;

import entity.Message;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class MessageParser {

    private PrintWriter out;  //To client
    private BufferedReader in;  //From client

    public MessageParser(PrintWriter out, BufferedReader in){
        this.out = out;
        this.in = in;
    }
    public enum Instruction {
        message, signin, signout, userlist, messagelist;

        public static Instruction getInstruction(String instruction) {
            return valueOf(instruction.toLowerCase());
        }
    }

    public static void parseMessage(String msg) {
        String[] tempMsg = msg.split("@");
        if (tempMsg.length >= 3) {
            switch (Instruction.getInstruction(tempMsg[1])) {
                case message: break;
                case signin: break;
                case signout: break;
                case userlist: break;
                case messagelist: break;
                default:break;
            }
        } else {
            System.out.println(tempMsg.length);
        }
    }
}
