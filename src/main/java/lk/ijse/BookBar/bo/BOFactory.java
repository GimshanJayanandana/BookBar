package lk.ijse.BookBar.bo;

import lk.ijse.BookBar.bo.impl.UserBOimpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {}

    public static BOFactory getBoFactory () {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes {
        USER
    }

    public SuperBO grtBo(BOTypes boTypes) {
        switch (boTypes) {
            case USER:
                return new UserBOimpl();
            default:
                return null;
        }
    }
}
