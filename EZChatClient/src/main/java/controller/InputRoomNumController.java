package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class InputRoomNumController {

    // area to input chatting room number
    @FXML
    private TextField room_number;

    // close
    @FXML
    private void clickButtonExit()
    {
        Platform.exit();
    }

    // certify inputed room number
    @FXML
    private void clicksureButton (ActionEvent event) throws IOException
    {
        Parent newGameScreen = FXMLLoader.load(getClass().getResource("/view/chat.fxml"));
        Scene newGameScene = new Scene(newGameScreen, 800,500);
        Stage newGameScreenStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        newGameScreenStage.setScene(newGameScene);
        newGameScreenStage.show();
    }

}
