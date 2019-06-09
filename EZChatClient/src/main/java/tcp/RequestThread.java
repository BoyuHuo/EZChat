package tcp;

import java.io.*;

public class RequestThread extends Thread{

    public PrintWriter out;

    public RequestThread() {
        try {
            out =  new PrintWriter(testTcpClient.client.getOutputStream(), true);
            start();
        } catch (Exception e) {
        }
    }

    @Override
    public void run() {
        out.println("我已经连接服务器");
        while (true) {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String input = null;
            try {
                input = in.readLine();
                out.println(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
