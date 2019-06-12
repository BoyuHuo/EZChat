package controller;

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
import java.net.URL;
import java.util.ResourceBundle;

public class selfPageController  implements Initializable {
    //TODO: Rensen

    public static User user;

    public void initUserInfoRender(){
        //TODO Hao
        // use user to render the component e.g. XXXXX.setText(user.getUsername)       "XXXX" is the front-end component
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
