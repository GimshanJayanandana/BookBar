package lk.ijse.BookBar.dao.custom;

import lk.ijse.BookBar.dao.CrudDAO;
import lk.ijse.BookBar.entity.Branches;

public interface BranchDAO extends CrudDAO<Branches> {
    String[] searchID(String id);
}
