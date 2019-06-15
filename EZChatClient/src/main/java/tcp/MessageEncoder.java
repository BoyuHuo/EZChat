package tcp;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageEncoder {

    ResponseThread responseThread;

    public static PrintWriter out;



    public MessageEncoder() {
    }

    public MessageEncoder(PrintWriter out) {
        this.out = out;
    }

    public enum Instruction {
        message, signin, signout,signup,createroom,joinroom,userlist,messagelist,userupdate;

        public static MessageEncoder.Instruction getInstruction(String instruction) {
            return valueOf(instruction.toLowerCase());
        }
    }

    public void encodeMessage(String msg, String operation) {
        switch (MessageEncoder.Instruction.getInstruction(operation)) {
            case signin:
                out.println("@signin@"+msg);
                break;
            case message:
                out.println("@message@"+msg);
                break;
            case signup:
                out.println("@signup@"+msg);
                break;
            case signout:
                out.println("@bye@1");
                break;
            case createroom:
                out.println("@createroom@"+msg);
                break;
            case joinroom:
                out.println("@joinroom@"+msg);
                break;
            case userlist:
                out.println("@userlist@"+msg);
                break;
            case messagelist:
                out.println("@messagelist@"+msg);
                break;
            case userupdate:
                out.println("@userupdate@"+msg);
                break;

        }

    }
}
