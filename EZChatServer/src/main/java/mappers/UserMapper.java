package mappers;

import entity.User;

public interface UserMapper {
	
	User checkUser(User user);

	User selectUserByID(String id);
	
	void insertUser(User user);

    void updateUser(User user);
    
    void deleteUserByID(int id);
}
