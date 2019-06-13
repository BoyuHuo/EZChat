package service.imp;

import entity.User;
import service.UserService;
import tcp.MessageEncoder;

public class UserServiceImp implements UserService {
    public static User user = null;

    private static int loginFlag = 0; //0 pending, 1 fail, 2 success
    private static int signupFlag = 0; //0 pending, 1 fail, 2 success


    MessageEncoder messageEncoder = new MessageEncoder();


    public void checkUser(String account, String password) {
        setLoginFlag(0);
        messageEncoder.encodeMessage(account + "%" + password, "signin");
    }

    public void registerUser(User user) {
        setSignupFlag(0);
        messageEncoder.encodeMessage(user.toString(), "signup");
    }


    public synchronized static int getLoginFlag() {
        return loginFlag;
    }

    public synchronized static void setLoginFlag(int loginFlag) {
        UserServiceImp.loginFlag = loginFlag;
    }

    public synchronized static int getSignupFlag() {
        return signupFlag;
    }

    public synchronized static void setSignupFlag(int signupFlag) {
        UserServiceImp.signupFlag = signupFlag;
    }

}
