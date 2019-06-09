package service.imp;

import service.UserService;
import tcp.MessageEncoder;

public class UserServiceImp implements UserService {
    MessageEncoder messageEncoder = new MessageEncoder();
    public void checkUser(String email, String password) {
        messageEncoder.messageEncoder("email%password","signin");
    }
}
