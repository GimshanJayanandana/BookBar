package lk.ijse.BookBar.bo.custom.impl;

import lk.ijse.BookBar.bo.custom.UserBO;
import lk.ijse.BookBar.dao.DAOFactory;
import lk.ijse.BookBar.dao.custom.UserDAO;
import lk.ijse.BookBar.dto.UserDto;
import lk.ijse.BookBar.entity.User;

import java.sql.SQLException;

public class UserBOimpl implements UserBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean saveUser(UserDto dto) throws SQLException {
        return userDAO.save(new User(dto.getUserName(), dto.getEmail(), dto.getPassword()));
    }
}
