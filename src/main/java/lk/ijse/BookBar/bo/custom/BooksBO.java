package lk.ijse.BookBar.bo.custom;

import lk.ijse.BookBar.bo.SuperBO;
import lk.ijse.BookBar.dto.BooksDto;

import java.sql.SQLException;
import java.util.List;

public interface BooksBO extends SuperBO {

    boolean saveBooks(BooksDto dto) throws SQLException;

    boolean updateBooks(BooksDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteBooks(String id) throws SQLException, ClassNotFoundException;

    BooksDto searchBooks(String name) throws SQLException, ClassNotFoundException;

    List<BooksDto> getAllBooks() throws SQLException, ClassNotFoundException;

    String generateBookID();

    BooksDto searchBooksByID(String searchInput) throws SQLException, ClassNotFoundException;

}
