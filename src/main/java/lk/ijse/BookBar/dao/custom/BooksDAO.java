package lk.ijse.BookBar.dao.custom;

import lk.ijse.BookBar.dao.CrudDAO;
import lk.ijse.BookBar.entity.Books;

public interface BooksDAO extends CrudDAO<Books> {
    Books searchByID(String searchInput);
    String getTotalBooks();

}
