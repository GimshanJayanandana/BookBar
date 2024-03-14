package lk.ijse.BookBar.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

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
    void btnBooksOnAction(ActionEvent event) {

    }

    @FXML
    void btnBranchesOnAction(ActionEvent event) throws IOException {

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
        this.mainNode.getChildren().add(anchorPane);;



    }

    @FXML
    void btnTransactionOnAction(ActionEvent event) {

    }

}
