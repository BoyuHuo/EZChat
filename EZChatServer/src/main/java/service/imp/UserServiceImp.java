package service.imp;

import entity.User;
import mappers.UserDataFunction;
import service.UserService;

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
}
