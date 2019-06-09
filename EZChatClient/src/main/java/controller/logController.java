package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.UserService;
import service.imp.UserServiceImp;


public class logController   {
    @FXML private TextField number;
    @FXML private TextField password;
    @FXML private Button log_in;

    UserService userService = new UserServiceImp();


    public TextField getNumber() {
        return number;
    }

    public void setNumber(TextField number) {
        this.number = number;
    }

    public TextField getPassword() {
        return password;
    }

    public void setPassword(TextField password) {
        this.password = password;
    }



    public void example(){
        userService.checkUser("number","password");
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
//
}
