package service.imp;

import entity.ChattingRoom;
import entity.Message;
import service.ChattingRoomService;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.List;
import mappers.*;

public class ChattingRoomServiceImp implements ChattingRoomService {
    public ChattingRoomService createChattingRoom(String roomName) {
        // TODO: An hengyang
        String token = this.generateToken();
        ChattingRoom chattingRoom = new ChattingRoom(token,roomName);
        chattingRoom.setId(null);
        ChatRoomDataFunction chatRoomDataFunction = new ChatRoomDataFunction();
        chatRoomDataFunction.addChatRoom(chattingRoom);

        // call generateToken -> new ChattingRoom -> fill up the fields in ChattingRoom (ps, name, token  (leave the id as null) ) -> store it in database ->return it
        return null;
    }

    public String generateToken() {
        //  7346734837483  834u938493493849384  43434384
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        //数据指纹   128位长   16个字节  md5
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] = md.digest(token.getBytes());
            //base64编码--任意二进制编码明文字符
            Encoder encoder = Base64.getEncoder();
            String encode = encoder.encodeToString(md5);
            return encode;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
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

}
