package tcp;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageEncoder {

    ResponseThread responseThread;

    public static Socket client;
    public static PrintWriter out;
    public static BufferedReader in;


    public MessageEncoder(){};
    public MessageEncoder(PrintWriter out, BufferedReader in, ResponseThread responseThread) {

    }

    public void messageEncoder(String msg, String operation){
        //TODO: impementation : blue

    }

}
