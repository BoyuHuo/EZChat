package tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class testTcpClient extends Socket {


    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 5566;

    public static Socket client;
    public static PrintWriter out;
    public static BufferedReader in;

    /**
     * 与服务器连接，并输入发送消息
     */
    public testTcpClient() throws Exception {
        super(SERVER_IP, SERVER_PORT);
        client = this;
        out = new PrintWriter(this.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(this.getInputStream()));
        new ResponseThread();
        out.println("我已经连接服务器");
        while (true) {
            in = new BufferedReader(new InputStreamReader(System.in));
            String input = in.readLine();
            out.println(input);
        }
    }



}


