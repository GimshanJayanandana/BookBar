package lk.ijse.BookBar.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;

public class MemberFormController {

    @FXML
    private AnchorPane memberID;

    @FXML
    private TableColumn<?, ?> colMemberAddress;

    @FXML
    private TableColumn<?, ?> colMemberContact;

    @FXML
    private TableColumn<?, ?> colMemberId;

    @FXML
    private TableColumn<?, ?> colMemberName;

    @FXML
    private Label lblMemberId;

    @FXML
    private Label lblTotalMember;

    @FXML
    private TextField txtCustomerSearch;

    @FXML
    private TextField txtMemberAddress;

    @FXML
    private TextField txtMemberContact;

    @FXML
    private TextField txtMemberContact1;

    @FXML
    private TextField txtMemberName;

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void txtAddressGoToEmailOnAction(ActionEvent event) {

    }

    @FXML
    void txtContactGoToAddressOnAction(ActionEvent event) {

    }

    @FXML
    void txtMembersSearchOnAction(ActionEvent event) {

    }

    @FXML
    void txtNameGoToPhoneNumberOnAction(ActionEvent event) {

    }


}

