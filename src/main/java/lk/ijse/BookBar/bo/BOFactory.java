package lk.ijse.BookBar.bo;

import lk.ijse.BookBar.bo.custom.impl.BooksBoImpl;
import lk.ijse.BookBar.bo.custom.impl.BranchesBOimpl;
import lk.ijse.BookBar.bo.custom.impl.MembersBoImpl;
import lk.ijse.BookBar.bo.custom.impl.UserBOimpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {}

    public static BOFactory getBoFactory () {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes {
        USER, MEMBERS, BRANCHES,BOOKS
    }

    public SuperBO grtBo(BOTypes boTypes) {
        switch (boTypes) {
            case USER:
                return new UserBOimpl();
            case BRANCHES:
                return new BranchesBOimpl();
            case MEMBERS:
                return new MembersBoImpl();
            case BOOKS:
                return new BooksBoImpl();
            default:
                return null;
        }
    }
}
