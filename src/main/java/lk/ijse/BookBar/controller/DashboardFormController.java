package lk.ijse.BookBar.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {

    @FXML
    private AnchorPane RegisterPane;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblTodayOrders;

    @FXML
    private Label lblTotalBooks;

    @FXML
    private Label lblTotalMembers;

    @FXML
    private Label lblTotalOrders;

    @FXML
    private AnchorPane mainNode;

    @FXML
    void btnBooksOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/books_form.fxml"));
        this.mainNode.getChildren().clear();
        this.mainNode.getChildren().add(anchorPane);
    }

    @FXML
    void btnBranchesOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/branches_form.fxml"));
        this.mainNode.getChildren().clear();
        this.mainNode.getChildren().add(anchorPane);

    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/DashboardForm.fxml"));
        this.RegisterPane.getChildren().clear();
        this.RegisterPane.getChildren().add(anchorPane);

    }

    @FXML
    void btnMembersOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/member_Form.fxml"));
        this.mainNode.getChildren().clear();
        this.mainNode.getChildren().add(anchorPane);



    }

    @FXML
    void btnTransactionOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/transaction_form.fxml"));
        this.mainNode.getChildren().clear();
        this.mainNode.getChildren().add(anchorPane);


    }
    @FXML
    void imgBackOnAction(MouseEvent event) throws IOException {
        mainNode.getScene().getWindow().hide();
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/loginForm.fxml"))));
        stage.centerOnScreen();
        stage.setTitle("LoginForm");
        stage.show();

    }

}
