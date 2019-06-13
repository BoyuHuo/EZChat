package controller;

import entity.ChattingRoom;
import entity.Message;
import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import service.MessageService;
import service.RoomService;
import service.UserService;
import service.imp.MessageServiceImp;
import service.imp.RoomServiceImp;
import service.imp.UserServiceImp;

import java.io.IOException;

public class ChatController {

    public static ChattingRoom room;

    @FXML
    TextField token;
    @FXML
    TextArea message;
    @FXML
    TextField input;

    @FXML
    private TableView userList;

    public RoomService roomService =new RoomServiceImp();
    public UserService userService = new UserServiceImp();
    public MessageService messageService = new MessageServiceImp();

    @FXML
    public void sendMessage(ActionEvent event) throws IOException {
        if("".equals(input.getText())||input.getText()==null){
            return;
        }
        Message message =new Message();
        message.setName(SelfPageController.user.getUsername());
        messageService.sendMessage(message);


    }

}

