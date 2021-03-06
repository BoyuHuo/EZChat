package mappers;

import entity.*;
import sun.util.resources.cldr.ga.CurrencyNames_ga;

import java.util.List;


public interface ChatRoomMapper {

    int insertRoom(ChattingRoom chatroom);
    ChattingRoom selectRoomByToken(String token);
    List<Message> selectAllMessage(ChattingRoom room);

    //List<ChattingRoom> selectRoom(String userID);
}
