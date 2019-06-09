package mappers;

import java.util.List;

import entity.User;

public interface UserMapper {
	
	User selectUserByID(int id);
    
    List<User> findUserByName(String username);
	
	void insert(User user);

    void updateByPrimaryKey(User user);
    
    void deleteUserByID(int id);
}
