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
        message, signin, signout;

        public static MessageEncoder.Instruction getInstruction(String instruction) {
            return valueOf(instruction.toLowerCase());
        }
    }

    public void encodeMessage(String msg, String operation) {
        //TODO: impementation : blue

        switch (MessageEncoder.Instruction.getInstruction(operation)) {
            case signin:
                out.println("@signin@"+msg);
                break;
        }

    }
}
