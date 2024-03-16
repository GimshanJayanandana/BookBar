package lk.ijse.BookBar.dao;

import lk.ijse.BookBar.dao.custom.impl.BranchDAOimpl;
import lk.ijse.BookBar.dao.custom.impl.MembersDAOImpl;
import lk.ijse.BookBar.dao.custom.impl.UserDAOimpl;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        USER,BRANCHES,MEMBERS
    }

    public SuperDAO getDAO (DAOTypes types) {
        switch (types) {
            case USER:
                return new UserDAOimpl();
            case BRANCHES:
                return new BranchDAOimpl();
            case MEMBERS:
                return new MembersDAOImpl();
            default:
                return null;
        }
    }
}
