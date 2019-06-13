package controller;

import entity.ChattingRoom;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.text.TableView;

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

}

