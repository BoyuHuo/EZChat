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

    //checkUser 方法似乎并没有放回null,有点问题
    //

    public Boolean signUp(User user) {
        //TODO: add user signUp logic : An Hengyang
        if(user!=null) {
            if(userDataFunction.checkUser(user)==null) {
                userDataFunction.addtUser(user);
                return true;
            }
            else
            return false;
        }
        else System.out.println("Please Check The Information Provided");
        return false;
    }

    public User updateUserInfo(User user) {
        //TODO: update user info : An Hengyang
        if(user!=null) {
            if(userDataFunction.checkUser(user)!=null) {
                userDataFunction.updateUser(user);
                System.out.println("Update Successfully");
                return user;
            }
            else return null;
        }
        else return null;
    }



}
