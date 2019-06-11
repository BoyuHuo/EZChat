package service;

import entity.ChattingRoom;
import entity.Message;

import java.util.List;

public interface ChattingRoomService {
    ChattingRoom createChattingRoom(String roomName);
    String generateToken();
    List<ChattingRoom> getHistoryChattingRoomList(String userId);
    List<Message> getHistoryChattingHistory(String roomId);
    ChattingRoom joinChattingRoom(String token);
}
