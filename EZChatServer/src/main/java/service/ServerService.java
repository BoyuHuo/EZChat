package service;

public interface ServerService {
    String listOnlineUsers();
    String listmassage();
    void pushMessage(String roomId,String name, String msg, int type);
}
