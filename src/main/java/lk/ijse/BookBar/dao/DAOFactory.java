package lk.ijse.BookBar.dao;

import lk.ijse.BookBar.dao.custom.impl.BranchDAOimpl;
import lk.ijse.BookBar.dao.custom.impl.UserDAOimpl;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        USER,BRANCHES
    }

    public SuperDAO getDAO (DAOTypes types) {
        switch (types) {
            case USER:
                return new UserDAOimpl();
            case BRANCHES:
                return new BranchDAOimpl();
            default:
                return null;
        }
    }
}
