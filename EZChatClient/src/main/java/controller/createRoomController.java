package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class createRoomController {

    //A random number which is room number
    @FXML
    private Text token;

    // set up a chatting room
    @FXML
    private void clickCreateRoom(ActionEvent event) throws IOException
    {
        Parent newGameScreen = FXMLLoader.load(getClass().getResource("/view/chat.fxml"));
        Scene newGameScene = new Scene(newGameScreen, 800,500);
        Stage newGameScreenStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        newGameScreenStage.setScene(newGameScene);
        newGameScreenStage.show();
    }

    // close
    @FXML
    private void clickButtonExit() {
        Platform.exit();
    }

}