package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {

    @FXML
    public void sureBtn(ActionEvent event) throws IOException {
        Parent registerScene = FXMLLoader.load(getClass().getResource("/view/log.fxml"));
        Scene logOnScene = new Scene(registerScene, 800,500);
        Stage createSceneStage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        createSceneStage.setScene(logOnScene);
        createSceneStage.show();
    }

    @FXML
    public void cancleBtn(ActionEvent event) throws IOException {
        Parent registerScene = FXMLLoader.load(getClass().getResource("/view/log.fxml"));
        Scene logOnScene = new Scene(registerScene, 800,500);
        Stage createSceneStage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        createSceneStage.setScene(logOnScene);
        createSceneStage.show();
    }

}
