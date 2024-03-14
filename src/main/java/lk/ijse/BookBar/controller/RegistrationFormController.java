package lk.ijse.BookBar.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationFormController {

    @FXML
    private AnchorPane RegisterPane;

    @FXML
    private PasswordField txtNewPasswordId;

    @FXML
    private PasswordField txtPasswordId;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnBackOnAction(MouseEvent event) throws IOException {

        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/loginForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) this.RegisterPane.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login form");
        stage.centerOnScreen();

    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {

    }

    @FXML
    void txtGoToNewPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void txtGoToPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void txtRegisterOnAction(ActionEvent event) {

    }
}
