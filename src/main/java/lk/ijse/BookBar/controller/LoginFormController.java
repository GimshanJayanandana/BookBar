package lk.ijse.BookBar.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.BookBar.dao.custom.UserDAO;
import lk.ijse.BookBar.dao.impl.UserDAOimpl;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private AnchorPane rootNode;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    UserDAO userDAO = new UserDAOimpl();

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {

        String name = txtUserName.getText();
        String password = txtPassword.getText();

        try {
            boolean isValid = userDAO.isValidUser(name,password);
            if (isValid) {
                goToMainForm();
            } else {
                new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
            }
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    private void goToMainForm() throws IOException {

        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/DashboardForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Register");

    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/registrationForn.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Register");

    }
    @FXML
    void txtGoToPassword(ActionEvent event) {
        txtUserName.requestFocus();
    }
    @FXML
    void txtLoginOnAction(ActionEvent event) {

    }
}
