package service;

public interface ServerService {
    String listOnlineUsers();
    String listmassage();
    void pushMessage(String name, String msg);
}
