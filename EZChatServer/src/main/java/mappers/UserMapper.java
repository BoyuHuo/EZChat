package mappers;

import entity.Message;
import entity.User;

import java.util.List;

public interface UserMapper {
	
	User checkUser(User user);
	
	void insertUser(User user);

    void updateUser(User user);
    
    void deleteUserByID(int id);

    List<Message> selectMessage(String roomID);
}
