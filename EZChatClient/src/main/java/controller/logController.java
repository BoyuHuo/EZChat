package controller;
import javafx.event.*;
import javafx.scene.control.Button;
import model.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class logController   {
    @FXML private TextField number;
    @FXML private TextField password;
    @FXML private Button log_in;


    User User = new User();
    public void setUser(){
        User.setUserNumber(number.getText());
        User.setUserPassword(password.getText());
    }
    @FXML public void handleButtonEvent()
    {
        if(User.getUserNumber()==User.getUserNumber()){
            if(User.getUserPassword()==User.getUserPassword()){
                System.out.println("登录成功");
                //跳转窗口

            }
            else System.out.println("登录失败");
        }
    }

}
