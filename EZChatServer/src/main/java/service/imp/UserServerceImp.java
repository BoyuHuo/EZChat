package service.imp;


import entity.User;
import mappers.UserDataFunction;
import service.UserService;

public class UserServerceImp implements UserService {
    UserDataFunction userDataFunction = new UserDataFunction();

    public User signIn(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        return  userDataFunction.checkUser(user);
    }

    public Boolean signUp(User user) {
        return null;
    }
}
