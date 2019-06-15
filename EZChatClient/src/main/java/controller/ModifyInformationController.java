package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import entity.User;

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
    private void clickButtonModify(){

    }

    // close
    @FXML
    private void clickButtonExit()
    {
        Platform.exit();
    }



}



