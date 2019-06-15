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

        if (user != null) {
            if (userDataFunction.checkUser(user) == null) {
                userDataFunction.addtUser(user);
                return true;
            } else
                return false;
        } else System.out.println("Please Check The Information Provided");
        return false;
    }

    public boolean updateUserInfo(User user) {
        return userDataFunction.updateUser(user);
    }

    @Override
    public User getUser(String id) {
        return userDataFunction.selectUserByID(id);
    }


}
