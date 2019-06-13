package service;

import entity.Message;

public interface MessageService {
    void saveMessage(Message message);
    Message getMessage(String id);
}
