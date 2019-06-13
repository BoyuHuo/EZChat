package service.imp;

import entity.Message;
import service.MessageService;
import tcp.MessageEncoder;

public class MessageServiceImp implements MessageService {

    MessageEncoder messageEncoder = new MessageEncoder();

    @Override
    public void sendMessage(Message message) {
        messageEncoder.encodeMessage(message.toString(),"message");
    }
}
