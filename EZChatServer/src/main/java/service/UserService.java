package service;

import entity.ChattingRoom;
import entity.Message;
import entity.User;

import java.util.List;

public interface UserService {
    User signIn(String username, String password);
    Boolean signUp(User user);
    boolean updateUserInfo(User user);
    User getUser(String id);

}
