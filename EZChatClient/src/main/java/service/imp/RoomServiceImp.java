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
        setCreateRoomFlag(0);
        messageEncoder.encodeMessage(roomName, "createroom");
    }

    @Override
    public void joinRoom(String token) {
        setJoinRoomFlag(0);
        messageEncoder.encodeMessage(token, "joinroom");
    }

    synchronized public static int getCreateRoomFlag() {
        return createRoomFlag;
    }

    synchronized public static void setCreateRoomFlag(int createRoomFlag) {
        RoomServiceImp.createRoomFlag = createRoomFlag;
    }

    synchronized public static int getJoinRoomFlag() {
        return joinRoomFlag;
    }

    synchronized public static void setJoinRoomFlag(int joinRoomFlag) {
        RoomServiceImp.joinRoomFlag = joinRoomFlag;
    }
}
