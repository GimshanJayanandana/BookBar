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
import lk.ijse.BookBar.bo.custom.MembersBo;
import lk.ijse.BookBar.dto.MemberDto;
import lk.ijse.BookBar.dto.tm.MemberTm;

import java.sql.SQLException;
import java.util.List;

public class MemberFormController {

    @FXML
    private AnchorPane memberID;

    @FXML
    private TableView<MemberTm> tblMember;

    @FXML
    private TableColumn<?, ?> colMemberAddress;

    @FXML
    private TableColumn<?, ?> colMemberContact;

    @FXML
    private TableColumn<?, ?> colMemberId;

    @FXML
    private TableColumn<?, ?> colMemberName;

    @FXML
    private TableColumn<?, ?> colMemberEmail;

    @FXML
    private Label lblMemberId;

    @FXML
    private Label lblTotalMember;

    @FXML
    private TextField txtMemberSearch;

    @FXML
    private TextField txtMemberAddress;

    @FXML
    private TextField txtMemberContact;

    @FXML
    private TextField txtMemberEmail;

    @FXML
    private TextField txtMemberName;

    private ObservableList<MemberTm> obList = FXCollections.observableArrayList();

    MembersBo membersBo = (MembersBo) BOFactory.getBoFactory().grtBo(BOFactory.BOTypes.MEMBERS);
    public void initialize() {
        generateNextID();
        LoadAllMembers();
        setCellValueFactory();
        tableListener();
    }

    private void setCellValueFactory() {
        colMemberId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMemberName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colMemberContact.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colMemberEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colMemberAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tblMember.setId("my-table");
    }

    private void LoadAllMembers() {
        try {
            obList.clear();
            List<MemberDto> dtoList = membersBo.getAllMembers();
            for (MemberDto dto : dtoList) {
                obList.add(
                        new MemberTm(
                                dto.getId(), dto.getName(), dto.getPhoneNumber(), dto.getEmail(), dto.getAddress()));
            }
            tblMember.setItems(obList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void generateNextID() {
        String memberID = membersBo.generateNextMemberID();
        lblMemberId.setText(memberID);

    }

    private void clearFields() {
        lblMemberId.setText("");
        txtMemberName.setText("");
        txtMemberEmail.setText("");
        txtMemberAddress.setText("");
        txtMemberContact.setText("");
        txtMemberSearch.setText("");
    }

    private void tableListener() {
        tblMember.getSelectionModel().selectedItemProperty().addListener((observable, oldValued, newValue) -> {
            setData(newValue);
        });
    }

    private void setData(MemberTm row) {
        if (row != null) {
            lblMemberId.setText(row.getId());
            txtMemberName.setText(row.getName());
            txtMemberContact.setText(String.valueOf(row.getPhoneNumber()));
            txtMemberEmail.setText(row.getEmail());
            txtMemberAddress.setText(row.getAddress());
        }
    }


    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
        generateNextID();
    }
    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = lblMemberId.getText();
        String name = txtMemberName.getText();
        String phoneNumber = txtMemberContact.getText();
        String email = txtMemberEmail.getText();
        String address = txtMemberAddress.getText();

        try {
            boolean isDeleted = membersBo.deleteMember(id);
            if (isDeleted) {
                LoadAllMembers();
                clearFields();
                generateNextID();
                new Alert(Alert.AlertType.INFORMATION,"Member Deleted").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = lblMemberId.getText();
        String name = txtMemberName.getText();
        String phoneNumber = txtMemberContact.getText();
        String email = txtMemberEmail.getText();
        String address = txtMemberAddress.getText();

        try {
            boolean isSaved = membersBo.saveMember(new MemberDto(id,name,phoneNumber,email,address));
            if (isSaved) {
                clearFields();
                LoadAllMembers();
                generateNextID();
                new Alert(Alert.AlertType.INFORMATION,"Member Saved").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = lblMemberId.getText();
        String name = txtMemberName.getText();
        String phoneNumber = txtMemberContact.getText();
        String email = txtMemberEmail.getText();
        String address = txtMemberAddress.getText();

        try {
            boolean isUpdated = membersBo.updateMember(new MemberDto(id,name,phoneNumber,email,address));
            if (isUpdated) {
                LoadAllMembers();
                clearFields();
                generateNextID();
                new Alert(Alert.AlertType.INFORMATION,"Member Updated").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void txtAddressGoToEmailOnAction(ActionEvent event) {

    }

    @FXML
    void txtContactGoToAddressOnAction(ActionEvent event) {

    }

    @FXML
    void txtMembersSearchOnAction(ActionEvent event) {
        searchTableFilter();

    }

    private void searchTableFilter() {
        FilteredList<MemberTm> filteredMemberList = new FilteredList<>(obList, b -> true);
        txtMemberSearch.textProperty().addListener((observable,oldValue,newValue) -> {
            filteredMemberList.setPredicate(memberTm -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();

                if (memberTm.getId().toLowerCase().contains(search)) {
                    return true;
                } else if (memberTm.getId().toLowerCase().contains(search)) {
                    return true;
                } else if (memberTm.getName().toLowerCase().contains(search)) {
                    return true;
                } else if (memberTm.getName().toLowerCase().contains(search)) {
                    return true;
                } else if (memberTm.getPhoneNumber().toLowerCase().contains(search)) {
                    return true;
                } else if (memberTm.getPhoneNumber().toLowerCase().contains(search)) {
                    return true;
                } else if (memberTm.getEmail().toLowerCase().contains(search)) {
                    return true;
                } else if (memberTm.getEmail().toLowerCase().contains(search)) {
                    return true;
                } else if (memberTm.getAddress().toLowerCase().contains(search)) {
                    return true;
                } else if (memberTm.getAddress().toLowerCase().contains(search)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<MemberTm> sortedList = new SortedList<>(filteredMemberList);
        sortedList.comparatorProperty().bind(tblMember.comparatorProperty());
        tblMember.setItems(sortedList);
    }

    @FXML
    void txtNameGoToPhoneNumberOnAction(ActionEvent event) {

    }


}

