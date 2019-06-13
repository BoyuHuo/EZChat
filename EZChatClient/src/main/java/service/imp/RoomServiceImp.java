package service.imp;

import entity.ChattingRoom;
import service.RoomService;
import tcp.MessageEncoder;

public class RoomServiceImp implements RoomService {
    public static ChattingRoom room;
    private static int createRoomFlag = 0; //0 pending, 1 fail, 2 success
    private static int joinRoomFlag = 0; //0 pending, 1 fail, 2 success

    MessageEncoder messageEncoder = new MessageEncoder();


    @Override
    public void creatRoom(String roomName) {

    }

    @Override
    public void joinRoom(String token) {

    }
}
