package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import entity.User;

import java.awt.*;
import java.io.IOException;

public class ModifyInformationController {

    // users' information
    @FXML
    private TextArea modify_introduction;
    private Checkbox modify_male;
    private Checkbox modify_female;
    private TextField modify_user_name;
    private TextField modify_password;
    private TextField modify_email;
    public User user;

    public void initUserInfoRender(){

    }

    // close
    @FXML
    private void clickButtonExit()
    {
        Platform.exit();
    }



}



