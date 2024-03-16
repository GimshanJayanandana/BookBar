package lk.ijse.BookBar.bo.custom.impl;

import lk.ijse.BookBar.bo.custom.BooksBO;
import lk.ijse.BookBar.dao.DAOFactory;
import lk.ijse.BookBar.dao.custom.BooksDAO;
import lk.ijse.BookBar.dto.BooksDto;
import lk.ijse.BookBar.entity.Books;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksBoImpl implements BooksBO {

    BooksDAO booksDAO = (BooksDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOKS);

    @Override
    public boolean saveBooks(BooksDto dto) throws SQLException {
        return booksDAO.save(new Books(
                dto.getBookID(),
                dto.getTitle(), dto.getGenre(), dto.getAuthor(), dto.getBranchID(), dto.getBranchName(), dto.getQty()));
    }

    @Override
    public boolean updateBooks(BooksDto dto) throws SQLException, ClassNotFoundException {
        return booksDAO.update(new Books(
                dto.getBookID(),
                dto.getTitle(), dto.getGenre(), dto.getAuthor(), dto.getBranchID(), dto.getBranchName(), dto.getQty()));

    }

    @Override
    public boolean deleteBooks(String id) throws SQLException, ClassNotFoundException {
        return booksDAO.delete(id);
    }

    @Override
    public BooksDto searchBooks(String name) throws SQLException, ClassNotFoundException {
        Books dto = booksDAO.search(name);
        if (dto != null) {
            return new BooksDto(dto.getBookID(),
                    dto.getTitle(), dto.getGenre(), dto.getAuthor(), dto.getBranchID(), dto.getBranchName(), dto.getQty());
        } else {
            return null;
        }
    }

    @Override
    public List<BooksDto> getAllBooks() throws SQLException, ClassNotFoundException {
        List<BooksDto> books = new ArrayList<>();
        List<Books> list = booksDAO.getAll();
        for (Books book : list) {
            books.add(new BooksDto(
                    book.getBookID(),
                    book.getTitle(), book.getGenre(), book.getAuthor(), book.getBranchID(), book.getBranchName(), book.getQty()));
        }
        return books;
    }

    @Override
    public String generateBookID() {
        return booksDAO.generateNextID();
    }

    @Override
    public BooksDto searchBooksByID(String searchInput) throws SQLException, ClassNotFoundException {
        Books dto = booksDAO.searchByID(searchInput);
        if (dto != null) {
            return new BooksDto(dto.getBookID(),
                    dto.getTitle(), dto.getGenre(), dto.getAuthor(), dto.getBranchID(), dto.getBranchName(),dto.getQty());
        } else {
            return null;
        }
    }
}
