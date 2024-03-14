package lk.ijse.BookBar.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.BookBar.bo.BOFactory;
import lk.ijse.BookBar.bo.custom.UserBO;
import lk.ijse.BookBar.dto.UserDto;

import java.io.IOException;
import java.sql.SQLException;

public class RegistrationFormController {

    @FXML
    private AnchorPane RegisterPane;

    @FXML
    private TextField txtEmailId;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    UserBO userBO = (UserBO) BOFactory.getBoFactory().grtBo(BOFactory.BOTypes.USER);
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

        String name = txtUserName.getText();
        String email = txtEmailId.getText();
        String password = txtPassword.getText();

        try {
            boolean isSaved = userBO.saveUser(new UserDto(name,email,password));
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION,"Saved").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

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
    @FXML
    void txtGoToEmailOnAction(ActionEvent event) {

    }
    @FXML
    void txtPasswordOnAction(ActionEvent event) {

    }
}
