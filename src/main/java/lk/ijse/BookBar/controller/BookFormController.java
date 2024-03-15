package lk.ijse.BookBar.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class BookFormController {
    @FXML
    private AnchorPane BooksID;

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colBookCount;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colBookName;

    @FXML
    private TableColumn<?, ?> colBranch;

    @FXML
    private TableView<?> lblBooks;

    @FXML
    private Label lblBooksId;

    @FXML
    private Label lblBranch;

    @FXML
    private Label lblBranchID;

    @FXML
    private Label lblTotalBooks;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookName;

    @FXML
    private TextField txtBookSearch;

    @FXML
    private TextField txtBranchSearch;

    @FXML
    private TextField txtGenre;

    @FXML
    private TextField txtMemberContact11;

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
    void txtAuthorGoToBookCountOnAction(ActionEvent event) {

    }

    @FXML
    void txtBookGoToGenreOnAction(ActionEvent event) {

    }

    @FXML
    void txtBooksSearchOnAction(ActionEvent event) {

    }

    @FXML
    void txtBranchSearchOnAction(ActionEvent event) {

    }

    @FXML
    void txtGenreGoToAuthorOnAction(ActionEvent event) {

    }

}

