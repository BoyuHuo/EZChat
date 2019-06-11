package mappers;

import entity.Message;

public interface MessageMapper {

    void insertMessage(Message msg);
    Message selectMessage(String id);
    void updateMessage(Message msg);

}
