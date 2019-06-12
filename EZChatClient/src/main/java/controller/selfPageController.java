package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import entity.User;

import java.io.IOException;

public class selfPageController {

    // user' information
    @FXML
    private Text email;
    private Text name;
    private AnchorPane profile;

    // choose modify information
    @FXML
    private void clickeditInformation(ActionEvent event) throws IOException
    {
        Parent newGameScreen = FXMLLoader.load(getClass().getResource("/view/modifyInformation.fxml"));
        Scene newGameScene = new Scene(newGameScreen, 420,700);
        Stage newGameScreenStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        newGameScreenStage.setScene(newGameScene);
        newGameScreenStage.show();
    }

    // input room number to enter room
    @FXML
    private void clickinputRoomNumber(ActionEvent event) throws IOException
    {
        Parent newGameScreen = FXMLLoader.load(getClass().getResource("/view/inputRoomNumber.fxml"));
        Scene newGameScene = new Scene(newGameScreen, 300,200);
        Stage newGameScreenStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        newGameScreenStage.setScene(newGameScene);
        newGameScreenStage.show();
    }

    // create room
    @FXML
    private void clickCreateRoom(ActionEvent event) throws IOException
    {
        Parent newGameScreen = FXMLLoader.load(getClass().getResource("/view/createRoom.fxml"));
        Scene newGameScene = new Scene(newGameScreen, 300,200);
        Stage newGameScreenStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        newGameScreenStage.setScene(newGameScene);
        newGameScreenStage.show();
    }

    public void initUserInfoRender(){

    }

}





