package lk.ijse.BookBar.dao;

import lk.ijse.BookBar.dao.impl.UserDAOimpl;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        USER
    }

    public SuperDAO getDAO (DAOTypes types) {
        switch (types) {
            case USER:
                return new UserDAOimpl();
            default:
                return null;
        }
    }
}
