package service.imp;

import entity.ChattingRoom;
import entity.User;
import mappers.UserDataFunction;
import service.UserService;

import java.util.List;

public class UserServiceImp implements UserService {
    UserDataFunction userDataFunction = new UserDataFunction();

    public User signIn(String account, String password) {
        if ("".equals(account) || account == null || "".equals(password) || password == null) {
            return null;
        }
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        return userDataFunction.checkUser(user);
    }



    public Boolean signUp(User user) {
        //TODO: add user signUp logic : An Hengyang

        return null;
    }

    public User updateUserInfo(User user) {
        //TODO: update user info : An Hengyang

        return null;
    }



}
