package lk.ijse.BookBar.bo.custom;

import lk.ijse.BookBar.bo.SuperBO;
import lk.ijse.BookBar.dto.UserDto;

import java.sql.SQLException;

public interface UserBO extends SuperBO {

    boolean saveUser(UserDto dto) throws SQLException;
}
