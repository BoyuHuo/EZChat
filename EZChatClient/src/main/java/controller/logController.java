package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.UserService;
import service.imp.UserServiceImp;

import java.io.IOException;


public class logController   {
    @FXML private TextField email;
    @FXML private TextField password;

    UserService userService = new UserServiceImp();


    public void example(){
        userService.checkUser("number","password");
    }


    @FXML
    public void signup(ActionEvent event) throws IOException {
        Parent registerScene = FXMLLoader.load(getClass().getResource("/view/logOn.fxml"));
        Scene logOnScene = new Scene(registerScene, 420,500);
        Stage createSceneStage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        createSceneStage.setScene(logOnScene);
        createSceneStage.show();
    }

    @FXML
    public void signin(ActionEvent event) throws IOException{
        Parent registerScene = FXMLLoader.load(getClass().getResource("/view/selfPage.fxml"));
        Scene logOnScene = new Scene(registerScene, 400,460);
        Stage createSceneStage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        createSceneStage.setScene(logOnScene);
        createSceneStage.show();
    }





//    User User = new User();
//    public void setUser(){
//        User.setUserNumber(number.getText());
//        User.setUserPassword(password.getText());
//    }
//    @FXML public void handleButtonEvent()
//    {
//        if(User.getUserNumber()==User.getUserNumber()){
//            if(User.getUserPassword()==User.getUserPassword()){
//                System.out.println("登录成功");
//                //跳转窗口
//            }
//            else System.out.println("登录失败");
//        }
//    }
}
