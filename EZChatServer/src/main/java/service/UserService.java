package service;

import entity.ChattingRoom;
import entity.Message;
import entity.User;

import java.util.List;

public interface UserService {
    User signIn(String username, String password);
    Boolean signUp(User user);
    User updateUserInfo(User user);

}
