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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class SelfPageController implements Initializable {
    @FXML
    private Text email;
    private Text name;
    private AnchorPane profile;

    public static User user;

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


    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(user.toString());
    }
    @FXML
    public void createRoomBtn(ActionEvent event) throws IOException {
        Parent registerScene = FXMLLoader.load(getClass().getResource("/view/createRoom.fxml"));
        Scene logOnScene = new Scene(registerScene, 300,200);
        Stage createSceneStage = new Stage();
        createSceneStage.setScene(logOnScene);
        createSceneStage.show();
    }
    @FXML
    public void joinRoomBtn(ActionEvent event) throws IOException {
        Parent registerScene = FXMLLoader.load(getClass().getResource("/view/chat.fxml"));
        Scene logOnScene = new Scene(registerScene, 800 ,500);
        Stage createSceneStage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        createSceneStage.setScene(logOnScene);
        createSceneStage.show();
    }
}





