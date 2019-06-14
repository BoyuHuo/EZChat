package service.imp;

import entity.Message;
import mappers.MessageDataFunction;
import service.MessageService;

public class MessageServiceImp implements MessageService {
    MessageDataFunction messageDataFunction = new MessageDataFunction();

    @Override
    public void saveMessage(Message message) {
        messageDataFunction.addMessage(message);
    }

    @Override
    public Message getMessage(String id) {
        return messageDataFunction.selectMessage(id);
    }
}
