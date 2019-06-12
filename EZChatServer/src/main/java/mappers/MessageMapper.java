package mappers;

import entity.Message;

import java.util.List;

public interface MessageMapper {

    void insertMessage(Message msg);
    List<Message> selectMessage(String id);
    void updateMessage(Message msg);

}
