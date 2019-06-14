package service;

import entity.ChattingRoom;
import entity.Message;
import entity.User;

public interface MessageService {
    void sendMessage(Message message);
}
