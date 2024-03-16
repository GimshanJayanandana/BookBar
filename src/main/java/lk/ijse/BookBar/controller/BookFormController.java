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
import lk.ijse.BookBar.bo.custom.BooksBO;
import lk.ijse.BookBar.bo.custom.BranchesBO;
import lk.ijse.BookBar.dao.DAOFactory;
import lk.ijse.BookBar.dao.custom.BooksDAO;
import lk.ijse.BookBar.dto.BooksDto;
import lk.ijse.BookBar.dto.BranchesDto;
import lk.ijse.BookBar.dto.tm.BooksTm;

import java.sql.SQLException;
import java.util.List;

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
    private TableColumn<?, ?> colBranchName;

    @FXML
    private TableColumn<?, ?> colGenre;

    @FXML
    private TableView<BooksTm> tblBooks;

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
    private TextField txtBookCount;

    private ObservableList<BooksTm> obList = FXCollections.observableArrayList();

    BranchesBO branchBO = (BranchesBO) BOFactory.getBoFactory().grtBo(BOFactory.BOTypes.BRANCHES);

    BooksDAO booksDAO = (BooksDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOKS);

    BooksBO booksBO = (BooksBO) BOFactory.getBoFactory().grtBo(BOFactory.BOTypes.BOOKS);

    public void initialize() {
        generateNextID();
        loadAllBooks();
        setCellValueFactory();
        tableListener();
        autoComplete();
        totalBooks();
    }

    private void generateNextID() {
        String bookID = booksBO.generateBookID();
        lblBooksId.setText(bookID);

    }

    private void loadAllBooks() {
        try {
            obList.clear();
            List<BooksDto> dtoList = booksBO.getAllBooks();
            for (BooksDto dto : dtoList) {
                obList.add(new BooksTm(
                        dto.getBookID(),
                        dto.getTitle(),

                        dto.getGenre(), dto.getAuthor(), dto.getBranchID(), dto.getBranchName(), dto.getQty()));
            }
            tblBooks.setItems(obList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void setCellValueFactory() {
        colBookId.setCellValueFactory(new PropertyValueFactory<>("bookID"));
        colBookName.setCellValueFactory(new PropertyValueFactory<>("title"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colBranch.setCellValueFactory(new PropertyValueFactory<>("branchID"));
        colBranchName.setCellValueFactory(new PropertyValueFactory<>("branchName"));
        colBookCount.setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblBooks.setId("my-table");

    }

    private void tableListener() {
        tblBooks.getSelectionModel().selectedItemProperty().addListener((observable, oldValued, newValue) -> {
            setData(newValue);
        });

    }

    private void setData(BooksTm row) {
        if (row != null) {
            lblBooksId.setText(row.getBookID());
            txtBookName.setText(row.getTitle());
            txtGenre.setText(row.getGenre());
            txtAuthor.setText(row.getAuthor());
            txtBookCount.setText(row.getQty());
            lblBranch.setText(row.getBranchName());
            lblBranchID.setText(row.getBranchID());

        }
    }
    private void autoComplete() {
    }

    private void totalBooks() {
        String books = booksDAO.getTotalBooks();
        lblTotalBooks.setText(books);
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
        generateNextID();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = lblBooksId.getText();
        String title = txtBookName.getText();
        String genre = txtGenre.getText();
        String author = txtAuthor.getText();
        String qty = txtBookCount.getText();
        String branchName = lblBranch.getText();

        try {
            boolean isDeleted = booksBO.deleteBooks(id);
            if (isDeleted) {
                clearFields();
                generateNextID();
                loadAllBooks();
                totalBooks();
                new Alert(Alert.AlertType.CONFIRMATION,"Book Deleted").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void clearFields() {
        lblBooksId.setText("");
        txtBookName.setText("");
        txtGenre.setText("");
        txtAuthor.setText("");
        txtBookCount.setText("");
        lblBranch.setText("");
        txtBranchSearch.setText("");
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = lblBooksId.getText();
        String title = txtBookName.getText();
        String genre = txtGenre.getText();
        String author = txtAuthor.getText();
        String branchID = lblBranchID.getText();
        String qty = txtBookCount.getText();
        String branchName = lblBranch.getText();

        try {
            boolean isSaved = booksBO.saveBooks(new BooksDto(id,title,genre,author,branchID,branchName,qty));
            if (isSaved) {
                clearFields();
                generateNextID();
                loadAllBooks();
                totalBooks();
                new Alert(Alert.AlertType.CONFIRMATION,"Book is Added").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = lblBooksId.getText();
        String title = txtBookName.getText();
        String genre = txtGenre.getText();
        String author = txtAuthor.getText();
        String branchID = lblBranchID.getText();
        String qty = txtBookCount.getText();
        String branchName = lblBranch.getText();
        String available = null;

        try {
            boolean isUpdated = booksBO.updateBooks(new BooksDto(id,title,genre,author,branchID,branchName,qty));
            if (isUpdated) {
                clearFields();
                loadAllBooks();
                generateNextID();
                totalBooks();
                new Alert(Alert.AlertType.CONFIRMATION,"Book Is Updated").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void txtAuthorGoToBookCountOnAction(ActionEvent event) {

    }

    @FXML
    void txtBookGoToGenreOnAction(ActionEvent event) {

    }

    @FXML
    void txtBooksSearchOnAction(ActionEvent event) {
        searchTableFilter();

    }

    private void searchTableFilter() {
        FilteredList<BooksTm> filteredBookList = new FilteredList<>(obList, b -> true);
        txtBookSearch.textProperty().addListener((observable,oldValue,newValue) -> {
            filteredBookList.setPredicate(booksTm -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();

                if (booksTm.getBookID().toLowerCase().contains(search)) {
                    return true;
                } else if (booksTm.getBookID().toLowerCase().contains(search)) {
                    return true;
                } else if (booksTm.getTitle().toLowerCase().contains(search)) {
                    return true;
                } else if (booksTm.getTitle().toLowerCase().contains(search)) {
                    return true;
                } else if (booksTm.getAuthor().toLowerCase().contains(search)) {
                    return true;
                } else if (booksTm.getAuthor().toLowerCase().contains(search)) {
                    return true;
                } else if (booksTm.getQty().toLowerCase().contains(search)) {
                    return true;
                } else if (booksTm.getQty().toLowerCase().contains(search)) {
                    return true;
                } else if (booksTm.getBranchID().toLowerCase().contains(search)) {
                    return true;
                } else if (booksTm.getBranchID().toLowerCase().contains(search)) {
                    return true;
                } else if (booksTm.getGenre().toLowerCase().contains(search)) {
                    return true;
                } else if (booksTm.getGenre().toLowerCase().contains(search)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<BooksTm> sortedList = new SortedList<>(filteredBookList);
        sortedList.comparatorProperty().bind(tblBooks.comparatorProperty());
        tblBooks.setItems(sortedList);

    }

    @FXML
    void txtBranchSearchOnAction(ActionEvent event) {
        String searchInput = txtBranchSearch.getText();
        try {
            BranchesDto branchesDto;
            branchesDto = branchBO.searchBranch(searchInput);
            if (branchesDto != null) {
                txtBranchSearch.setText("");
                lblBranchID.setText(branchesDto.getId());
                lblBranch.setText(branchesDto.getBranchName());
            } else {
                new Alert(Alert.AlertType.ERROR,"Branch Doesn't Exist").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void txtGenreGoToAuthorOnAction(ActionEvent event) {

    }

}

