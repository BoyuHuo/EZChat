package service;

import entity.User;

public interface UserService {
    User signIn(String username, String password);
    Boolean signUp(User user);
    User updateUserInfo(User user);
}
