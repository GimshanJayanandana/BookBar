package lk.ijse.BookBar.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.BookBar.bo.BOFactory;
import lk.ijse.BookBar.bo.custom.BranchesBO;
import lk.ijse.BookBar.dto.BranchesDto;
import lk.ijse.BookBar.dto.tm.BranchesTm;

import java.sql.SQLException;
import java.util.List;

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
    private TableView<BranchesTm> tblBranches;

    @FXML
    private TextField txtBranchAddress;

    @FXML
    private TextField txtBranchManager;

    @FXML
    private TextField txtBranchName;

    @FXML
    private TextField txtBranchSearch;

    @FXML
    private TextField txtBranchStaff;

    private ObservableList<BranchesTm> obList = FXCollections.observableArrayList();
    BranchesBO branchesBO = (BranchesBO) BOFactory.getBoFactory().grtBo(BOFactory.BOTypes.BRANCHES);

    public void initialize(){
        generateNextID();
        loadAllBranches();
        setCellValueFactory();
        tableListener();
    }

    private void clearFields(){
        lblBranchID.setText("");
        txtBranchName.setText("");
        txtBranchSearch.setText("");
        txtBranchManager.setText("");
        txtBranchAddress.setText("");
        txtBranchStaff.setText("");

    }

    private void tableListener() {
        tblBranches.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setData(newValue);
        });
    }
    private void setData(BranchesTm row) {
        if (row != null) {
            lblBranchID.setText(row.getId());
            txtBranchName.setText(row.getBranchName());
            txtBranchStaff.setText(row.getStaff());
            txtBranchManager.setText(row.getManager());
            txtBranchAddress.setText(row.getAddress());
        }
    }
    private void setCellValueFactory() {
        colBranchId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBranchName.setCellValueFactory(new PropertyValueFactory<>("branchName"));
        colBranchManager.setCellValueFactory(new PropertyValueFactory<>("manager"));
        colBranchAddress.setCellValueFactory(new PropertyValueFactory<>("staff"));
        colBranchStaff.setCellValueFactory(new PropertyValueFactory<>("address"));
        tblBranches.setId("my-table");
    }

    private void loadAllBranches() {
        try {
            obList.clear();
            List<BranchesDto> dtoList = branchesBO.getAllBranches();
            for (BranchesDto dto : dtoList) {
                obList.add(new BranchesTm(
                        dto.getId(), dto.getBranchName(), dto.getStaff(), dto.getManager(), dto.getAddress()));
            }
            tblBranches.setItems(obList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void generateNextID() {
        String branchID = branchesBO.generateNextBranchID();
        lblBranchID.setText(branchID);
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
        generateNextID();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = lblBranchID.getText();
        String branchName = txtBranchName.getText();
        String staff = txtBranchStaff.getText();
        String manager = txtBranchManager.getText();
        String address = txtBranchAddress.getText();

        try {
            boolean isDeleted = branchesBO.deleteBranch(id);
            if (isDeleted) {
                loadAllBranches();
                clearFields();
                generateNextID();
                new Alert(Alert.AlertType.INFORMATION,"Branch is Deleted").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = lblBranchID.getText();
        String branchName = txtBranchName.getText();
        String staff = txtBranchStaff.getText();
        String manager = txtBranchManager.getText();
        String address = txtBranchAddress.getText();

        try {
            boolean isSaved = branchesBO.saveBranch(new BranchesDto(id,branchName,staff,manager,address));
            if (isSaved) {
                loadAllBranches();
                clearFields();
                generateNextID();
                new Alert(Alert.AlertType.INFORMATION,"Branch Added Successfully").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = lblBranchID.getText();
        String branchName = txtBranchName.getText();
        String staff = txtBranchStaff.getText();
        String manager = txtBranchManager.getText();
        String address = txtBranchAddress.getText();

        try {
            boolean isUpdate = branchesBO.updateBranch(new BranchesDto(id,branchName,staff,manager,address));
            if (isUpdate) {
                loadAllBranches();
                clearFields();
                generateNextID();
                new Alert(Alert.AlertType.INFORMATION,"Branches Updated").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void txtBranchSearchOnAction(ActionEvent event) {
        searchTableFilter();

    }

    private void searchTableFilter() {
        FilteredList<BranchesTm> filteredBranchesList = new FilteredList<>(obList, b -> true);
        txtBranchSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredBranchesList.setPredicate(branchesTm -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();

                if (branchesTm.getId().toLowerCase().contains(search)) {
                    return true;
                } else if (branchesTm.getId().toLowerCase().contains(search)) {
                    return true;
                } else if (branchesTm.getBranchName().toLowerCase().contains(search)) {
                    return true;
                } else if (branchesTm.getBranchName().toLowerCase().contains(search)) {
                    return true;
                } else if (branchesTm.getManager().toLowerCase().contains(search)) {
                    return true;
                } else if (branchesTm.getManager().toLowerCase().contains(search)) {
                    return true;
                } else if (branchesTm.getAddress().toLowerCase().contains(search)) {
                    return true;
                } else if (branchesTm.getAddress().toLowerCase().contains(search)) {
                    return true;
                } else if (branchesTm.getStaff().toLowerCase().contains(search)) {
                    return true;
                } else if (branchesTm.getStaff().toLowerCase().contains(search)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<BranchesTm> sortedList = new SortedList<>(filteredBranchesList);
        sortedList.comparatorProperty().bind(tblBranches.comparatorProperty());
        tblBranches.setItems(sortedList);

    }

    @FXML
    void txtManagerGoToAddressOnAction(ActionEvent event) {

    }

    @FXML
    void txtNameGoToManagerOnAction(ActionEvent event) {

    }

    @FXML
    void txtStaffGoToAddressOnAction(ActionEvent event) {

    }
}

