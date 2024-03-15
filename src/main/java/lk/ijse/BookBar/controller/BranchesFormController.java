package lk.ijse.BookBar.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class BranchesFormController {

    @FXML
    private AnchorPane BranchesID;
    @FXML
    private TableColumn<?, ?> colBranchAddress;

    @FXML
    private TableColumn<?, ?> colBranchId;

    @FXML
    private TableColumn<?, ?> colBranchManager;

    @FXML
    private TableColumn<?, ?> colBranchName;

    @FXML
    private TableColumn<?, ?> colBranchStaff;

    @FXML
    private Label lblBranchID;

    @FXML
    private Label lblTotalBranches;

    @FXML
    private TableView<?> tblBranches;

    @FXML
    private TextField txtBranchAddress;

    @FXML
    private TextField txtBranchName;

    @FXML
    private TextField txtBranchSearch;

    @FXML
    private TextField txtBranchStaff;

    @FXML
    private TextField txtMemberContact;

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
    void txtBranchSearchOnAction(ActionEvent event) {

    }

    @FXML
    void txtContactGoToAddressOnAction(ActionEvent event) {

    }

    @FXML
    void txtNameGoToManagerOnAction(ActionEvent event) {

    }

    @FXML
    void txtStaffGoToAddressOnAction(ActionEvent event) {

    }
}

