package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import entity.User;

import javafx.fxml.Initializable;
import service.RoomService;
import service.imp.RoomServiceImp;


import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class SelfPageController implements Initializable {

    public static User user;


    RoomService roomService = new RoomServiceImp();


    @FXML Label username;
    @FXML private Label userAccount;
    @FXML private Label userEmail;
    @FXML private Label userGender;




    @FXML
    private void clickeditInformation(ActionEvent event) throws IOException {
        Parent newGameScreen = FXMLLoader.load(getClass().getResource("/view/modifyInformation.fxml"));
        Scene newGameScene = new Scene(newGameScreen, 420, 700);
        Stage newGameScreenStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        newGameScreenStage.setScene(newGameScene);
        newGameScreenStage.show();
    }

    // input room number to enter room
    @FXML
    private void clickinputRoomNumber(ActionEvent event) throws IOException {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Join Room");
        dialog.setHeaderText("Join Room");
        dialog.setContentText("Please enter room token:");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            roomService.joinRoom(result.get());
            while(RoomServiceImp.getJoinRoomFlag()==0){}
        }
        if(RoomServiceImp.getJoinRoomFlag()==1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wong Token!");
            alert.setHeaderText(null);
            alert.setContentText("Room doesn't exist!");
            alert.showAndWait();
        }
        if(RoomServiceImp.getJoinRoomFlag()==2){
            ChatController.room = RoomServiceImp.room;

            Parent newGameScreen = FXMLLoader.load(getClass().getResource("/view/chat.fxml"));
            Scene newGameScene = new Scene(newGameScreen, 800, 500);
            Stage newGameScreenStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            newGameScreenStage.setScene(newGameScene);
            newGameScreenStage.show();

        }



    }

    // create room
    @FXML
    private void clickCreateRoom(ActionEvent event) throws IOException {
        Parent registerScene = FXMLLoader.load(getClass().getResource("/view/createRoom.fxml"));
        Scene logOnScene = new Scene(registerScene, 300, 240);
        Stage createSceneStage = new Stage();
        createSceneStage.setScene(logOnScene);
        createSceneStage.show();
    }

    public void initialize(URL location, ResourceBundle resources) {
        update();
    }

    public void update() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                username.setText(user.getUsername());
                userEmail.setText(user.getEmail());
                userGender.setText(user.getGender());
                userAccount.setText(user.getAccount());
            }
        });
    }


}






