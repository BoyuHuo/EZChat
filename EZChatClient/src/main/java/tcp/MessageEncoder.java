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
        message, signin, signout,signup;

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
            case signout:
                out.println("@bye@1");
        }

    }
}
