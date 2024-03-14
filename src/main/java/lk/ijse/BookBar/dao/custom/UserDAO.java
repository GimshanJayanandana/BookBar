package lk.ijse.BookBar.dao.custom;

import lk.ijse.BookBar.dao.CrudDAO;
import lk.ijse.BookBar.entity.User;

public interface UserDAO extends CrudDAO<User> {

    boolean isValidUser(String name,String password);
}
