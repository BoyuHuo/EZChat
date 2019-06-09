package mappers;

import java.util.List;

import entity.User;

public interface UserMapper {
	
	User checkUser(User user);
	
	void insertUser(User user);

    void updateUser(User user);
    
    void deleteUserByID(int id);
}
