package service;

import entity.User;

public interface UserService {
    void checkUser(String email, String password);
    void registerUser(User user);
    void updateUser(User user);

}
