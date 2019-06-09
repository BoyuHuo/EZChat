package service.imp;
import entity.User;
import service.UserService;

public class UserServiceImp implements UserService {
    public User signIn(String username, String password) {
        //TODO: add user check logic  : An Hengyang

        return new User(username);

    }

    public Boolean signUp(User user) {
        //TODO: add user signUp logic : An Hengyang
        return null;
    }
}
