package controller;

import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.UserService;
import service.imp.UserServiceImp;

import javax.xml.soap.Text;
import java.io.IOException;
import java.util.Optional;

public class SignUpController {

    UserService userService = new UserServiceImp();

    @FXML
    TextField user_name;
    @FXML
    TextField password;
    @FXML
    TextField e_mail;
    @FXML
    RadioButton user_gender_male;
    @FXML
    TextField account;
    @FXML
    TextField password_confirm;

    @FXML
    public void sureBtn(ActionEvent event) throws IOException {
        if ("".equals(user_name.getText()) || user_name.getText() == null || ("").equals(password.getText()) || password.getText() == null || e_mail.getText() == null || ("").equals(e_mail.getText())
                || account.getText() == null || ("").equals(account.getText())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid Form!");
            alert.setHeaderText(null);
            alert.setContentText("Please fill out all the fields!");
            alert.showAndWait();
        }

        if (!password.getText().equals(password_confirm.getText())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Password not same!");
            alert.setHeaderText(null);
            alert.setContentText("The password that you input second time is different from the first time.\n Please check again!");
            alert.showAndWait();
        }


        String sex = (user_gender_male.isSelected() ? "m" : "f");

        User user = new User();
        user.setUsername(user_name.getText());
        user.setEmail(e_mail.getText());
        user.setPassword(password.getText());
        user.setAccount(account.getText());
        user.setGender(sex);

        userService.registerUser(user);

        while(UserServiceImp.getSignupFlag()==0){
        }
        if(UserServiceImp.getSignupFlag()==1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid Form!");
            alert.setHeaderText(null);
            alert.setContentText("Sorry, User has already exist!");
            alert.showAndWait();
        }else {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Success");
            alert.setContentText("Hi, "+user_name.getText()+", welcome to EZChat!");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                // ... user chose OK
                Parent registerScene = FXMLLoader.load(getClass().getResource("/view/log.fxml"));
                Scene logOnScene = new Scene(registerScene, 800, 500);
                Stage createSceneStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                createSceneStage.setScene(logOnScene);
                createSceneStage.show();

            } else {
                // ... user chose CANCEL or closed the dialog
                alert.close();
            }
        }
    }

    @FXML
    public void cancleBtn(ActionEvent event) throws IOException {
        Parent registerScene = FXMLLoader.load(getClass().getResource("/view/log.fxml"));
        Scene logOnScene = new Scene(registerScene, 800, 500);
        Stage createSceneStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        createSceneStage.setScene(logOnScene);
        createSceneStage.show();
    }

}
