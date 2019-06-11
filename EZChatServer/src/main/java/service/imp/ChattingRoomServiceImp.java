package service.imp;

import entity.ChattingRoom;
import entity.Message;
import service.ChattingRoomService;

import java.util.List;

public class ChattingRoomServiceImp implements ChattingRoomService {
    public ChattingRoom createChattingRoom(String roomName) {
        // TODO: An hengyang

        // call generateToken -> new ChattingRoom -> fill up the fields in ChattingRoom (ps, name, token  (leave the id as null) ) -> store it in database ->return it
        return null;
    }

    public String generateToken() {
        //TODO: An hengyang
        return null;
    }
    public List<ChattingRoom> getHistoryChattingRoomList(String userId) {
        //TODO: An Hengyang
        // call liqing's function to get the Roomlist from database
        return null;
    }

    public List<Message> getHistoryChattingHistory(String roomId) {
        //TODO: An Hengyang
        return null;
    }

    public ChattingRoom joinChattingRoom(String token) {

        return null;
    }

}
