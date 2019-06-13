package service.imp;

import entity.ChattingRoom;
import entity.Message;
import service.ChattingRoomService;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.List;

import mappers.*;

public class ChattingRoomServiceImp implements ChattingRoomService {

    public ChattingRoom createChattingRoom(String roomName) {
        String token = this.generateToken();
        ChattingRoom chattingRoom = new ChattingRoom(token, roomName);
        chattingRoom.setId(null);
        ChatRoomDataFunction chatRoomDataFunction = new ChatRoomDataFunction();
        chattingRoom = chatRoomDataFunction.addChatRoom(chattingRoom);
        return chattingRoom;
    }

    public String generateToken() {
        //  7346734837483  834u938493493849384  43434384
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";

        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] = md.digest(token.getBytes());

            Encoder encoder = Base64.getEncoder();
            String encode = encoder.encodeToString(md5);
            return encode;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ChattingRoom> getHistoryChattingRoomList(String userId) {
        //TODO: baiyu
/*        List<ChattingRoom> rooms = new ArrayList<>();
        ChatRoomDataFunction chatRoomDataFunction = new ChatRoomDataFunction();
        rooms = chatRoomDataFunction.selectChatroom(userId);
        System.out.println(rooms);
        return rooms;
        //李晴似乎还没有写getChattingRoom,我加上了，不知道对不对
        // call liqing's function to get the Roomlist from database*/
        return null;
    }

    public List<Message> getHistoryChattingHistory(String roomId) {
        List<Message> messages = new ArrayList<>();
        ChatRoomDataFunction chatRoomDataFunction = new ChatRoomDataFunction();
        ChattingRoom cr = new ChattingRoom();
        cr.setId(roomId);
        messages = chatRoomDataFunction.selectAllMessage(cr);
        System.out.println(messages);
        return messages;
    }

    public ChattingRoom joinChattingRoom(String token) {

        return null;
    }

}
