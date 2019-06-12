package mappers;

import entity.*;
import java.util.List;


public interface ChatRoomMapper {

    void insertRoom(ChattingRoom chatroom);
    ChattingRoom selectRoomByID(String id);
    List<Message> selectAllMessage(ChattingRoom room);

}
