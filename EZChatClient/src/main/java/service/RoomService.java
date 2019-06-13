package service;

import tcp.MessageEncoder;

public interface RoomService {

    public void creatRoom(String roomName);
    public void joinRoom(String token);
}
