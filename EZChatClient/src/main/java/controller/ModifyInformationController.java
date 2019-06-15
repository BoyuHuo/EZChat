package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import entity.User;
import service.UserService;
import service.imp.UserServiceImp;

import java.awt.*;
import java.io.IOException;

public class ModifyInformationController {

    // users' information
    @FXML
    private TextField modify_user_name;
    @FXML
    private TextField modify_e_mail;
    @FXML
    private TextField modify_password;
    @FXML
    private RadioButton gender_male;
    @FXML
    private RadioButton gender_female;


    public static User user;

    public UserService userService = new UserServiceImp();

    public void initUserInfoRender(){
        modify_user_name.setText(user.getUsername());
        modify_e_mail.setText(user.getEmail());
        modify_password.setText(user.getPassword());
        if(user.getGender().equals("m")){
            gender_male.setSelected(true);
        }else{
            gender_female.setSelected(true);
        }
    }


    @FXML
    private void clickButtonModify() {
        User user1 = user;
        user1.setUsername(modify_user_name.getText());
        user1.setPassword(modify_password.getText());
        user1.setEmail(modify_e_mail.getText());
        if (gender_male.isSelected()) {
            user1.setGender("m");
        } else {
            user1.setGender("f");
        }
        userService.updateUser(user1);

        while (UserServiceImp.getUpdateFlag() == 0) {
        }
        if (UserServiceImp.getUpdateFlag() == 1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Wong content!");
            alert.setHeaderText(null);
            alert.setContentText("Sorry, update fail!\n Please try again!");
            alert.showAndWait();
        } else if (UserServiceImp.getUpdateFlag() == 2) {
            if (UserServiceImp.getUpdateFlag() == 1) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("OK!");
                alert.setHeaderText(null);
                alert.setContentText("Update Successful!");
                alert.showAndWait();
            }
        }
    }

    // close
    @FXML
    private void clickButtonExit(ActionEvent event) throws IOException
    {
        Parent signInScene = FXMLLoader.load(getClass().getResource("/view/selfPage.fxml"));
        Scene logOnScene = new Scene(signInScene, 400,460);
        Stage createSceneStage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        createSceneStage.setScene(logOnScene);
        createSceneStage.show();
    }



}



