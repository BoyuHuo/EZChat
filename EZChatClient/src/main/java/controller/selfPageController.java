package controller;

import entity.User;
import javafx.fxml.Initializable;

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
}
