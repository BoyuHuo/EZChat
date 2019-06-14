package controller;

import entity.ChatManager;
import entity.ChattingRoom;
import entity.Message;
import entity.User;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import service.MessageService;
import service.RoomService;
import service.UserService;
import service.imp.MessageServiceImp;
import service.imp.RoomServiceImp;
import service.imp.UserServiceImp;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class ChatController implements Initializable, Observer {

    public static ChattingRoom room;


    @FXML
    TextField token;
    @FXML
    TextArea message_box;
    @FXML
    TextField input;
    @FXML
    Label room_name;


    private final ObservableList<String> usersData = FXCollections.observableArrayList();

    @FXML
    private ListView<String> user_list;

    public RoomService roomService = new RoomServiceImp();
    public UserService userService = new UserServiceImp();
    public MessageService messageService = new MessageServiceImp();

    @FXML
    public void sendMessage(ActionEvent event) throws IOException {
        if ("".equals(input.getText()) || input.getText() == null) {
            return;
        }
        Message message = new Message();
        message.setName(SelfPageController.user.getUsername());
        message.setUser_id(SelfPageController.user.getId());
        message.setRoom_id("" + room.getId());
        message.setMessage(input.getText());
        messageService.sendMessage(message);
        input.setText("");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usersData.clear();
        user_list.setItems(usersData);


        ChatManager.getInstance().addObserver(this);

        room_name.setText(room.getName());
        token.setText(room.getToken());
    }

    public void updateUserList() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                usersData.clear();
                for (String name : ChatManager.getInstance().getUsers()) {
                    usersData.add(name);
                }
            }
        });
    }


    @Override
    synchronized public void update(Observable observable, Object o) {
        message_box.setText(ChatManager.getInstance().getMessage());
        updateUserList();

    }
}

