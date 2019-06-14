package service;

import entity.Message;

public interface ServerService {
    String listOnlineUsers();
    String listmassage();
    void pushMessage(Message message);
}
