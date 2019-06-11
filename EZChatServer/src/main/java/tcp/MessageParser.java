package tcp;

import entity.User;
import service.ServerService;
import service.UserService;
import service.imp.ServerServiceImp;
import service.imp.UserServiceImp;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class MessageParser {

    private ServerThread serverThread;
    private PrintWriter out;  //To client
    private BufferedReader in;  //From client
    private String name;
    int firstFlag = 0;


    private ServerService serverService = new ServerServiceImp();
    private UserService userService = new UserServiceImp();


    public MessageParser(PrintWriter out, BufferedReader in, ServerThread serverThread) {
        this.out = out;
        this.in = in;
        this.serverThread = serverThread;
    }


    public enum Instruction {
        message, signin, userlist, messagelist, signup;

        public static Instruction getInstruction(String instruction) {
            return valueOf(instruction.toLowerCase());
        }
    }

    public void parseMessage(String msg) {
        String[] tempMsg = msg.split("@");
        if (tempMsg.length >= 3) {
            switch (Instruction.getInstruction(tempMsg[1])) {
                case message:
                    serverService.pushMessage(name, tempMsg[2]);
                    System.out.println(name + ":" + tempMsg[2]);
                    break;
                case signin:
                    userValidedProcess(tempMsg);
                    break;
                case signup:
                    userSignupProcess(tempMsg);
                    break;
                case userlist:
                    out.println(serverService.listOnlineUsers());
                    break;
                case messagelist:
                    out.println(serverService.listmassage());
                    break;
                default:
                    break;
            }
        } else {
            System.out.println(tempMsg.length);
        }
    }


    public void userValidedProcess(String[] tempMsg) {
        String[] userCredential = tempMsg[2].split("%");
        User user = userService.signIn(userCredential[0], userCredential[1]);
        if (user != null) {
            name = user.getUsername();
            TcpServer.user_list.add(name);
            TcpServer.thread_list.add(serverThread);
            out.println("@signin@yes@" + user.toString());
            out.println("Hi, " + name + ", Welcome back!");
            System.out.println(name + " has signed in!");
            serverService.pushMessage(name, " join the chatting room");
        } else {
            out.println("@signin@no");
        }
    }

    public void userSignupProcess(String[] tempMsg) {
        String[] userInfo = tempMsg[2].split(",");
        User user = new User(userInfo[0], userInfo[1], userInfo[2], userInfo[3], userInfo[4], userInfo[5].replace("*", "@"));
        Boolean result = userService.signUp(user);
        String resultStr = result?"yes":"no";
        out.println("@signup@"+resultStr);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
