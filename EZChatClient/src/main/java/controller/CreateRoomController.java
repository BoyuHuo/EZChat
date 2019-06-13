package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import service.RoomService;
import service.imp.RoomServiceImp;
import service.imp.UserServiceImp;

import java.io.IOException;
import java.util.Optional;

public class CreateRoomController {


    RoomService roomService = new RoomServiceImp();

    //A random number which is room number
    @FXML
    private TextField token;
    @FXML
    private TextField room_name;

    // set up a chatting room
    @FXML
    private void clickCreateRoom(ActionEvent event) throws IOException
    {
        if("".equals(room_name.getText())||room_name.getText()==null){

        }else{
            roomService.creatRoom(room_name.getText());
            while (RoomServiceImp.getCreateRoomFlag()==0){

            }
            if(RoomServiceImp.getCreateRoomFlag()==1){

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Fail!");
                alert.setHeaderText(null);
                alert.setContentText("Sorry, fail to create a room! Please try again!");
                alert.showAndWait();

            }else{

                System.out.println(RoomServiceImp.room.toString());
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Success");
                alert.setContentText("Create room successful, Share the token to your friends to join the room !");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    // ... user chose OK
                    System.out.println(RoomServiceImp.room.getToken()+"123");
                    alert.close();

                } else {
                    // ... user chose CANCEL or closed the dialog
                    alert.close();
                }
            }
        }


    }

    // close
    @FXML
    private void clickButtonExit(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}