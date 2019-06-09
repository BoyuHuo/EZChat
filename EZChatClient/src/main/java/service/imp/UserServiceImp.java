package service.imp;

import entity.User;
import service.UserService;
import tcp.MessageEncoder;

public class UserServiceImp implements UserService {
    public static User user = null;
    public static int loginFlag = 0;


    MessageEncoder messageEncoder = new MessageEncoder();
    public void checkUser(String email, String password) {
        messageEncoder.encodeMessage("","");
    }
}
