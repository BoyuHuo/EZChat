package mappers;

import entity.*;
import java.util.List;


public interface ChatRoomMapper {

    void insertRoom(ChattingRoom chatroom);
    List<ChattingRoom> selectRoom(String userID);
}
